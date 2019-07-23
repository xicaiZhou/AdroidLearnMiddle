package com.example.androidlearnmiddle.retrofit.NetWorking;

import android.text.TextUtils;

import com.example.androidlearnmiddle.cache.ConfigCache;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddPublicParamsIntercept implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request newRequest = addParam(oldRequest);
        return chain.proceed(newRequest);
    }

    synchronized private Request addParam(Request oldRequest) {
        HttpUrl.Builder b = oldRequest.url()
                .newBuilder();
        String method = oldRequest.method();
        RequestBody body = oldRequest.body();
        Request.Builder requestBuilder = oldRequest.newBuilder();
        String tokenKey = "token";
        if (oldRequest.header(tokenKey) == null) {
            requestBuilder.addHeader(tokenKey, TextUtils.isEmpty(ConfigCache.get().token) ? "" : ConfigCache.get().token);
        }
//        requestBuilder.addHeader("app-source", "Android");
//        requestBuilder.addHeader("app-version", "" + BuildConfig.VERSION_NAME);
        return requestBuilder
                .method(method, body)
                .url(b.build())
                .build();
    }

}
