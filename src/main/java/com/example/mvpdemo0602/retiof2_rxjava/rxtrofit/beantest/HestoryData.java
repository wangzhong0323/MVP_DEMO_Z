package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest;

/**
 * Created by Administrator on 2018/5/7.
 */

public class HestoryData {


    private int id;
    private int fedid;
    private int fncode;
    private String gtime;
    private String meternumber;
    private String meterdata;

    public HestoryData() {
    }


    public int getFncode() {
        return fncode;
    }

    public void setFncode(int fncode) {
        this.fncode = fncode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFedid() {
        return fedid;
    }

    public void setFedid(int fedid) {
        this.fedid = fedid;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }

    public String getMeternumber() {
        return meternumber;
    }

    public void setMeternumber(String meternumber) {
        this.meternumber = meternumber;
    }

    public String getMeterdata() {
        return meterdata;
    }

    public void setMeterdata(String meterdata) {
        this.meterdata = meterdata;
    }

    @Override
    public String toString() {
        return "HestoryData{" +
                "id=" + id +
                ", fedid=" + fedid +
                ", fncode=" + fncode +
                ", gtime='" + gtime + '\'' +
                ", meternumber='" + meternumber + '\'' +
                ", meterdata='" + meterdata + '\'' +
                '}';
    }
}
