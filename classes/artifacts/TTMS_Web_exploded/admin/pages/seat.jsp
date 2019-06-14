<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>座位管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/studio.css" rel="stylesheet">
    <link href="../css/fonts/fonts/font_gz477vuyuhr/iconfont.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/mange_seat.css">
    <script src="../js/tools/jquery-2.1.3.min.js"></script>
    <script src="../js/tools/bootstrap.min.js"></script>
</head>
<body>
<div id="title" >小时光影院管理系统</div>
<div class="row" style="margin: 10px 10px">
    <!-- 左导航栏 -->
    <div class="col-md-2">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">导航</h3>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <tr>
                        <td><span class="iconfont icon-dianying1"></span>&nbsp;&nbsp;<a
                                href="studio.jsp">演出厅管理</a></td>
                    </tr>
                    <tr>
                        <td><span class="iconfont icon-dianying"></span>&nbsp;&nbsp;<a
                                href="play.jsp">剧目管理</a></td>
                    </tr>
                    <tr>
                        <td><span class="iconfont icon-jihuaguanli"></span>&nbsp;&nbsp;<a
                                href="schedule.jsp">计划管理</a></td>
                    </tr>

                </table>
            </div>
        </div>
    </div>

    <div id="seat-con" class="col-md-9" style="padding-top: 10px">
        <div class="left_pad">
            <div id="screen">
                <span>屏幕</span>
            </div>
            <div id="seat"></div>
        </div>
        <div class="right_pad">
            <div id="update">
                <div id="modify_seat">
                    <span style="color: #4f984f">已修改的位置：</span><br>

                </div>
                <button id="modify_ok">确认修改</button>
            </div>

            <div id="select-bottom">
                <div class="div1"></div><div>正常</div>
                <div class="div1" style="background-color: #86415e"></div><div>已损坏</div>
            </div>
        </div>

    </div>
</div>
<script src="../js/seat.js"></script>
</body>
</html>
