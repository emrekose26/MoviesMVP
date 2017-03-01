package com.emrekose.moviesmvp.mvp.presenter.popular;

import com.emrekose.moviesmvp.model.api.ApiSource;
import com.emrekose.moviesmvp.mvp.view.popular.IPopularView;
import com.emrekose.moviesmvp.util.Constants;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by emrekose on 1.03.2017.
 */

public class PopularPresenter implements IPopularPresenter {

    private IPopularView view;
    private ApiSource apiSource;

    @Inject
    public PopularPresenter(IPopularView view, ApiSource apiSource) {
        this.view = view;
        this.apiSource = apiSource;
    }

    @Override
    public void loadPopularMovies() {
        view.showProgress();

        apiSource.getPopularMovies(Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(popularResponse -> {
                            view.hideProgress();
                            view.showPopularMovies(popularResponse.getPopularResultsList());
                        },
                        e -> Timber.e(e.getMessage()));
    }
}
