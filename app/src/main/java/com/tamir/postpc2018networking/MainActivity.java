package com.tamir.postpc2018networking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String URL_BASE = "https://api.imgur.com";
    RecyclerView mRecycler;
    ImagesAdapter mImagesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = findViewById(R.id.main_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mImagesAdapter = new ImagesAdapter();
        mRecycler.setAdapter(mImagesAdapter);
        Button mButton = findViewById(R.id.main_button);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Retrofit.Builder retrofitBuilder =
                        new Retrofit.Builder()
                                .baseUrl(URL_BASE)
                                .addConverterFactory(GsonConverterFactory.create());

            }
        });

    }
}
