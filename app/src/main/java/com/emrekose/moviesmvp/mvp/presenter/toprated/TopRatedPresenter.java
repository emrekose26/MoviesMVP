package com.emrekose.moviesmvp.mvp.presenter.toprated;

import com.emrekose.moviesmvp.model.api.ApiSource;
import com.emrekose.moviesmvp.mvp.view.toprated.ITopRatedView;
import com.emrekose.moviesmvp.util.Constants;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by emrekose on 1.03.2017.
 */

public class TopRatedPresenter implements ITopRatedPresenter {

    private ITopRatedView view;
    private ApiSource apiSource;

    @Inject
    public TopRatedPresenter(ITopRatedView view, ApiSource apiSource) {
        this.view = view;
        this.apiSource = apiSource;
    }

    @Override
    public void loadTopRatedMovies() {
        view.showProgress();

        apiSource.getTopRatedMovies(Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(topRatedResponse -> {
                            view.hideProgress();
                            view.showTopRatedMovies(topRatedResponse.getTopRatedResultsList());
                        },
                        e -> Timber.e(e.getMessage()));
    }
}
