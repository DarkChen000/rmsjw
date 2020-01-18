<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/1/14
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorpage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>后台首页</title>
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

    <form action="/backed/goods/toselect" method="post">
        <input type="text" placeholder="请输入搜索信息" name="ss">
        <input type="submit" value="搜索">
    </form>

    <c:if test="${not empty goodslist.data}">
        <table id="tt">
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品详情</th>
                <th>商品库存</th>
                <th>商品类型</th>
                <th>商品在售</th>
                <th>商品创建时间</th>
                <th>商品更新时间</th>
            </tr>
            <c:forEach items="${goodslist.data}" var="p">
                <tr>
                    <td>${p.g_id}</td>
                    <td>${p.g_name}</td>
                    <td>${p.g_price}</td>
                    <td>${p.g_details}</td>
                    <td>${p.g_count}</td>
                    <td>${p.g_type}</td>
                    <td class="pt">${p.g_goodstype}</td>
                    <td>${p.g_createtime}</td>
                    <td>${p.g_updatetime}</td>
                    <td>
                        <button onclick="toType(this)">下架</button>
                        <button>修改</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <%--<c:if test="${empty goodslist.data}">--%>
        <%--没有更多的商品--%>
    <%--</c:if>--%>

    <c:if test="${not empty selectgoodslist.data}">
        <table id="tt">
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品详情</th>
                <th>商品库存</th>
                <th>商品类型</th>
                <th>商品在售</th>
                <th>商品创建时间</th>
                <th>商品更新时间</th>
            </tr>
            <c:forEach items="${selectgoodslist.data}" var="g">
                <tr>
                    <td>${g.g_id}</td>
                    <td>${g.g_name}</td>
                    <td>${g.g_price}</td>
                    <td>${g.g_details}</td>
                    <td>${g.g_count}</td>
                    <td>${g.g_type}</td>
                    <td>${p.g_goodstype}</td>
                    <td>${g.g_createtime}</td>
                    <td>${g.g_updatetime}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    
</div>
</body>
<%--工程路径--%>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    function toType(but) {
        var id2 = $(but).parent().parent().children().first().text();
        $.get(
            "/backed/goods/totype",
            {g_id:id2},
            function (data) {
                var num = Number(data);
                if (data>0){
                    var id2 = $(but).parent().parent().children().first().nextAll(".pt").text(1);
                }
            }
        )
    }
    
</script>
</html>
