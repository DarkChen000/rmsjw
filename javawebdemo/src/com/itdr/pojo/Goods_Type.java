package com.itdr.pojo;

import java.util.Date;

public class Goods_Type {
    private Integer gt_id;
    private String gt_name;
    private Integer gt_fid;
    private Date create_time;
    private Date update_time;

    public Integer getGt_id() {
        return gt_id;
    }

    public void setGt_id(Integer gt_id) {
        this.gt_id = gt_id;
    }

    public String getGt_name() {
        return gt_name;
    }

    public void setGt_name(String gt_name) {
        this.gt_name = gt_name;
    }

    public Integer getGt_fid() {
        return gt_fid;
    }

    public void setGt_fid(Integer gt_fid) {
        this.gt_fid = gt_fid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
