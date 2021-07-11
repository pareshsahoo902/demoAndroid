package com.release.androidbatch2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;

//    List<MOviewMOdel> mOviewMOdels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler);

        //Step 1: create a layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        getAllMOvies();


//        RecyclerAdapter adapter = new RecyclerAdapter(mOviewMOdels, this);

        //Step 2: Create a adapter
//        recyclerView.setAdapter(adapter);

    }

    private void getAllMOvies() {

//        mOviewMOdels = new ArrayList<>();
//        mOviewMOdels.clear();

//        mOviewMOdels.add(new MOviewMOdel("Game Of thrones", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("Harry Potter ", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("Muummy", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("Dronie darko", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("GTA", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("GTA", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("GTA", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("GTA", "9.8", "no summary "));
//        mOviewMOdels.add(new MOviewMOdel("GTA", "9.8", "no summary "));


    }
}