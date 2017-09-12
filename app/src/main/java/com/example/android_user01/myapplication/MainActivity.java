package com.example.android_user01.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public final static String LOG = "CursoAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG,"onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG,"onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG,"onStop");
    }
}
