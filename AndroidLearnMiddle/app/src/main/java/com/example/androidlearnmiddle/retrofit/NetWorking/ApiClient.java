package com.example.androidlearnmiddle.retrofit.NetWorking;


import com.example.androidlearnmiddle.ApplicationContext;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public class ApiClient {

    private OkHttpClient mClient;
    private Retrofit mRetrofit;

    public static ApiClient init(){
        ApiClient client = new ApiClient();
        client.mClient = client.provideOkHttpClient();
        client.mRetrofit = client.provideRetrofit(client.mClient, Constant.API_URL);
        return client;
    }

    private OkHttpClient provideOkHttpClient() {
        LogInterceptor loggingInterceptor = new LogInterceptor();
        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
//                .cookieJar(new CookieManager(SheepApp.getInstance()))
                .addInterceptor(new AddPublicParamsIntercept())
                .addInterceptor(new CacheInterceptor())
                .addInterceptor(loggingInterceptor)
                .build();
        return okhttpClient;
    }

    private Retrofit provideRetrofit(OkHttpClient okhttpClient, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl(url)
                .addConverterFactory(new StringConverterFactory())
                .addConverterFactory(FastJsonConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(EntityUtils.gson))//
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private ApiService provideApiService(){
        return mRetrofit.create(ApiService.class);
    }

    public static ApiService api(){
        return ApplicationContext.getContext().getApiClient().provideApiService();
    }
}
