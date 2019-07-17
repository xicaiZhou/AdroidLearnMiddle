package com.example.androidlearnmiddle;

import android.app.Application;
import android.content.Context;

import com.example.androidlearnmiddle.retrofit.NetWorking.ApiClient;

public class ApplicationContext extends Application {

    private static ApplicationContext context;
    private ApiClient mApiClient;

    public ApiClient getApiClient(){
        return mApiClient;
    }

    public static ApplicationContext getContext(){
        return context;
    }

    public ApiClient getApi(){
        return mApiClient;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApiClient = ApiClient.init();
    }

}
