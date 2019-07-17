package com.example.androidlearnmiddle.retrofit.NetWorking;

import java.util.Arrays;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {

    public final List<String> cacheKeys = Arrays.asList(
            "/product",
            "/region/city",
            "/region/province",
            "/loan/term",
            "/car/brand",
            "/car/series");

    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
        try {
            if (request.method().equalsIgnoreCase("get") && needCache(request.url().toString())) {
                Response originResponse = chain.proceed(request);
                originResponse = originResponse.newBuilder()
                        .removeHeader("pragma")
                        .header("Cache-Control", "max-age=86400")
                        .build();

                return originResponse;
            } else {
                return chain.proceed(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean needCache(String url) {
        for (String key : cacheKeys) {
            if (url.contains(key)) {
                return true;
            }
        }
        return false;
    }

}
