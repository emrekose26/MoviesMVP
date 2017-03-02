package com.emrekose.moviesmvp.di.detail;

import com.emrekose.moviesmvp.di.PerActivity;
import com.emrekose.moviesmvp.di.app.AppComponent;
import com.emrekose.moviesmvp.ui.activity.MovieDetailActivity;

import dagger.Component;

/**
 * Created by emrekose on 2.03.2017.
 */
@PerActivity
@Component(modules = DetailModule.class, dependencies = AppComponent.class)
public interface DetailComponent {
    void inject(MovieDetailActivity activity);
}
