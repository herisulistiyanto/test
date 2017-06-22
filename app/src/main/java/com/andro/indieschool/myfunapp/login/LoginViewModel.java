package com.andro.indieschool.myfunapp.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.andro.indieschool.myfunapp.BR;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public class LoginViewModel extends BaseObservable {

    private String userName;
    private String password;

    public LoginViewModel() {
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
        notifyPropertyChanged(BR.buttonLoginEnabled);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
        notifyPropertyChanged(BR.buttonLoginEnabled);
    }

    @Bindable
    public boolean isButtonLoginEnabled() {
        return (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password));
    }
}
