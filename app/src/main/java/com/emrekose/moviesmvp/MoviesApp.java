package com.emrekose.moviesmvp;

import android.app.Application;
import android.content.Context;

import com.emrekose.moviesmvp.di.app.AppComponent;
import com.emrekose.moviesmvp.di.app.AppModule;
import com.emrekose.moviesmvp.di.app.DaggerAppComponent;
import com.emrekose.moviesmvp.di.app.NetworkModule;

import timber.log.Timber;

/**
 * Created by emrekose on 1.03.2017.
 */

public class MoviesApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public static MoviesApp get(Context context) {
        return (MoviesApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
