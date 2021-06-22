package com.release.androidbatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.release.androidbatch2.Login.Vehicle;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text1);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });

        Log.v("Paresh","User is Online");

    }


    @Override
    protected void onStart() {
        super.onStart();


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Paresh","User is Online");

//        in oresume i call data from db


    }


    //////////////Running State////////////////////////////////


    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Paresh","User is Away");
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Paresh","User is offline");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "PLease back again to exit!", Toast.LENGTH_SHORT).show();
    }
}