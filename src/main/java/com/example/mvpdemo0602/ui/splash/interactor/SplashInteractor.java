package com.example.mvpdemo0602.ui.splash.interactor;

import com.example.mvpdemo0602.bean.Result;

/**
 * Created by Administrator on 2018/6/28.
 */

public interface SplashInteractor {

    interface RequestListence<T>{
        void onFailed(int errorCode);
        void onSuccess(T t);
    }

    void requestAPPVer(RequestListence<Result<String>> listence);
    void requestDownloadAPP(String url,RequestListence<Result<String>> listence);

}
