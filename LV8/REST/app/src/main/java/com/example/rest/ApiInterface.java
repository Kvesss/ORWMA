package com.example.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("products.json")
    Call<List<Product>> getProducts(@Query("brand") String search);

}
