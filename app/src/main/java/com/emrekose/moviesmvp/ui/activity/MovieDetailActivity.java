package com.emrekose.moviesmvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emrekose.moviesmvp.MoviesApp;
import com.emrekose.moviesmvp.R;
import com.emrekose.moviesmvp.di.detail.DaggerDetailComponent;
import com.emrekose.moviesmvp.di.detail.DetailModule;
import com.emrekose.moviesmvp.event.PopularDetailEvent;
import com.emrekose.moviesmvp.event.TopRatedDetailEvent;
import com.emrekose.moviesmvp.util.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    @Inject EventBus eventBus;

    @BindView(R.id.coverImage) ImageView coverImage;
    @BindView(R.id.detail_title) TextView detailTitle;
    @BindView(R.id.detail_backdrop) ImageView detailBackdrop;
    @BindView(R.id.release_date) TextView releaseDate;
    @BindView(R.id.detail_overview) TextView detailOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        // for transparent status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        initInjector();
    }

    @Subscribe(sticky = true)
    public void onPopularMovieDetailEvent(PopularDetailEvent event) {
        detailTitle.setText(event.getResults().getTitle());
        releaseDate.setText(event.getResults().getRelease_date());
        detailOverview.setText(event.getResults().getOverview());

        Glide.with(this)
                .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W342 + event.getResults().getPoster_path())
                .fitCenter()
                .placeholder(R.drawable.movieicon)
                .into(detailBackdrop);

        Glide.with(this)
                .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W780 + event.getResults().getBackdrop_path())
                .into(coverImage);
    }

    @Subscribe(sticky = true)
    public void onTopRatedMovieDetail(TopRatedDetailEvent event) {
        detailTitle.setText(event.getResults().getTitle());
        releaseDate.setText(event.getResults().getRelease_date());
        detailOverview.setText(event.getResults().getOverview());

        Glide.with(this)
                .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W342 + event.getResults().getPoster_path())
                .fitCenter()
                .placeholder(R.drawable.movieicon)
                .into(detailBackdrop);

        Glide.with(this)
                .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W780 + event.getResults().getBackdrop_path())
                .into(coverImage);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        super.onStop();
        eventBus.removeAllStickyEvents();
    }

    private void initInjector() {
        DaggerDetailComponent.builder()
                .appComponent(MoviesApp.get(this).getAppComponent())
                .detailModule(new DetailModule())
                .build().inject(this);
    }
}
