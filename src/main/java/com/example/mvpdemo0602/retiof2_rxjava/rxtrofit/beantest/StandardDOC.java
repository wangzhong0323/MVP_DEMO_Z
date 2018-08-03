package com.example.mvpdemo0602.retiof2_rxjava.rxtrofit.beantest;

import java.io.Serializable;

/**
 *  文档
 * Created by Administrator on 2018/4/27.
 */
public class StandardDOC implements Serializable{

    private int _id;
    private int id;
    private String description;
    private int page;
    private String downurl;

    public StandardDOC() {
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    @Override
    public String toString() {
        return "StandardDOC{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", page=" + page +
                ", downurl='" + downurl + '\'' +
                '}';
    }
}
