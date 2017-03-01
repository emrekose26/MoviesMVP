package com.emrekose.moviesmvp.di.toprated;

import com.emrekose.moviesmvp.di.PerFragment;
import com.emrekose.moviesmvp.model.api.ApiSource;
import com.emrekose.moviesmvp.mvp.presenter.toprated.TopRatedPresenter;
import com.emrekose.moviesmvp.mvp.view.toprated.ITopRatedView;
import com.emrekose.moviesmvp.ui.fragment.TopRatedFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emrekose on 1.03.2017.
 */

@Module
public class TopRatedModule {

    ITopRatedView topRatedView;
    TopRatedFragment fragment;

    public TopRatedModule(ITopRatedView topRatedView) {
        this.topRatedView = topRatedView;
    }

    @Provides
    @PerFragment
    TopRatedFragment provideFragment() {
        return fragment;
    }
    @Provides
    @PerFragment
    TopRatedPresenter provideTopRatedPresenter(ApiSource apiSource) {
        return new TopRatedPresenter(topRatedView,apiSource);
    }
}
