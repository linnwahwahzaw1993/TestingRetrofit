package com.example.ice.retrofitjsonstring.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.ice.retrofitjsonstring.DataAdapter.NewsDataAdapter;
import com.example.ice.retrofitjsonstring.DataAdapter.PhotoDataAdapter;
import com.example.ice.retrofitjsonstring.News;
import com.example.ice.retrofitjsonstring.Photo;
import com.example.ice.retrofitjsonstring.R;
import com.example.ice.retrofitjsonstring.RetrofitCeleAPI;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ICE on 30-May-16.
 */
public class PhotoActivity extends AppCompatActivity{
    public static final String ROOT_URL = "http://celebrity-test.herokuapp.com";

    private RecyclerView recyclerView;
    private List<Photo> photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getPhotos();

    }
    public void getPhotos(){

            final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please wait...", false, false);
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ROOT_URL)
                    .build();

            RetrofitCeleAPI api = adapter.create(RetrofitCeleAPI.class);

            api.getPhotos(new Callback<List<Photo>>() {
                @Override
                public void success(List<Photo> list, Response response) {
                    loading.dismiss();
                    photo = list;
                    Toast.makeText(getApplicationContext(), "ReturnNewsList is :" + photo.size(), Toast.LENGTH_LONG).show();
                    PhotoDataAdapter adapter = new PhotoDataAdapter(photo, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void failure(RetrofitError error) {
                }
            });
    }
}
