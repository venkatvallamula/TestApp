package com.example.testapp.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.testapp.R;
import com.example.testapp.model.Item;

public class UserDetails extends AppCompatActivity {
    private static final String TAG =UserDetails.class.getSimpleName() ;
    private Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        item = getIntent().getParcelableExtra("userDetails");
        Log.d(TAG,item.getDisplayName()+"------"+item.getUserType());
    }

}
