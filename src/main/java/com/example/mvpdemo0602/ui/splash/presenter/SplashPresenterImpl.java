package com.example.mvpdemo0602.ui.splash.presenter;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.example.mvpdemo0602.bean.Result;
import com.example.mvpdemo0602.global.AppConfig;
import com.example.mvpdemo0602.global.MyApplication;
import com.example.mvpdemo0602.ui.splash.interactor.SplashInteractor;
import com.example.mvpdemo0602.ui.splash.view.SplashView;
import com.example.mvpdemo0602.utils.PrintLog;
import com.example.mvpdemo0602.utils.TDevice;

/**
 * Created by Administrator on 2018/6/28.
 */

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView splashView;
    private SplashInteractor splashInteractor;
    private AppConfig config;
    private static final int TO_LOGIN=1;
    private static final int TO_HOME=2;

    private static final long WAITING_TIME_THREE=3000;
    private long startTime=0;
    private long endTime=0;

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){

                case TO_LOGIN:
                    splashView.navigateToLogin();
                    break;

                case TO_HOME:
                    splashView.navigateToHome();
                    break;
            }
        }
    };

    public SplashPresenterImpl(SplashView splashView, SplashInteractor splashInteractor) {
        this.splashView = splashView;
        this.splashInteractor = splashInteractor;

    }

    @Override
    public void compareVercode() {
        startTime = System.currentTimeMillis();
        splashView.showProgressbar();

        splashView.setTextVerCode();


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                PrintLog.i("str===========1=net="+checkUpNetWork());
                if (checkUpNetWork()) {
                    avaliableNetwork();
                }else {
                    unAvaliableNetwork();
                }
            }
        },1000);


    }

    /**
     * 网络不可用
     */
    private void unAvaliableNetwork() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(TO_HOME);

            }
        },WAITING_TIME_THREE);


    }

    /**
     * 网络可用
     */
    private void avaliableNetwork() {
        splashInteractor.requestAPPVer(new SplashInteractor.RequestListence<Result<String>>() {
            @Override
            public void onFailed(int errorCode) {
                MyApplication.showToast(getErrorStr(errorCode));
            }
            @Override
            public void onSuccess(Result<String> stringResult) {
                //比对 server APP版本 与本地版本  等于 不更新 ；> 更新
                if (!stringResult.getData().equals(getLocalVerCode())) {
                    splashView.showDialog("", "123456");
                }else {
                    checkToView();

                }

            }
        });
    }

    private void checkToView() {
        if (config ==null) config =AppConfig.getAppConfig(MyApplication.context());
        endTime = System.currentTimeMillis();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String first_start = config.get(AppConfig.KEY_FRITST_START);
                PrintLog.i("str===========4=code="+first_start);
                if (TextUtils.isEmpty(first_start) || first_start.equals("true")){
                    mHandler.sendEmptyMessage(TO_LOGIN);
                }else {
                    mHandler.sendEmptyMessage(TO_HOME);
                }
            }
        },WAITING_TIME_THREE -(endTime - startTime));
    }

    private boolean checkUpNetWork(){
        int type = TDevice.checkNetworkType(MyApplication.context());
        if (type==TDevice.TYPE_WIFI || type==TDevice.TYPE_MOBILE){
            return true;
        }
        return false;
    }


    @Override
    public void onDestroy() {
        splashView.hindProgressbar();
        splashView=null;
    }

    @Override
    public String getLocalVerCode(){
        return "1.0.0";
    }


    @Override
    public void downloadAPK(final DialogInterface dialog, String url){
        //xxxx
        splashInteractor.requestDownloadAPP(url, new SplashInteractor.RequestListence<Result<String>>() {
            @Override
            public void onFailed(int errorCode) {
                MyApplication.showToast(getErrorStr(errorCode));
                dialog.dismiss();
            }

            @Override
            public void onSuccess(Result<String> stringResult) {
                MyApplication.showToast(stringResult.getData());
                installAPK();
                dialog.dismiss();
            }
        });
    }

    @Override
    public void cancelDialog() {
        checkToView();
    }

    /**
     * 安装APK
     */
    private void installAPK() {

    }

    /**
     * 请求失败描述
     * @param errorCode
     * @return
     */
    private String getErrorStr(int errorCode) {
        String str="";
        switch (errorCode){
            case 1:
                str="token错误";
                break;
            case 2:
                str="服务器错误";
                break;
            default:
                str="位置错误。";
        }
        return str;
    }

}
