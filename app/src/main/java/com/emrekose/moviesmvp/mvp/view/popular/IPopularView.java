package com.emrekose.moviesmvp.mvp.view.popular;

import com.emrekose.moviesmvp.model.entity.popular.PopularResults;

import java.util.List;

/**
 * Created by emrekose on 1.03.2017.
 */

public interface IPopularView {
    void showProgress();

    void hideProgress();

    void showPopularMovies(List<PopularResults> popularResultsList);
}
