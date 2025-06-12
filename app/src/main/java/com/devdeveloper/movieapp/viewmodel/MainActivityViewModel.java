package com.devdeveloper.movieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.devdeveloper.movieapp.model.Movie;
import com.devdeveloper.movieapp.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends  AndroidViewModel{

    private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);

    }


    public LiveData<List<Movie>>  getAllMovies(){
        return movieRepository.getMutableLiveData();
    }



}
