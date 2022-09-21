package com.js.soundmeter.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast toast;

    public static void showMessage(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}
