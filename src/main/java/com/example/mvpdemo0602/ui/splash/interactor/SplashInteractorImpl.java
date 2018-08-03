package com.example.mvpdemo0602.ui.splash.interactor;

import android.os.Handler;

import com.example.mvpdemo0602.bean.Result;

/**
 * Created by Administrator on 2018/6/28.
 */

public class SplashInteractorImpl implements SplashInteractor {


    @Override
    public void requestAPPVer(final RequestListence<Result<String>> listence) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean isSuccess=true;
                if (isSuccess){
                    Result<String> stringResult = new Result<>();
                    stringResult.setCode(0);
                    stringResult.setMsg("成功");
                    stringResult.setData("1.0.0");
                    listence.onSuccess(stringResult);
                }else {
                    listence.onFailed(2);
                }
            }
        },2000);

    }

    @Override
    public void requestDownloadAPP(String url, final RequestListence<Result<String>> listence) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean isSuccess=true;
                if (isSuccess){
                    Result<String> stringResult = new Result<>();
                    stringResult.setCode(0);
                    stringResult.setMsg("成功");
                    stringResult.setData("aaaaaa");
                    listence.onSuccess(stringResult);
                }else {
                    listence.onFailed(2);
                }
            }
        },2000);
    }
}
