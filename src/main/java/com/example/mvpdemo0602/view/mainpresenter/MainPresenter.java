package com.example.mvpdemo0602.view.mainpresenter;

import android.app.Activity;
import android.support.v4.app.FragmentTabHost;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/6/27.
 */

public interface MainPresenter {

    void onStart();
    void onDestroy();
    void init();
}
