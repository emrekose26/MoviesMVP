package com.emrekose.moviesmvp.di.toprated;

import com.emrekose.moviesmvp.di.PerFragment;
import com.emrekose.moviesmvp.di.app.AppComponent;
import com.emrekose.moviesmvp.ui.fragment.TopRatedFragment;

import dagger.Component;

/**
 * Created by emrekose on 1.03.2017.
 */

@PerFragment
@Component(modules = TopRatedModule.class, dependencies = AppComponent.class)
public interface TopRatedComponent {
    void inject(TopRatedFragment fragment);
}
