package com.example.finalproject.retrofit;

import java.util.List;
import java.util.Map;

import Model.product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ProductService {

@GET("products")
    Call<List<product>> productList(@QueryMap Map<String, String> options);

}
