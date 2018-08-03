package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest;


import java.io.Serializable;

/**
 *
 * Created by Administrator on 2018/6/26.
 */

public class HistoryData implements Serializable {

    private int id;
    private int fedid;
    private int fncode;
    private String fnname;
    private String gtime;
    private int dicount;
    private HistoryRawData historyRawData;
    private HistoryLocationInfo locinfo;
    public HistoryData() {
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

    public int getFncode() {
        return fncode;
    }

    public void setFncode(int fncode) {
        this.fncode = fncode;
    }

    public String getFnname() {
        return fnname;
    }

    public void setFnname(String fnname) {
        this.fnname = fnname;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }

    public int getDicount() {
        return dicount;
    }

    public void setDicount(int dicount) {
        this.dicount = dicount;
    }

    public HistoryRawData getHistoryRawData() {
        return historyRawData;
    }

    public void setHistoryRawData(HistoryRawData historyRawData) {
        this.historyRawData = historyRawData;
    }

    public HistoryLocationInfo getLocinfo() {
        return locinfo;
    }

    public void setLocinfo(HistoryLocationInfo locinfo) {
        this.locinfo = locinfo;
    }
}
