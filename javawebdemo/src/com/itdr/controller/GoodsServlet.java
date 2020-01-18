package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.GoodsService;
import com.itdr.service.UserService;
import com.itdr.service.impl.GoodsServiceImpl;
import com.itdr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/backed/goods/*")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private GoodsService goodsService = new GoodsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");

        switch (split[split.length - 1]){
            case "getall":
                getAllGoods(request,response);
                break;
            case "totype":
                toType(request,response);
                break;
            case "toselect":
                toSelect(request,response);
                break;
        }
    }

    // 获取所有商品数据
    private void getAllGoods(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        ResponseCode allGoods = goodsService.getAllGoods();

//        HttpSession httpSession = request.getSession();
//        Users users = (Users)httpSession.getAttribute("us");
//        request.setAttribute("users",users);

        request.setAttribute("goodslist",allGoods);
        request.getRequestDispatcher("/WEB-INF/goodslist.jsp").forward(request,response);
    }

    // 商品下架
    private void toType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("g_id");
        ResponseCode allGoods = goodsService.toType(id);
        // 把数据转成json格式返回
        response.getWriter().write(allGoods.getData().toString());
    }

    // 搜索商品
    private void toSelect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("ss");
        ResponseCode allGoods = goodsService.toSelect(name);

        request.setAttribute("selectgoodslist",allGoods);
        request.getRequestDispatcher("/WEB-INF/goodslist.jsp").forward(request,response);
        response.sendRedirect("/WEB-INF/goodslist.jsp");
    }
}
