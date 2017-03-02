package com.emrekose.moviesmvp.event;

import com.emrekose.moviesmvp.model.entity.popular.PopularResults;

/**
 * Created by emrekose on 1.03.2017.
 */

public class PopularDetailEvent {
    PopularResults results;

    public PopularDetailEvent(PopularResults results) {
        this.results = results;
    }

    public PopularResults getResults() {
        return results;
    }

    public void setResults(PopularResults results) {
        this.results = results;
    }
}
