package com.example.mvpdemo0602.ui.login.presenter;

/**
 * Created by Administrator on 2018/6/27.
 */

public interface LoginPresenter {

    /**
     * 验证 用户名和密码
     * @param name
     * @param password
     */
    void validateCredentials(String name,String password);

    void onDestroy();

    void toRegister();
}
