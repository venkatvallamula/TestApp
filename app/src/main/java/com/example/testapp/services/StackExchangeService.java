package com.example.testapp.services;

import com.example.testapp.model.UserResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface StackExchangeService {
    public static String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")
    Observable<UserResponse> getUser(@Path("login") String login);
}
