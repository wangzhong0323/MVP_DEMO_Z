package com.example.mvpdemo0602.ui.splash.view;

/**
 * Created by Administrator on 2018/6/28.
 */

public interface SplashView {


    void showProgressbar();
    void hindProgressbar();

    void setTextVerCode();

    void showDialog(String desc,String url);

    void navigateToHome();
    void navigateToLogin();


}
