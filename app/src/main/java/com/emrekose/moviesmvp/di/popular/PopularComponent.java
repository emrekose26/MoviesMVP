package com.emrekose.moviesmvp.di.popular;

import com.emrekose.moviesmvp.di.PerFragment;
import com.emrekose.moviesmvp.di.app.AppComponent;
import com.emrekose.moviesmvp.ui.fragment.PopularFragment;

import dagger.Component;

/**
 * Created by emrekose on 1.03.2017.
 */

@PerFragment
@Component(dependencies = AppComponent.class, modules = PopularModule.class)
public interface PopularComponent {
    void inject(PopularFragment fragment);
}
