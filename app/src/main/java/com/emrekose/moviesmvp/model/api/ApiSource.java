package com.emrekose.moviesmvp.model.api;

import com.emrekose.moviesmvp.model.entity.popular.PopularResponse;
import com.emrekose.moviesmvp.model.entity.toprated.TopRatedResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by emrekose on 1.03.2017.
 */

public interface ApiSource {

    // Popular Movies
    @GET("movie/popular")
    Observable<PopularResponse> getPopularMovies(@Query("api_key") String apiKey);

    // Top rated Movies
    @GET("movie/top_rated")
    Observable<TopRatedResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
