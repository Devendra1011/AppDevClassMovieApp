package com.devdeveloper.movieapp.serviceapi;

import com.devdeveloper.movieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    /*
     * The service interface defines the structure and behaviour of the api request act as a bridge between app and api*/


    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

}
