package com.js.soundmeter.utils.permission;

import androidx.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class Permission {
    public final String name;// 权限名
    public final boolean granted;// 是否同意
    public final boolean shouldShowRequestPermissionRationale;// true =（被拒绝过一次，没勾选“下次不在询问”）
    // 第一次打开App时     false
    // 上次弹出权限点击了禁止（但没有勾选“下次不在询问”）   true
    // 上次选择禁止并勾选：下次不在询问     false

    public Permission(String name, boolean granted) {
        this(name, granted, false);
    }

    public Permission(String name, boolean granted, boolean shouldShowRequestPermissionRationale) {
        this.name = name;
        this.granted = granted;
        this.shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale;
    }

    public Permission(List<Permission> permissions) {
        name = combineName(permissions);
        granted = combineGranted(permissions);
        shouldShowRequestPermissionRationale = combineShouldShowRequestPermissionRationale(permissions);
    }

    @Override
    @SuppressWarnings("SimplifiableIfStatement")
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Permission that = (Permission) o;

        if (granted != that.granted) return false;
        if (shouldShowRequestPermissionRationale != that.shouldShowRequestPermissionRationale)
            return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (granted ? 1 : 0);
        result = 31 * result + (shouldShowRequestPermissionRationale ? 1 : 0);
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", granted=" + granted +
                ", shouldShowRequestPermissionRationale=" + shouldShowRequestPermissionRationale +
                '}';
    }

    private String combineName(List<Permission> permissions) {
        return Observable.fromIterable(permissions)
                .map(permission -> permission.name).collectInto(new StringBuilder(), (s, s2) -> {
                    if (s.length() == 0) {
                        s.append(s2);
                    } else {
                        s.append(", ").append(s2);
                    }
                }).blockingGet().toString();
    }

    private Boolean combineGranted(List<Permission> permissions) {
        return Observable.fromIterable(permissions)
                .all(permission -> permission.granted).blockingGet();
    }

    private Boolean combineShouldShowRequestPermissionRationale(List<Permission> permissions) {
        return Observable.fromIterable(permissions)
                .any(permission -> permission.shouldShowRequestPermissionRationale).blockingGet();
    }
}
