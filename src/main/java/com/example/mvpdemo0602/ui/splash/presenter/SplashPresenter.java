package com.example.mvpdemo0602.ui.splash.presenter;

import android.content.DialogInterface;

/**
 * Created by Administrator on 2018/6/28.
 */

public interface SplashPresenter {

    /**
     * 对比版本
     */
    void compareVercode();

    void onDestroy();

    String getLocalVerCode();

    void downloadAPK(DialogInterface dialog, String url);
    void cancelDialog();

}
