package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.GoodsDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Goods;
import com.itdr.pojo.Users;
import com.itdr.service.GoodsService;
import com.itdr.service.UserService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    GoodsDao goodsDao = new GoodsDao();

    @Override
    public ResponseCode getAllGoods() {
        List<Goods> goods = goodsDao.selectAll();
        return ResponseCode.toSuccess(goods);
    }

    // 商品下架
    @Override
    public ResponseCode toType(String id) {
        // 参数非空判断
        if (id == null || "".equals(id)){
            return ResponseCode.toDefeated("非法参数");
        }
        // 参数转换成int值
        int i = Integer.parseInt(id);
        // 查找商品
        Goods goods = goodsDao.selectById(i);
        if (goods == null){
            return ResponseCode.toDefeated("商品不存在！");
        }
        // 修改商品信息
        int i2 = goodsDao.updateById(i);
        if (i2 < 0){
            return ResponseCode.toDefeated("商品下架失败！");
        }

        // 如果i2大于0  说明修改成功
        return ResponseCode.toSuccess(i2);
    }

    @Override
    public ResponseCode toSelect(String name) {

        // 参数非空判断
        if (name == null || "".equals(name)){
            return ResponseCode.toDefeated("非法参数");
        }
        // 查找商品
        List<Goods> goods = goodsDao.selectByName(name);
        if (goods == null){
            return ResponseCode.toDefeated("未找到符合要求的商品！");
        }
        return ResponseCode.toSuccess(goods);
    }
}
