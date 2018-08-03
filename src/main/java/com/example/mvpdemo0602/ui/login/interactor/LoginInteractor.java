package com.example.mvpdemo0602.ui.login.interactor;

import com.example.mvpdemo0602.bean.User;

/**
 * Created by Administrator on 2018/6/27.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError(int errorCode);
        void onUserPasswordError(int errorCode);
        void onSuccess(User user);
    }

    void login(String name, String password, OnLoginFinishedListener listener);
}
