<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>演出计划管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/studio.css" rel="stylesheet">
    <link href="../css/fonts/fonts/font_gz477vuyuhr/iconfont.css" rel="stylesheet">
    <link href="../css/fonts/font_6oegeyedtnu/iconfont.css" rel="stylesheet">
    <script src="../js/tools/jquery-2.1.3.min.js"></script>
    <script src="../js/tools/bootstrap.min.js"></script>
    <style>
        .col-sm-6{
            width: 56%;
        }
        .col-sm-6 button {
            margin: 20px;
        }
        #bgDiv{
   		position:fixed;
   		}
    </style>
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
                                href="schedule.jsp"> <span style="color:red;font-size: 17px" >计划管理</span></a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="col-md-10" style="padding-top: 10px">
        <!-- 查询块 -->
        <div class="search">
            <form class="form-inline" name="myForm" action="#" method="post">
                剧目名称:
                <label for="shedule_search"></label><input type="text" class="form-control" id="shedule_search" name="shedule_search"/>&nbsp;&nbsp;
                <input type="button" class="btn" style="background-color:#486c76;color: #fffdef;" value="查   询" onclick="search()" />&nbsp;&nbsp;
                <input type="button" class="btn btn-success" value="增   加" onclick="addDetail('add')" />
            </form>
        </div>
        <!-- 员工信息显示-->
        <div style="padding-top: 10px;">
            <table id="table" class="table table-bordered table-hover"
                   style="text-align: center;">
                <tr>
                    <th>计划编号</th>
                    <th>剧目名称</th>
                    <th>上映时间</th>
                    <th>演出厅</th>
                    <th>剧目单价</th>
                    <th>开始时间</th>
                    <th>操作</th>
                </tr>
            </table>
        </div>

    </div>
</div>
<!--遮罩弹窗-->
<div id="addDiv">
    <div id="addDetail">
        <div class="col-md-10" style="margin-top: 30px">
            <form id="myform" class="form-horizontal" role="form" action="#"
                  method="post">
                <input type="hidden" id="type" name="type">

                <div class="form-group">
                    <label class="col-sm-2 control-label">影片编号</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="shedule_id"
                               id="shedule_id" disabled="disabled">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="shedule_name"
                               id="shedule_name" placeholder="请输入影片名称">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">上映时间</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="shedule_date"
                               id="shedule_date" placeholder="请输入影片上映时间">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">演出厅</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="shedule_studio"
                               id="shedule_studio" placeholder="请输入所在放映厅">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片单价</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="shedule_price"
                               id="shedule_price" placeholder="请输影片单价">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">开始时间</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="shedule_begintime"
                               id="shedule_begintime" placeholder="请输影片开始时间">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2 control-label"
                         style="color: red; font-weight: bold;"></div>
                    <div class="col-sm-6" >
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-primary" onclick="check('add')" id="sub_btn">提
                            交</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-success" id="addShut" >返回</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<div id="bgDiv"></div>
<script src="../js/shedule.js"></script>
</body>
</html>
