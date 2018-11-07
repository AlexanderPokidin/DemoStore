package com.pokidin.a.demostore.api;

import com.pokidin.a.demostore.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CategoryStoreApi {

    @GET("v2/taxonomy/categories")
    Call<Category> getCategories(
//            @Path("first_field") String firstField,
//            @Path("second_field") String secondField,
            @Query("api_key") String apiKey);
}
