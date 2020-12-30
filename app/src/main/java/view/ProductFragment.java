package view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.Adapter.ProductAdapter;
import com.example.finalproject.R;
import com.example.finalproject.ViewModel.ProductViewModel;
import com.example.finalproject.databinding.FragmentProductBinding;

import java.util.List;

import Model.product;

public class ProductFragment extends Fragment {
private FragmentProductBinding mBinding;
private ProductViewModel mViewModel;


    public ProductFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        mViewModel.fetchProductList();
        setLiveDataObservers();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_product,
                container,
                false);

        initViews();

        return mBinding.getRoot();
    }

    private void initViews() {
        mBinding.productRecyclerView
                .setLayoutManager(new GridLayoutManager(getContext(), 3));
    }
    private void setLiveDataObservers() {
        mViewModel.getProductList().observe(this, new Observer<List<product>>() {
            @Override
            public void onChanged(List<product> products) {
                setupAdapter(products);
            }
        });
    }
    private void setupAdapter(List<product> items) {
        ProductAdapter adapter = new ProductAdapter(mViewModel);
        mBinding.productRecyclerView.setAdapter(adapter);
    }
}