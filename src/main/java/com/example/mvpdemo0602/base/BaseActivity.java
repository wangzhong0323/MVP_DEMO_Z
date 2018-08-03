package com.example.mvpdemo0602.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvpdemo0602.global.AppManager;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/11.
 */

public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);

        if (getLayoutId()!=0)
            setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }

    public int getLayoutId(){
        return 0;
    }
    abstract void initView();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


}
