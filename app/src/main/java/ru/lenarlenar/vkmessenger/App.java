package ru.lenarlenar.vkmessenger;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Ленар on 18.05.2018.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(getApplicationContext());
    }
}
