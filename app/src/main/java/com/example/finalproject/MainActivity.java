package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalproject.databinding.ActivityMainBinding;

import view.ProductFragment;
import view.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {
private DrawerLayout mDrawer;
private ActionBarDrawerToggle mToggle;

    @Override
    public Fragment createFragment() {
        return ProductFragment.newInstance();
    }
    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);


        mBinding.drawer.addDrawerListener(mToggle);
        mToggle=new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);

        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

  /*  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }*/
}