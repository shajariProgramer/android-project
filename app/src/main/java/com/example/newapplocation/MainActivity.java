package com.example.newapplocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerAppComponent.builder()
//                .dataModule(new DataModule())
//                .apiModule(new ApiModule(BuildConfig.BASE_URL))
//                .build();
//        DaggerApp

    }
}