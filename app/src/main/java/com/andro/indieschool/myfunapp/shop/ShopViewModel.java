package com.andro.indieschool.myfunapp.shop;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;

import com.andro.indieschool.myfunapp.BR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public class ShopViewModel extends BaseObservable {

    private String nama;
    private String jumlahBarang;
    private String pemasok;
    private String tanggal;

    public ShopViewModel() {
    }

    @Bindable
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        notifyPropertyChanged(BR.nama);
        notifyPropertyChanged(BR.nameAlertVisibility);
        notifyPropertyChanged(BR.buttonSimpanEnabled);
    }

    @Bindable
    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
        notifyPropertyChanged(BR.jumlahBarang);
        notifyPropertyChanged(BR.jumlahBarangAlertVisibility);
        notifyPropertyChanged(BR.buttonSimpanEnabled);
    }

    @Bindable
    public String getPemasok() {
        return pemasok;
    }

    public void setPemasok(String pemasok) {
        this.pemasok = pemasok;
        notifyPropertyChanged(BR.pemasok);
        notifyPropertyChanged(BR.pemasokAlertVisibility);
        notifyPropertyChanged(BR.buttonSimpanEnabled);
    }

    @Bindable
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
        notifyPropertyChanged(BR.tanggal);
        notifyPropertyChanged(BR.tanggalAlertVisibility);
        notifyPropertyChanged(BR.buttonSimpanEnabled);
    }

    @Bindable
    public int getNameAlertVisibility() {
        return (TextUtils.isEmpty(nama)) ? View.VISIBLE : View.GONE;
    }

    @Bindable
    public int getJumlahBarangAlertVisibility() {
        return (TextUtils.isEmpty(jumlahBarang)) ? View.VISIBLE : View.GONE;
    }

    @Bindable
    public int getPemasokAlertVisibility() {
        return (TextUtils.isEmpty(pemasok)) ? View.VISIBLE : View.GONE;
    }

    @Bindable
    public int getTanggalAlertVisibility() {
        return (TextUtils.isEmpty(tanggal)) ? View.VISIBLE : View.GONE;
    }

    @Bindable
    public boolean isButtonSimpanEnabled() {
        return !TextUtils.isEmpty(nama) &&
                !TextUtils.isEmpty(jumlahBarang) &&
                !TextUtils.isEmpty(pemasok) &&
                !TextUtils.isEmpty(tanggal);
    }

    public void clearAllInputText() {
        setNama("");
        setJumlahBarang("");
        setPemasok("");
        setTanggal("");
    }

    public void updateTanggal(Calendar myCalendar) {
        String myFormat = "dd MMMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        setTanggal(sdf.format(myCalendar.getTime()));
    }
}
