package com.emrekose.moviesmvp.di.detail;

import com.emrekose.moviesmvp.di.PerActivity;
import com.emrekose.moviesmvp.ui.activity.MovieDetailActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emrekose on 2.03.2017.
 */

@Module
public class DetailModule {

    MovieDetailActivity activity;

    @Provides
    @PerActivity
    MovieDetailActivity provideDetailActivity() {
        return activity;
    }
}
