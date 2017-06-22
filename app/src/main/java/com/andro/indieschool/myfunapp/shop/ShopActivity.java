package com.andro.indieschool.myfunapp.shop;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.andro.indieschool.myfunapp.R;
import com.andro.indieschool.myfunapp.databinding.ActivityShopBinding;

import java.util.Calendar;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public class ShopActivity extends AppCompatActivity implements ShopView {

    private ActivityShopBinding binding;
    private ShopViewModel viewModel;
    private ShopHandler handler;
    private Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop);
        viewModel = new ShopViewModel();
        handler = new ShopHandler(viewModel, this);
        binding.setViewModel(viewModel);
        binding.setHandler(handler);
        initCalendar();
    }

    @Override
    public void showMessageSimpan() {
        Toast.makeText(this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
    }

    private void initCalendar() {
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                viewModel.updateTanggal(myCalendar);
            }
        };
    }

    @Override
    public void handleOnClickTanggal() {
        binding.inputTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ShopActivity.this, dateSetListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binding != null) {
            binding.unbind();
        }
    }
}
