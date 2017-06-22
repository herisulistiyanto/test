package com.andro.indieschool.myfunapp.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.andro.indieschool.myfunapp.R;
import com.andro.indieschool.myfunapp.databinding.ActivityLoginBinding;
import com.andro.indieschool.myfunapp.shop.ShopActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private LoginHandler handler;
    private Map<String, String> user = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = new LoginViewModel();
        binding.setViewModel(viewModel);
        handler = new LoginHandler(this, viewModel);
        binding.setHandler(handler);
        generateDummyUser();
    }

    @Override
    public void executeLogin() {
        startActivity(new Intent(this, ShopActivity.class));
        finish();
    }

    @Override
    public void validateUser(String userName, String password) {
        if (!user.containsKey(userName)) {
            Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
        } else {
            if (user.get(userName).equals(password)) {
                handler.executeLogin();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binding != null) {
            binding.unbind();
        }
    }

    private void generateDummyUser() {
        user.put("user1", "aaa");
        user.put("user2", "bbb");
        user.put("user3", "ccc");
        user.put("user4", "ddd");
        user.put("user5", "eee");
    }
}
