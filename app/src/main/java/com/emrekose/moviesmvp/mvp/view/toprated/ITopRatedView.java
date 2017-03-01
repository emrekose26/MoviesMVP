package com.emrekose.moviesmvp.mvp.view.toprated;

import com.emrekose.moviesmvp.model.entity.toprated.TopRatedResults;

import java.util.List;

/**
 * Created by emrekose on 1.03.2017.
 */

public interface ITopRatedView {
    void showProgress();

    void hideProgress();

    void showTopRatedMovies(List<TopRatedResults> topRatedResultsList);
}
