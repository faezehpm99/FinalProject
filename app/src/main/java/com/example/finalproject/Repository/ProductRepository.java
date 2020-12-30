package com.example.finalproject.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject.retrofit.NetWorkParams;
import com.example.finalproject.retrofit.ProductService;
import com.example.finalproject.retrofit.RetrofitInstance;

import java.io.IOException;
import java.util.List;

import Model.product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductRepository {
    private final ProductService mProductService;
    private final MutableLiveData<List<product>> mProductItemsLiveData = new MutableLiveData<>();

    public ProductRepository(ProductService mProductService) {
        this.mProductService = mProductService;
    }

    public MutableLiveData<List<product>> getProductItemsLiveData() {
        return mProductItemsLiveData;
    }

    public ProductRepository() {
        Retrofit retrofit = RetrofitInstance.getInstance().getRetrofit();
        mProductService = retrofit.create(ProductService.class);
    }
    public List<product> fetchProductList() {
        Call<List<product>> call = mProductService.productList(NetWorkParams.getProductList());
        try {
            Response<List<product>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            Log.e("cant get rsp", e.getMessage(), e);
            return null;
        }
    }

    public void fetchProductListAsync() {
        Call<List<product>> call =
                mProductService.productList(NetWorkParams.getProductList());

        call.enqueue(new Callback<List<product>>() {

            //this run on main thread
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                List<product> items = response.body();

                //update adapter of recyclerview
                mProductItemsLiveData.setValue(items);
            }

            //this run on main thread
            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {
                Log.e("on fail async", t.getMessage(), t);
            }
        });
    }
}
