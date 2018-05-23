package ru.lenarlenar.vkmessenger;

import android.app.Application;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ленар on 18.05.2018.
 */

public class App extends Application {

    private static BaseApplicationComponent applicationComponent;

    public static BaseApplicationComponent component() {
        return applicationComponent;
    }


    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(getApplicationContext());


        applicationComponent = DaggerApp_ApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Singleton
    @Component(modules = {AppModule.class})
    interface ApplicationComponent extends BaseApplicationComponent {
    }

    public interface BaseApplicationComponent {

        Application application();

        VkService vkService();

    }
}
