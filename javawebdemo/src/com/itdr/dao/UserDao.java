package com.itdr.dao;

import com.itdr.pojo.Goods;
import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

public class UserDao {

    public Users selectByUserNameAndPassword(String username,String password){

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "select u_id,username,password,type,phone,create_time,update_time from user where username = ? and password = ?";

        Users u = null;

        try {
            u = queryRunner.query(sql, new BeanHandler<Users>(Users.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
