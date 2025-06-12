package com.devdeveloper.movieapp.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    /*
    * Act as a central point for request  */

    public static Retrofit retrofit = null;

    public static  String BASE_URL = "https://api.themoviedb.org/3/";


    public static MovieApiService getService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }


        return retrofit.create(MovieApiService.class);
    }
}
