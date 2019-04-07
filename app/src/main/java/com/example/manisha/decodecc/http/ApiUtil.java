package com.example.manisha.decodecc.http;

public class ApiUtil {

    private static final String BASE_URL = "http://www.mocky.io/";

    public static RetrofitApiService getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitApiService.class);
    }

}
