package com.example.finalproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.finalproject.Repository.ProductRepository;

import java.util.List;

import Model.product;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository mRepository;
    private LiveData<List<product>> mProductList;

    public LiveData<List<product>> getProductList() {
        return mProductList;
    }

    public ProductViewModel(@NonNull Application application) {
        super(application);
        mRepository=new ProductRepository();
        mProductList=mRepository.getProductItemsLiveData();
    }
    public void fetchProductList(){
        mRepository.fetchProductList();
    }
    public void fetchProductListAsync(){
        mRepository.fetchProductListAsync();
    }
    public int sizeOfData(){
        return mRepository.fetchProductList().size();
    }
public void OnClick(int position){

}
}
