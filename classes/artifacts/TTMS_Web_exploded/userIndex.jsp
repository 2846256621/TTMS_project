<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="user/css/index.css" rel="stylesheet">
    <link rel="stylesheet" href="user/css/font_icon/font_index/iconfont.css">
    <link rel="stylesheet" href="user/css/font_icon/font_8frsq860w49/iconfont.css">
    <link rel="stylesheet" href="user/css/font_icon/font_h61hgb9f2v5/iconfont.css">
    <script src="user/Javascript/tool/jquery-3.3.1.min.js"></script>
</head>
<body>
<div id="container-head">
    <div id="nav">
        <img src="user/image/logo.jpg" width="80px">
        <div>
            <span>小时光影院</span>
        </div>
        <ul>
            <li><span class="iconfont icon-shouye icons"></span>
                <a href="userIndex.jsp">首页</a></li>
            <li><span class="iconfont icon-dianying icons"></span>
                <a href="user/pages/movie.jsp" style="top: 27%;width: 40px">电影</a></li>
        </ul>
        <div>
            <span class="iconfont icon-qunfengguanlizhongxin icons" style="font-weight: 900"></span>
            <a href="user/pages/order.jsp" style="text-decoration: none;color: #828282" id="order">小时光，欢迎你</a>
        </div>
        <div>
            <span class="iconfont icon-gerenzhongxin icons"></span>
            <a href="http://ttms.time.com:8080/TTMS/user/login/login.jsp" style="text-decoration: none;color: #828282" id="login">登录/注册</a></div>
    </div>
</div>

<div id="container">
    <img src="user/image/1.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/2.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/3.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/4.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/5.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/6.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/7.jpg" alt="floorImg" class="movie-img">
    <img src="user/image/8.jpg" alt="floorImg" class="movie-img">
    <div id="left">
        <i class="iconfont icon-iconfontjiantou1"></i>
    </div>
    <div id="right">
        <i class="iconfont icon-youjiantou"></i>
    </div>
    <div id="count">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
    </div>
</div>
<div class="container-movie">
    <div class="title">
        <span>正在热映</span>
    </div>
    <div class="movie" >
        <ul id="one">
        </ul>
    </div>
</div>
<div class="container-movie">
    <div class="title">
        <span>即将上映</span>
    </div>
    <div class="movie" >
        <ul id="two"></ul>
    </div>
</div>
<div id="container-foot">
    <span> 关于小时光 : 关于我们  管理团队  投资者关系      友情链接 : 美团网  格瓦拉  美团下载  欢喜首映</span><br>
    <span> 商务合作邮箱：v@maoyan.com 客服电话：10105335 违法和不良信息举报电话：4006018900</span> <br>
    <span>投诉举报邮箱：tousujubao@meituan.com 舞弊线索举报邮箱：wubijubao@maoyan.com</span><br>
    <span>©2016 小时光电影 maoyan.com 京ICP证160733号 京ICP备16022489号-1 京公网安备 11010102003232号 网络文化经营许可证 电子公告服务规则</span><br>
    <span>北京小时光文化传媒有限公司</span>
</div>
<script src="user/Javascript/index.js"></script>
</body>
</html>
