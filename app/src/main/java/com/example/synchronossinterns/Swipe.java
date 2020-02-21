package com.example.synchronossinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Swipe extends MainActivity {
    private static final String TAG = "Main Activity 2";
    private Button Next;
    private String Username;

 public Swipe(String Usernamefinal){
     this.Username=Usernamefinal;
 }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: ttttttttttt");

        Next = (Button) findViewById(R.id.Next);

    }}