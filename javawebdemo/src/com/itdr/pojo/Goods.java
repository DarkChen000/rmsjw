package com.itdr.pojo;

import java.util.Date;

public class Goods {
    private Integer g_id;
    private String g_name;
    private Double g_price;
    private Integer g_count;
    private String g_details;
    private String g_type;
    private Date g_createtime;
    private Date g_updatetime;
    private int g_goodstype;

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public Double getG_price() {
        return g_price;
    }

    public void setG_price(Double g_price) {
        this.g_price = g_price;
    }

    public Integer getG_count() {
        return g_count;
    }

    public void setG_count(Integer g_discount) {
        this.g_count = g_discount;
    }

    public String getG_details() {
        return g_details;
    }

    public void setG_details(String g_details) {
        this.g_details = g_details;
    }

    public String getG_type() {
        return g_type;
    }

    public void setG_type(String g_type) {
        this.g_type = g_type;
    }



    public Date getG_createtime() {
        return g_createtime;
    }

    public void setG_createtime(Date g_createtime) {
        this.g_createtime = g_createtime;
    }




    public Date getG_updatetime() {
        return g_updatetime;
    }

    public void setG_updatetime(Date g_updatetime) {
        this.g_updatetime = g_updatetime;
    }

    public int getG_goodstype() {
        return g_goodstype;
    }

    public void setG_goodstype(int g_goodstype) {
        this.g_goodstype = g_goodstype;
    }
}
