package com.andro.indieschool.myfunapp.login;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public interface LoginView {

    void executeLogin();

    void validateUser(String userName, String password);
}
