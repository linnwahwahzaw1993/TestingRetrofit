package com.example.ice.retrofitjsonstring.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ice.retrofitjsonstring.R;

/**
 * Created by ICE on 30-May-16.
 */
public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btnGetAllNews = (Button) findViewById(R.id.btnGetAllNews);
        Button btnGetAllCele = (Button) findViewById(R.id.btnGetAllCele);
        btnGetAllCele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this,CelebirityActivity.class);
                startActivity(myIntent);

            }
        });
        btnGetAllNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        Button btnGetAllPhoto = (Button) findViewById(R.id.btnGetAllPhoto);
        btnGetAllPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, PhotoActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
