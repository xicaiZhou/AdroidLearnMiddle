package com.example.androidlearnmiddle.RecycleView.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

public class RecycleStaggeredActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_staggered);
        initNavBar("RecycleView瀑布流");

    }
}
