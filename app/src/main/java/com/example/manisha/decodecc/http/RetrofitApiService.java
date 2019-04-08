package com.example.manisha.decodecc.http;

import com.example.manisha.decodecc.model.ApiObject;
import com.example.manisha.decodecc.model.Polling;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {
    @GET("v2/5ca9a1053700007200492e91")
    Call<List<Polling>> getPollingData();

//    @GET("v2/5ca9afb63700007200492ea0")
    @GET("v2/5cab9c53300000720010319b")
    public Call<List<ApiObject>> getAllPost();
}
