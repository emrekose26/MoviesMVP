package com.emrekose.moviesmvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.emrekose.moviesmvp.MoviesApp;
import com.emrekose.moviesmvp.R;
import com.emrekose.moviesmvp.di.detail.DaggerDetailComponent;
import com.emrekose.moviesmvp.di.detail.DetailModule;
import com.emrekose.moviesmvp.event.PopularDetailEvent;
import com.emrekose.moviesmvp.event.TopRatedDetailEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    @Inject
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        initInjector();
    }

    @Subscribe(sticky = true)
    public void onPopularMovieDetailEvent(PopularDetailEvent event) {
        Toast.makeText(this, event.getResults().getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe(sticky = true)
    public void onTopRatedMovieDetail(TopRatedDetailEvent event) {
        Toast.makeText(this, event.getResults().getTitle(), Toast.LENGTH_SHORT).show();
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
