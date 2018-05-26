package ru.lenarlenar.vkmessenger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ленар on 23.05.2018.
 */

@Module
public class AppModule {
    private final Application application;

    AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application application() {
        return application;
    }

    @Provides
    @Singleton
    VkService provideVkService() {
        return new VkServiceImp();
    }
}
