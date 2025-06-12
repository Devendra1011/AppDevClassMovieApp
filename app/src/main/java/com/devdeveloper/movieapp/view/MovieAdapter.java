package com.devdeveloper.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.devdeveloper.movieapp.R;
import com.devdeveloper.movieapp.databinding.MovieLayoutBinding;
import com.devdeveloper.movieapp.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movieArrayList;

    // constructor


    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.movie_layout, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);

        holder.movieLayoutBinding.setMovie(movie);


    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieLayoutBinding movieLayoutBinding;

        public MovieViewHolder(MovieLayoutBinding movieLayoutBinding) {
            // calling the parent constructor
            super(movieLayoutBinding.getRoot());
            this.movieLayoutBinding = movieLayoutBinding;
            movieLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  code will run when you click in item
                }
            });
        }
    }
}
