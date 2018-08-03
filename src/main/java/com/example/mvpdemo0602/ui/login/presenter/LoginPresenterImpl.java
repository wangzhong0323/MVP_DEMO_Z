package com.example.mvpdemo0602.ui.login.presenter;

import com.example.mvpdemo0602.bean.User;
import com.example.mvpdemo0602.ui.login.interactor.LoginInteractor;
import com.example.mvpdemo0602.ui.login.view.LoginView;

/**
 * Created by Administrator on 2018/6/27.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl( LoginView loginView,LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void validateCredentials(String name, String password) {
        if (loginView !=null){
            loginView.showProgressDialog();
        }
        loginInteractor.login(name,password,this);
    }

    @Override
    public void onDestroy() {
        if (loginView!=null){

            loginView =null;
        }
    }


    @Override
    public void onUsernameError(int errorCode) {
        if (loginView !=null) {
            loginView.setUserNameError(errorCode);
            loginView.hindeProgressDialog();
        }
    }

    @Override
    public void onUserPasswordError(int errorCode) {
        if (loginView !=null) {
            loginView.setUserPasswordError(errorCode);
            loginView.hindeProgressDialog();
        }
    }

    @Override
    public void onSuccess(User user) {
        //对user的数据做处理


        if(loginView!=null){
            loginView.navigateToHome();
            loginView.viewToFinished();
        }
    }

    @Override
    public void toRegister() {
        if (loginView!=null){
            loginView.navigateToRegister();
        }
    }

    public void errorStr(int errorCode){



    }

}
