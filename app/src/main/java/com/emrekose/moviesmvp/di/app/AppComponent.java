package com.emrekose.moviesmvp.di.app;

import com.emrekose.moviesmvp.model.api.ApiSource;
import com.emrekose.moviesmvp.util.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by emrekose on 1.03.2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    ApiSource apiSource();
    RxBus rxbus();
}
