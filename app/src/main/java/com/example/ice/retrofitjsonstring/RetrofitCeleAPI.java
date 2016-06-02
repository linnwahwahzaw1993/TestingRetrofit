package com.example.ice.retrofitjsonstring;

import android.telecom.Call;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by ICE on 30-May-16.
 */
public interface RetrofitCeleAPI {
    @GET("/api/news")
    public void getNews(Callback<List<News>> response);

    @GET("/api/celes")
    public void getCelebirity(Callback<List<Celebirity>> response);

    @GET("/api/photos")
    public void getPhotos(Callback<List<Photo>> response);

    @GET("/api/testing")
    public void getInfo(Callback<String> response); //only for testing

}
