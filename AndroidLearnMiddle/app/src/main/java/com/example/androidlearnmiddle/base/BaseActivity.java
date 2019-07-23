package com.example.androidlearnmiddle.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.androidlearnmiddle.R;


public class BaseActivity extends AppCompatActivity {


    private TextView titleLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportActionBar().hide(); //隐藏原有bar

    }

    public void initNavBar(String titleText) {
        titleLabel = findViewById(R.id.title_navbar);
        titleLabel.setText(titleText);
    }
}
