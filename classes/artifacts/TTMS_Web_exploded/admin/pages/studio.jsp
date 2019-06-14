<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/studio.css" rel="stylesheet">
    <link href="../css/fonts/fonts/font_gz477vuyuhr/iconfont.css" rel="stylesheet">
    <link href="../css/fonts/font_6oegeyedtnu/iconfont.css" rel="stylesheet">
    <title>影厅管理</title>
    <script src="../js/tools/jquery-2.1.3.min.js"></script>
    <script src="../js/tools/bootstrap.min.js"></script>

</head>
<body onload="init()">
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
                                href="studio.jsp"> <span style="color:red;font-size: 17px" >演出厅管理</span></a></td>
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

    <div class="col-md-10" style="padding-top: 10px">
        <!-- 查询块 -->
        <div class="search">
            <form class="form-inline" name="myForm" action="#" method="post">
                演出厅名称:
                <label for="studio_name"></label><input type="text" class="form-control" id="studio_name" name="studioname"/>&nbsp;&nbsp;
                <input type="button" class="btn" style="background-color:#486c76;color: #fffdef;" value="查   询" onclick="search()" />&nbsp;&nbsp;
                <input type="button" class="btn btn-success" value="增   加" onclick="addDetail('add')" />
            </form>
        </div>
        <!-- 员工信息显示-->
        <div style="padding-top: 10px;">
            <table id="table" class="table table-bordered table-hover"
                   style="text-align: center;">
                <tr>
                    <th>演出厅编号</th>
                    <th>演出厅名称</th>
                    <th>座位行数</th>
                    <th>座位列数</th>
                    <th>操作</th>
                </tr>
            </table>
        </div>

    </div>
</div>
<!--遮罩弹窗-->
<div id="addDiv">
    <div id="addDetail">
        <div class="col-md-10" style="margin: 30px">
            <form id="myform" class="form-horizontal" role="form" action="#"
                  method="post">
                <input type="hidden" id="type" name="type">
                <div class="form-group">
                    <label class="col-sm-2 control-label">影厅编号</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="studioid"
                               id="studioid" disabled="disabled">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影厅名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="studioname"
                               id="studioname" placeholder="请输入影厅名称">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">座位行数</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="rowcount"
                               id="rowcount" placeholder="请输入座位行数">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">座位列数</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="colcount"
                               id="colcount" placeholder="请输入座位列数">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2 control-label"
                         style="color: red; font-weight: bold;"></div>
                    <div class="col-sm-6" >
                        <button type="button" class="btn btn-primary" onclick="check('add')" id="sub_btn">提 交</button>
                        <button type="button" class="btn btn-success" id="addShut" >返回</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<div id="bgDiv"></div>
<script src="../js/studio.js"></script>
</body>
</html>
