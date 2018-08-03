package com.example.mvpdemo0602.ui.login.interactor;

import android.os.Handler;
import android.text.TextUtils;

import com.example.mvpdemo0602.bean.User;

/**
 * 登陆交互器也就  模型
 * Created by Administrator on 2018/6/27.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String name, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(name)){
                    listener.onUsernameError(1);
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onUserPasswordError(1);
                    return;
                }

                User user = new User();
                user.setUserName(name);
                user.setUserPassword(password);
                //  请求逻辑

                listener.onSuccess(user);
                    // 结束
            }
        },2000);
    }
}
