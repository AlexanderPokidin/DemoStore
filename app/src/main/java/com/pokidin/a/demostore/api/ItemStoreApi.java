package com.pokidin.a.demostore.api;

import com.pokidin.a.demostore.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemStoreApi {

    @GET("v2/listings/active")
    Call<List<Item>> getItems(
//            @Path("first_field") String firstField,
//            @Path("second_field") String secondField,
            @Query("api_key") String apiKey,
            @Query("category") String category,
            @Query("keywords") String keywords);
}
