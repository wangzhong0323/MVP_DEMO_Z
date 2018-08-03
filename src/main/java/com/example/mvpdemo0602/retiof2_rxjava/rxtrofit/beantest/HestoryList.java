package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest;

import java.util.List;

/**
 * Created by Administrator on 2018/5/7.
 */

public class HestoryList {

    private int id;
    private int uid;
    private String token;
    private int total;
    private List<HestoryData> data;

    public HestoryList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<HestoryData> getData() {
        return data;
    }

    public void setData(List<HestoryData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HestoryList{" +
                "data=" + data +
                ", uid=" + uid +
                '}';
    }
}
