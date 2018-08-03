package com.example.mvpdemo0602.ui.login.view;

/**
 * view 层 login需要处理的
 *
 * 对于View的接口，去观察功能上的操作，然后考虑：

     1、该操作需要什么？
     2、该操作的结果，对应的反馈？
     3、该操作过程中对应的友好的交互？
 *
 * Created by Administrator on 2018/6/27.
 */

public interface LoginView {

    void showProgressDialog();
    void hindeProgressDialog();

    void setUserNameError(int errorCode);
    void setUserPasswordError(int errorCode);

    void navigateToHome();// 去home

    void navigateToRegister(); //去注册

    void viewToFinished();

}
