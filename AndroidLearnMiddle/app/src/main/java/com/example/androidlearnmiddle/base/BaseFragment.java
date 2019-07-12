package com.example.androidlearnmiddle.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {


    public abstract int getLayoutID();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutID(), container, false);
    }
    @Override
    public void onViewCreated(View v, Bundle b) {
        ButterKnife.bind(this, v);
        initData();
        initView();

    }

    public void initView(){

    }

    public void initData(){

    }

    @Override
    public void onDestroy(){
        if(needEventBus()){
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    public boolean needEventBus(){
        return false;
    }
}
