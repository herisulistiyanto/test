package com.andro.indieschool.myfunapp.login;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public class LoginHandler {

    private LoginView view;
    private LoginViewModel viewModel;

    public LoginHandler(LoginView view, LoginViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }

    public void onClickLogin() {
        view.validateUser(viewModel.getUserName(), viewModel.getPassword());
    }

    public void executeLogin() {
        view.executeLogin();
    }
}
