package com.pokidin.a.demostore.api;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient extends Application {
    private static final String TAG = "Debug Run";
    private static final String BASE_URL = "https://openapi.etsy.com/";
    public static final String KEY = "22w1n5abtj7tjj8y2f9kuqas";

    private static CategoryStoreApi sCategoryStoreApi;
    private static ItemStoreApi sItemStoreApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sCategoryStoreApi = retrofit.create(CategoryStoreApi.class);
        sItemStoreApi = retrofit.create(ItemStoreApi.class);
    }

    public static CategoryStoreApi getCategoryStoreApi() {
        return sCategoryStoreApi;
    }

    public static ItemStoreApi getItemApi() {
        return sItemStoreApi;
    }

}
