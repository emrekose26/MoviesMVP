package com.emrekose.moviesmvp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.emrekose.moviesmvp.MoviesApp;
import com.emrekose.moviesmvp.R;
import com.emrekose.moviesmvp.di.toprated.DaggerTopRatedComponent;
import com.emrekose.moviesmvp.di.toprated.TopRatedModule;
import com.emrekose.moviesmvp.model.entity.toprated.TopRatedResults;
import com.emrekose.moviesmvp.mvp.presenter.toprated.TopRatedPresenter;
import com.emrekose.moviesmvp.mvp.view.toprated.ITopRatedView;
import com.emrekose.moviesmvp.ui.adapter.TopRatedRecyclerViewAdapter;
import com.emrekose.moviesmvp.util.RxBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends Fragment implements ITopRatedView {

    @BindView(R.id.topratedProgress) ProgressBar topratedProgress;
    @BindView(R.id.toprated_movies_recyclerView) RecyclerView recyclerView;

    @Inject TopRatedPresenter presenter;
    @Inject RxBus bus;

    TopRatedRecyclerViewAdapter adapter;

    public TopRatedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);
        ButterKnife.bind(this,view);

        initInjector();

        presenter.loadTopRatedMovies();

        return view;
    }

    @Override
    public void showProgress() {
        topratedProgress.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        topratedProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTopRatedMovies(List<TopRatedResults> topRatedResultsList) {
        adapter = new TopRatedRecyclerViewAdapter(topRatedResultsList, getContext(),bus);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
    }

    private void initInjector() {
        DaggerTopRatedComponent.builder()
                .appComponent(MoviesApp.get(getContext()).getAppComponent())
                .topRatedModule(new TopRatedModule(this))
                .build().inject(this);
    }
}
