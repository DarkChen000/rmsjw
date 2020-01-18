package com.itdr.dao;

import com.itdr.pojo.Goods;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {

    public List<Goods> selectAll(){
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "select g_id,g_name,g_price,g_details,g_count,g_type,g_goodstype,g_createtime,g_updatetime from goods";

        List<Goods> query = null;

        try {
            query = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Goods selectById(int i) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "select g_id,g_name,g_price,g_details,g_count,g_type,g_goodstype,g_createtime,g_updatetime from goods where g_id = ?";

        Goods goods = null;
        try {
            goods = queryRunner.query(sql, new BeanHandler<Goods>(Goods.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    public int updateById(int i) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "update goods set g_goodstype=1 where g_id = ?";

        int m = 0;
        try {
            m = queryRunner.update(sql,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    // 搜索商品  模糊查询
    public List<Goods> selectByName(String name) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "select g_id,g_name,g_price,g_details,g_count,g_type,g_goodstype,g_createtime,g_updatetime from goods where g_name like ?";
        String i = "%" + name + "%";

        List<Goods> query = null;

        try {
            query = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
