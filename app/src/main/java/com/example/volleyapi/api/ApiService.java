package com.example.volleyapi.api;

import java.util.List;

import com.example.volleyapi.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("users")
    Call<List<User>> getUsers();
}
