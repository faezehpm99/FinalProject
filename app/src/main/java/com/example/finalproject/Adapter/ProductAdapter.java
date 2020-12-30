package com.example.finalproject.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.ViewModel.ProductViewModel;
import com.example.finalproject.databinding.ListProductItemBinding;
import com.squareup.picasso.Picasso;

import Model.product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ProductViewModel mViewModel;
    private ListProductItemBinding mBinding;

    public ProductAdapter(ProductViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListProductItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(mViewModel.getApplication())
                        , R.layout.list_product_item
                        ,parent, false);
        return new ProductViewHolder(binding, mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mViewModel.sizeOfData();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ListProductItemBinding mBinding;
        public ProductViewHolder(@NonNull ListProductItemBinding itemView, ListProductItemBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
            mBinding.setViewModel(mViewModel);
        }
    }
    public void bindGalleryItem(product item, int position) {
        mBinding.setPosition(position);

        Picasso.get()
                .load((Uri) item.getProductSrc())

                .into(mBinding.productImageView);
    }
}

