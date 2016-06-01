package com.example.ice.retrofitjsonstring.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.ice.retrofitjsonstring.Celebirity;
import com.example.ice.retrofitjsonstring.DataAdapter.CelebirityDataAdapter;
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
public class CelebirityActivity extends AppCompatActivity{
    public static final String ROOT_URL = "http://celebrity-test.herokuapp.com";

    private RecyclerView recyclerView;
    private List<Celebirity> cele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getCelebirity();
    }

    private void getCelebirity(){

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please wait...", false, false);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        RetrofitCeleAPI api = adapter.create(RetrofitCeleAPI.class);

        api.getCelebirity(new Callback<List<Celebirity>>() {
            @Override
            public void success(List<Celebirity> list, Response response) {
                loading.dismiss();
                cele = list;
                Toast.makeText(getApplicationContext(), "ReturnNewsList is :" + cele.size(), Toast.LENGTH_LONG).show();
                CelebirityDataAdapter adapter = new CelebirityDataAdapter(cele,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }
}
