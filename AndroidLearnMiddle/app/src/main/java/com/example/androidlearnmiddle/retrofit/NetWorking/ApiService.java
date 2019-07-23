package com.example.androidlearnmiddle.retrofit.NetWorking;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("cook/category")
    Observable<ApiResponse> cook(
            @Query("key") String key);



}
