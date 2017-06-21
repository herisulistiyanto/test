package com.andro.indieschool.myfunapp.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.andro.indieschool.myfunapp.R;
import com.andro.indieschool.myfunapp.databinding.ActivityMainBinding;
import com.andro.indieschool.myfunapp.second.SecondActivity;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainHandler handler;
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel();
        handler = new MainHandler(viewModel, this);
        binding.setViewModel(viewModel);
        binding.setHandler(handler);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    public void launchSecondActivity() {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
