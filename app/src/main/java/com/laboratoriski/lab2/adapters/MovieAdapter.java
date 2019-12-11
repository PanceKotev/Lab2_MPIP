package com.laboratoriski.lab2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.laboratoriski.lab2.R;
import com.laboratoriski.lab2.models.OMovie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private List<OMovie> movies=new ArrayList<>();
    View.OnClickListener listener;

    public MovieAdapter(View.OnClickListener listener){
        this.listener=listener;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list,parent,false);
        return new MovieHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.setText(movies.get(position).Title, listener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    public void updateDataset(List<OMovie> newDataset) {
        this.movies = newDataset;
        notifyDataSetChanged();
    }
    public String getClickedItemId(MovieHolder holder) {
        int adapterPosition = holder.getAdapterPosition();
        return movies.get(adapterPosition).imdbID;
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        private TextView textMovieTitle;
        private TextView textMovieYear;
        private ImageView imageViewPoster;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            textMovieTitle=itemView.findViewById(R.id.txtMovieTitle);
            textMovieYear=itemView.findViewById(R.id.txtMovieYear);
            imageViewPoster=itemView.findViewById(R.id.imageViewPoster);
            itemView.setTag(this);

        }
        public void setText(String text,View.OnClickListener listener){
            textMovieTitle.setText(text);
            imageViewPoster.setImageResource(R.drawable.ic_launcher_background);
            itemView.setOnClickListener(listener);
        }
    }
}
