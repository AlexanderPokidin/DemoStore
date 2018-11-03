package com.pokidin.a.demostore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pokidin.a.demostore.api.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Debug Run";

    private List<Item> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = new ArrayList<>();

        RestClient.getStoreApi().getItems("taxonomy", "categories",
                "22w1n5abtj7tjj8y2f9kuqas", null, null).enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                mItems.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }
}
