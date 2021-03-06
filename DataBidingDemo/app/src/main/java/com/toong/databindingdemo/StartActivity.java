package com.toong.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.toong.databindingdemo.databinding.ActivityStartBinding;
import com.toong.databindingdemo.recycler.DataBindingRecyclerViewActivity;

public class StartActivity extends AppCompatActivity {

    ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start);

        binding.setActivity(this);
    }

    public void onDataBindingActivityClick(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void onDataBindingRecyclerViewClick(){
        Intent intent = new Intent(this, DataBindingRecyclerViewActivity.class);
        startActivity(intent);
    }
}
