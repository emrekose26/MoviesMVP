package com.emrekose.moviesmvp.event;

import com.emrekose.moviesmvp.model.entity.toprated.TopRatedResults;

/**
 * Created by emrekose on 1.03.2017.
 */

public class TopRatedDetailEvent {
    TopRatedResults results;

    public TopRatedDetailEvent(TopRatedResults results) {
        this.results = results;
    }

    public TopRatedResults getResults() {
        return results;
    }

    public void setResults(TopRatedResults results) {
        this.results = results;
    }
}
