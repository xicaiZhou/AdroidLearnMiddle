package com.example.androidlearnmiddle.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

public class RetrofitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initNavBar("当前最流行的网络请求Retrofit");
    }
}
