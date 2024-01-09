package com.example.volleyapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.volleyapi.R;
import com.example.volleyapi.api.ApiCallback;
import com.example.volleyapi.api.ApiRequest;
import com.example.volleyapi.model.User;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiRequest.getUsers(new ApiCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                // Xử lý dữ liệu người dùng ở đây
                for (User user : users) {
                    Log.d("User", "ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
                }
            }

            @Override
            public void onError(String error) {
                // Xử lý lỗi ở đây
                Log.e("Error", error);
            }
        });
    }
}