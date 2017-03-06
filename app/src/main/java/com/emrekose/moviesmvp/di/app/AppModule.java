package com.emrekose.moviesmvp.di.app;

import android.app.Application;
import android.content.Context;

import com.emrekose.moviesmvp.util.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emrekose on 1.03.2017.
 */

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    Context provideAppContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    RxBus provideRxBus(){
        return RxBus.getInstance();
    }
}
