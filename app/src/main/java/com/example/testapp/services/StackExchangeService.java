package com.example.testapp.services;

import com.example.testapp.model.UserResponse;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;
import rx.Observable;

public interface StackExchangeService {
    public static String SERVICE_ENDPOINT = "https://api.stackexchange.com/2.2";

    @GET("/users/")
    Observable<UserResponse> getUser(@QueryMap Map<String, String> paramsMap);
}
