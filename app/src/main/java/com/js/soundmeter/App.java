package com.js.soundmeter;

import android.app.Application;

public class App extends Application {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App app() {
        return app;
    }

}
