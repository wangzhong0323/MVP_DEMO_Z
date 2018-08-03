package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest;

import java.io.Serializable;
import java.util.List;

/**
 * 文档列表
 * Created by Administrator on 2018/4/27.
 */

public class StandardDOCList implements Serializable{

//    private int id;
//    private String docmentName;
    private List<StandardDOC> data;

    public StandardDOCList() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDocmentName() {
//        return docmentName;
//    }
//
//    public void setDocmentName(String docmentName) {
//        this.docmentName = docmentName;
//    }

    public List<StandardDOC> getData() {
        return data;
    }

    public void setData(List<StandardDOC> data) {
        this.data = data;
    }
}
