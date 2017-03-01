package com.emrekose.moviesmvp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrekose.moviesmvp.MoviesApp;
import com.emrekose.moviesmvp.R;
import com.emrekose.moviesmvp.di.popular.DaggerPopularComponent;
import com.emrekose.moviesmvp.di.popular.PopularModule;
import com.emrekose.moviesmvp.model.entity.popular.PopularResults;
import com.emrekose.moviesmvp.mvp.presenter.popular.PopularPresenter;
import com.emrekose.moviesmvp.mvp.view.popular.IPopularView;
import com.emrekose.moviesmvp.ui.adapter.PopularRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment implements IPopularView {

    @BindView(R.id.popular_movies_recyclerView) RecyclerView recyclerView;
    @BindView(R.id.popular_movies_swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    @Inject PopularPresenter presenter;

    PopularRecyclerViewAdapter adapter;

    public PopularFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.bind(this, view);

        initInjector();

        presenter.loadPopularMovies();

        return view;
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPopularMovies(List<PopularResults> popularResultsList) {
        adapter = new PopularRecyclerViewAdapter(popularResultsList, getContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
    }

    private void initInjector() {
        DaggerPopularComponent.builder()
                .appComponent(MoviesApp.get(this.getContext()).getAppComponent())
                .popularModule(new PopularModule(this))
                .build().inject(this);
    }
}
