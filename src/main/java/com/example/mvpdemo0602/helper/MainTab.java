package com.example.mvpdemo0602.helper;


import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.fragments.HomeFragment;
import com.example.mvpdemo0602.fragments.MineFragment;

/**
 *  main 的支持类
 * Created by Administrator on 2017-11-24.
 */

public enum MainTab {
    HOME(0, R.string.main_tab_home, R.drawable.tab_icon_home, HomeFragment.class),
    MINE(1,R.string.main_tab_mine,R.drawable.tab_icon_me, MineFragment.class);

    private int indx;
    private int tabs;
    private int icon;
    private Class<?> clazz;
    MainTab(int indx, int tabs, int icon, Class<?> clazz) {
        this.indx=indx;
        this.tabs=tabs;
        this.icon=icon;
        this.clazz=clazz;
    }

    public int getIndx() {
        return indx;
    }

    public void setIndx(int indx) {
        this.indx = indx;
    }

    public int getTabs() {
        return tabs;
    }

    public void setTabs(int tabs) {
        this.tabs = tabs;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
