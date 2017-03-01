package com.emrekose.moviesmvp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emrekose.moviesmvp.MoviesApp;
import com.emrekose.moviesmvp.R;
import com.emrekose.moviesmvp.di.popular.DaggerPopularComponent;
import com.emrekose.moviesmvp.di.popular.PopularModule;
import com.emrekose.moviesmvp.model.entity.popular.PopularResults;
import com.emrekose.moviesmvp.mvp.view.popular.IPopularView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment implements IPopularView{


    public PopularFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.bind(this,view);

        initInjector();

        return view;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showPopularMovies(List<PopularResults> popularResultsList) {

    }

    private void initInjector() {
        DaggerPopularComponent.builder()
                .appComponent(MoviesApp.get(this.getContext()).getAppComponent())
                .popularModule(new PopularModule(this))
                .build().inject(this);
    }
}
