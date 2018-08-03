package com.example.mvpdemo0602.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.helper.MainTab;
import com.example.mvpdemo0602.view.mainpresenter.MainPresenter;
import com.example.mvpdemo0602.view.mainpresenter.MainPresenterImpl;
import com.example.mvpdemo0602.view.mainpresenter.MainView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView,View.OnTouchListener{

    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.fth_main_bottom_tabs)
    FragmentTabHost mTabHosts;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter =new MainPresenterImpl(this);
        mainPresenter.init();
    }


    @Override
    protected void onStart() {
        mainPresenter.onStart();
        super.onStart();
    }


    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void restartViewInit() {
        mTabHosts.setCurrentTab(0);
    }

    @Override
    public void initTabhost() {
        mTabHosts.setup(this,getSupportFragmentManager(),R.id.fl_main_content_1);
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHosts.newTabSpec(getString(mainTab.getTabs()));
            View indicator = LayoutInflater.from(this)
                    .inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tv_tab_indicator);
            Drawable drawable = getResources().getDrawable(
                    mainTab.getIcon());
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
                    null);

            title.setText(getString(mainTab.getTabs()));
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mTabHosts.addTab(tab, mainTab.getClazz(), null);

            mTabHosts.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
    }
}
