package com.pokidin.a.demostore.api;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient extends Application {
    private static final String TAG = "Debug Run";
    private static final String BASE_URL = "https://openapi.etsy.com/";

    private static StoreApi storeApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        storeApi = mRetrofit.create(StoreApi.class);
    }

    public static StoreApi getStoreApi() {
        return storeApi;
    }
}
