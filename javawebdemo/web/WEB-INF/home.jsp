<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/1/14
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorpage.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        #left{
            width: 30%;
            height: 100%;
            float: left;
            background-color: antiquewhite;
        }
        #right{
            width: 70%;
            float: right;
            background-color: bisque;
        }
    </style>
</head>
<body>
<div id="left">
    <p>
        <a href="/backed/index/home">回到首页</a>
    </p>
    <h1>欢迎${us.username}登录管理后台</h1>
    <a href="/backed/goods/getall">获取所有商品数据</a>
</div>
<div id="right">
</div>
</body>
</html>
