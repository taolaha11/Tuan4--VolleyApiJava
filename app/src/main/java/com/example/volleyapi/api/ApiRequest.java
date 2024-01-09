package com.example.volleyapi.api;


import com.example.volleyapi.api.network.ApiClient;
import com.example.volleyapi.model.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequest {
    public static void getUsers(final ApiCallback<List<User>> callback) {
        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<User>> call = apiService.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onError("Error: " + t.getMessage());
            }
        });
    }
}