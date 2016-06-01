package com.example.ice.retrofitjsonstring.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.ice.retrofitjsonstring.DataAdapter.NewsDataAdapter;
import com.example.ice.retrofitjsonstring.News;
import com.example.ice.retrofitjsonstring.R;
import com.example.ice.retrofitjsonstring.RetrofitCeleAPI;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    public static final String ROOT_URL = "http://celebrity-test.herokuapp.com";

    private RecyclerView recyclerView;
    private List<News> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getNews();
    }

    private void getNews(){

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please wait...", false, false);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        RetrofitCeleAPI api = adapter.create(RetrofitCeleAPI.class);

        api.getNews(new Callback<List<News>>() {
            @Override
            public void success(List<News> list, Response response) {
                loading.dismiss();
                news = list;
                Toast.makeText(getApplicationContext(),"ReturnNewsList is :" + news.size(),Toast.LENGTH_LONG).show();
                NewsDataAdapter adapter = new NewsDataAdapter(news);
                 recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }



}
