<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>座位</title>
    <link rel="stylesheet" href="../css/seat.css">
    <link rel="stylesheet" href="../css/font_icon/font_8frsq860w49/iconfont.css">
    <link rel="stylesheet" href="../css/font_icon/font_h61hgb9f2v5/iconfont.css">
    <script src="../Javascript/tool/jquery-3.3.1.min.js"></script>
</head>
<body>
<div id="container-head">
    <div id="nav">
        <img src="../image/logo.jpg" width="80px">
        <div>
            <span>小时光影院</span>
        </div>
        <ul>
            <li><span class="iconfont icon-shouye icons"></span><a href="../../userIndex.jsp">首页</a></li>
            <li><span class="iconfont icon-dianying icons"></span><a href="../pages/movie.jsp" style="top: 27%;width: 40px">电影</a></li>
        </ul>
        <div>
            <span class="iconfont icon-qunfengguanlizhongxin icons" style="font-weight: 900"></span>
            <a href="../pages/order.jsp" style="text-decoration: none;color: #828282" id="order">小时光，欢迎你</a>
        </div>
        <div>
            <span class="iconfont icon-gerenzhongxin icons"></span>
            <a href="http://ttms.time.com:8080/TTMS/user/login/login.jsp" style="text-decoration: none;color: #828282" id="login">登录/注册</a></div>
    </div>
</div>
<div id="title">
    <span>在线选座</span>
</div>
<div id="container">
    <div>
        <div id="screen">
            <span>屏幕</span>
        </div>
        <div id="seat"></div>
        <div id="select">
            <div id="select-right"></div>
            <button id="show">购买</button>
            <div id="select-bottom">
                <div class="div1"></div><div>可选座</div>
                <div class="div1" style="background-color: #f69b21"></div><div>已出售</div>
                <div class="div1" style="background-color: #b4abaf"></div><div>已坏</div>
            </div>
        </div>
    </div>
</div>

<!--遮罩-->
<div id="fade" class="cover"></div>
<div id="pay" class="cover-content">
    <div id="close">
        <span>确认订单</span>
        <span>关闭</span>
    </div>
    <div id="pay-content">
        <div id="pay-content-details">
            <span id="name">姓名：</span><br>
            电影：<span id="movie_name"></span><br>
            放映厅：<span id="movie-studio"></span><br>
            时间： <span id="movie-date"></span><br>
            <div id="saled_seat">座位：</div>
            <span id="all_price"></span>
        </div>
        <button id="pay_ok">确认支付</button>
    </div>
</div>
<script type="text/javascript" src="../Javascript/seat.js"></script>
</body>
</html>

