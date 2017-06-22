package com.andro.indieschool.myfunapp.shop;

/**
 * Created by herisulistiyanto on 6/22/17.
 */

public class ShopHandler {

    private ShopViewModel viewModel;
    private ShopView view;

    public ShopHandler(ShopViewModel viewModel, ShopView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    public void onClickSimpan() {
        view.showMessageSimpan();
        viewModel.clearAllInputText();
    }

    public void onClickTanggal() {
        view.handleOnClickTanggal();
    }
}
