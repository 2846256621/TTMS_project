<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <link rel="stylesheet" href="../css/font_icon/font_8frsq860w49/iconfont.css">
    <link rel="stylesheet" href="../css/font_icon/font_h61hgb9f2v5/iconfont.css">
    <link href="../css/order.css" rel="stylesheet">
    <script src="../Javascript/tool/jquery-3.3.1.min.js"></script>
    <style>
    #nav ul li:nth-child(1) a {
     border-bottom: none; 
     color:#6b6b6b;
	}
    </style>
</head>
<body>
<div id="container-head">
    <div id="nav">
        <img src="../image/logo.jpg" width="80px">
        <div>
            <span>小时光影院</span>
        </div>
        <ul>
            <li><span class="iconfont icon-shouye icons"></span>
                <a href="../../userIndex.jsp">首页</a></li>
            <li><span class="iconfont icon-dianying icons"></span>
                <a href="../pages/movie.jsp" style="top: 27%;width: 40px">电影</a></li>
        </ul>
        <div>
            <span class="iconfont icon-qunfengguanlizhongxin icons" style="font-weight: 900"></span>
            <a href="../../userIndex.jsp" style="text-decoration: none;color: #828282" id="order">返回首页</a>
        </div>
    </div>
</div>
<div id="container">
    <div class="oder-con">
    </div>
</div>
<script src="../Javascript/order.js"></script>
</body>
</html>
