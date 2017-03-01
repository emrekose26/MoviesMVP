package com.emrekose.moviesmvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emrekose.moviesmvp.R;
import com.emrekose.moviesmvp.model.entity.toprated.TopRatedResults;
import com.emrekose.moviesmvp.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emrekose on 1.03.2017.
 */

public class TopRatedRecyclerViewAdapter extends RecyclerView.Adapter<TopRatedRecyclerViewAdapter.ViewHolder> {

    private List<TopRatedResults> topRatedResultsList;
    private Context context;

    public TopRatedRecyclerViewAdapter(List<TopRatedResults> topRatedResultsList, Context context) {
        this.topRatedResultsList = topRatedResultsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movies, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TopRatedResults results = topRatedResultsList.get(position);

        holder.title.setText(results.getTitle());
        holder.year.setText(results.getRelease_date());

        Glide.with(context)
                .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W185 + results.getPoster_path())
                .placeholder(R.drawable.movieicon)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return topRatedResultsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.moviePoster)
        ImageView poster;
        @BindView(R.id.movieTitle)
        TextView title;
        @BindView(R.id.movieYear)
        TextView year;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
