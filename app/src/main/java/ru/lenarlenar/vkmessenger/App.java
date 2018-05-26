package ru.lenarlenar.vkmessenger;

import android.app.Application;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

import javax.inject.Singleton;

import dagger.Component;
import ru.lenarlenar.vkmessenger.ui.DialogsFragment;
import ru.lenarlenar.vkmessenger.ui.ProfileFragment;

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
    public interface ApplicationComponent extends BaseApplicationComponent {
        void inject(ProfileFragment activity);
        void inject(DialogsFragment activity);
    }

    public interface BaseApplicationComponent {

        Application application();

        VkService vkService();

    }
}
