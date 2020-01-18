package com.itdr.utils;

import com.itdr.pojo.Goods;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class C3P0Util {

    //静态数据库连接池
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getComboPooledDataSource(){
        return comboPooledDataSource;
    }
}
