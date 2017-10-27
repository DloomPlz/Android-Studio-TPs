package com.example.neost.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neost.myapplication.data.AdressBookApi;
import com.example.neost.myapplication.data.Group;
import com.example.neost.myapplication.data.HNArticlesAdapter;
import com.example.neost.myapplication.R;
import com.oc.hnapp.android.HNQueryTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private HNQueryTask _task = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Adapter
        HNArticlesAdapter adapter = new HNArticlesAdapter();
        recyclerView.setAdapter(adapter);

        //Task Config
        _task = new HNQueryTask(adapter,80,1);
        _task.execute();

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        _task.cancel(true);
    }





}



