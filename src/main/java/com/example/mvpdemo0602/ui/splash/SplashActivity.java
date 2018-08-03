package com.example.mvpdemo0602.ui.splash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.global.MyApplication;
import com.example.mvpdemo0602.ui.login.LoginActivity;
import com.example.mvpdemo0602.ui.splash.interactor.SplashInteractorImpl;
import com.example.mvpdemo0602.ui.splash.presenter.SplashPresenter;
import com.example.mvpdemo0602.ui.splash.presenter.SplashPresenterImpl;
import com.example.mvpdemo0602.ui.splash.view.SplashView;
import com.example.mvpdemo0602.view.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashView{

    @Bind(R.id.tv_splash_app_version_code)
    TextView tvSplashAppVersionCode;
    @Bind(R.id.pb_splash_progress_1)
    ProgressBar mPb;

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        splashPresenter =new SplashPresenterImpl(this,new SplashInteractorImpl());
        splashPresenter.compareVercode();
    }


    @Override
    protected void onDestroy() {
        splashPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgressbar() {
        mPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hindProgressbar() {
        mPb.setVisibility(View.GONE);

    }

    @Override
    public void setTextVerCode() {
        tvSplashAppVersionCode.setText(splashPresenter.getLocalVerCode());
    }

    @Override
    public void showDialog(String desc, final String url) {
        String str="1、UI有局部增加;2、代码优化";
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("更新APP");
        builder.setMessage("更新内容："+str);
        builder.setCancelable(false);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                splashPresenter.cancelDialog();
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("下载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                splashPresenter.downloadAPK(dialog,url);
            }
        });

        builder.show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}
