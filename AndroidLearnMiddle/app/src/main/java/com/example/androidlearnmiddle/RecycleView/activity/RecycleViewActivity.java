package com.example.androidlearnmiddle.RecycleView.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecycleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);

        initNavBar("RecycleView学习演示");

    }
    @OnClick(R.id.vertical_rv)
    public void vertical(View v){

        startActivity(new Intent(RecycleViewActivity.this, RecycleVerticalActivity.class));

    }
    @OnClick(R.id.horizontal_rv)
    public void horizontal(View v){
        startActivity(new Intent(RecycleViewActivity.this, RecycleHorizontalActivity.class));

    }
    @OnClick(R.id.gride_rv)
    public void gride(View v){
        startActivity(new Intent(RecycleViewActivity.this, RecycleGrideActivity.class));
    }
    @OnClick(R.id.staggered_rv)
    public void staggered(View v){
        startActivity(new Intent(RecycleViewActivity.this, RecycleStaggeredActivity.class));

    }
    @OnClick(R.id.retrofit_rv)
    public void retrofit(View v){
        startActivity(new Intent(RecycleViewActivity.this, RecycleRetrofitActivity.class));

    }
}
