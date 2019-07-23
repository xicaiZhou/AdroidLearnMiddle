package com.example.androidlearnmiddle.Glide.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        initNavBar("Glide");
    }


    @OnClick(R.id.base_glide)
    void base_glide(View V) {
        startActivity(new Intent(GlideActivity.this, BaseGlideActivity.class));
    }
    @OnClick(R.id.RecycleView_glide)
    void RecycleView_glide(View V) {
        startActivity(new Intent(GlideActivity.this, RecycleViewGlideActivity.class));

    }
    @OnClick(R.id.tranfromation_glide)
    void tranfromation_glide(View V) {
        startActivity(new Intent(GlideActivity.this, TranfromationGlideActivity.class));

    }
}
