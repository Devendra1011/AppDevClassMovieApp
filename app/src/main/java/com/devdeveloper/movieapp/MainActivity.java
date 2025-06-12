package com.devdeveloper.movieapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.devdeveloper.movieapp.databinding.ActivityMainBinding;
import com.devdeveloper.movieapp.model.Movie;
import com.devdeveloper.movieapp.view.MovieAdapter;
import com.devdeveloper.movieapp.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movieArrayList;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding activityMainBinding;
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.swipe_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getPopularMovies();

         swipeRefreshLayout = activityMainBinding.swipeLayout;
         swipeRefreshLayout.setColorSchemeColors(R.color.black);

         swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
             @Override
             public void onRefresh() {
                 getPopularMovies();
             }
         });
    }

    public void getPopularMovies(){
         viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
             @Override
             public void onChanged(List<Movie> moviesFromLiveData) {
                 movieArrayList =  (ArrayList<Movie>) moviesFromLiveData;
                 // we should call a function
                 displayMoviesInRecyclerView();
             }
         });
    }


    private void displayMoviesInRecyclerView(){
        recyclerView = activityMainBinding.recyclerView;
        movieAdapter = new MovieAdapter(this,movieArrayList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        movieAdapter.notifyDataSetChanged();
    }



}