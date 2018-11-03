package com.pokidin.a.demostore.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryStoreApi {

    @GET("/taxonomy/categories")
    Call<List<String>> getCategories(@Query("api_key") String apiKey);
}
