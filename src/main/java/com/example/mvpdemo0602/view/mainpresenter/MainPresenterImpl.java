package com.example.mvpdemo0602.view.mainpresenter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.fragments.HomeFragment;
import com.example.mvpdemo0602.fragments.MineFragment;
import com.example.mvpdemo0602.global.MyApplication;
import com.example.mvpdemo0602.helper.MainTab;

/**
 * Created by Administrator on 2018/6/27.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    public MainPresenterImpl(MainView mainView) {
        this.mainView= mainView;
    }

    @Override
    public void onStart() {
        if (mainView !=null)
        mainView.restartViewInit();
    }

    @Override
    public void onDestroy() {
        mainView=null;
    }

    @Override
    public void init() {
        if (mainView !=null)
            mainView.initTabhost();
    }


}
