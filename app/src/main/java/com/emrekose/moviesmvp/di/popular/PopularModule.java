package com.emrekose.moviesmvp.di.popular;

import com.emrekose.moviesmvp.di.PerFragment;
import com.emrekose.moviesmvp.model.api.ApiSource;
import com.emrekose.moviesmvp.mvp.presenter.popular.PopularPresenter;
import com.emrekose.moviesmvp.mvp.view.popular.IPopularView;
import com.emrekose.moviesmvp.ui.fragment.PopularFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emrekose on 1.03.2017.
 */

@Module
public class PopularModule {

    IPopularView popularView;
    PopularFragment popularFragment;

    public PopularModule(IPopularView popularView) {
        this.popularView = popularView;
    }

    @Provides
    @PerFragment
    PopularFragment provideFragment() {
        return popularFragment;
    }
    @Provides
    @PerFragment
    PopularPresenter providePopularPresenter(ApiSource apiSource) {
        return new PopularPresenter(popularView,apiSource);
    }
}
