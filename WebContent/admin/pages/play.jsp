<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 14:52
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
    <title>影片管理</title>
    <script src="../js/tools/jquery-2.1.3.min.js"></script>
    <script src="../js/tools/bootstrap.min.js"></script>
    <style>
   		#bgDiv{
   			position:fixed;
   		}
        #addDiv {
            z-index: 10001;
            width: 800px;
            height: 630px;
            background: white;
            border-radius: 8px;
            position: fixed;
            left: 39%;
            top:20%;
            font-size: 12px;
            margin-left: -225px;
            display: none;
        }
        @media (min-width: 768px){
            .col-sm-6 {
                width: 70%;
            }
        }
        #play_intro{
            height: 100px;

        }
        #myform {
            width: 740px;
            height: 530px;
            font-size: 15px;
            margin: 30px auto;
        }
        #table{
            width: 96%;
        }
        #table tr td:nth-child(6) {
            color: black;
            font-weight: normal;
        }

        #table>tbody>tr>td:nth-child(4){
            border-top: none;
            border-left: none;
            border-right: none;
            width: 120px;
            /*display: table-caption;*/
            /*overflow: hidden;*/
            /*text-overflow:ellipsis;*/
            /*white-space: nowrap;*/
            height: 88px;
            color: black;
            font-weight: normal;
        }
        #table>tbody>tr>td:nth-child(9){
            border-top: none;
            border-left: none;
            border-right: none;
            width: 550px;

            color: black;
            font-weight: normal;
        }
        .col-sm-6 button {
            margin: 20px;
        }
    </style>
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
                                href="studio.jsp"> 演出厅管理</a></td>
                    </tr>
                    <tr>
                        <td><span class="iconfont icon-dianying"></span>&nbsp;&nbsp;<a
                                href="play.jsp"><span style="color:red;font-size: 17px" >剧目管理</span></a></td>
                    </tr>
                    <tr>
                        <td><span class="iconfont icon-jihuaguanli"></span>&nbsp;&nbsp;<a
                                href="schedule.jsp">计划管理</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="col-md-10" style="padding-top: 20px">
        <!-- 查询块 -->
        <div class="search">
            <form class="form-inline" name="myForm" action="#" method="post">
                剧目名称:
                <label for="play_name"></label><input type="text" class="form-control" id="play_name" name="playname"/>&nbsp;&nbsp;
                <input type="button" class="btn" style="background-color:#486c76;color: #fffdef;" value="查   询" onclick="search()" />&nbsp;&nbsp;
                <input type="button" class="btn btn-success" value="增   加" onclick="addDetail('add')" />
            </form>
        </div>
        <!-- 员工信息显示-->
        <div style="padding-top: 10px;">
            <table id="table" class="table table-bordered table-hover"
                   style="text-align: center;">
                <tr>
                    <th>编号</th>
                    <th>剧目名称</th>
                    <th>导演</th>
                    <th>主演</th>
                    <th>类型</th>
                    <th>语言</th>
                    <th>时长</th>
                    <th>国家</th>
                    <th style="width: 550px">影片介绍</th>
                    <th style="width: 10%">操作</th>
                </tr>
            </table>
        </div>

    </div>
</div>
<!--遮罩弹窗-->
<div id="addDiv">
    <div id="addDetail">
        <div class="col-md-10" style="margin-top: 10px">
            <form id="myform" class="form-horizontal" role="form" action="#"
                  method="post">
                <input type="hidden" id="type" name="type">
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片编号</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_id"
                               id="play_id" disabled="disabled">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_names"
                               id="play_names" placeholder="请输入影片名称">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">导演</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_director"
                               id="play_director" placeholder="请输入导演名字">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片主演</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_actor"
                               id="play_actor" placeholder="请输入主演员名字">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">影片类型</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_type"
                               id="play_type" placeholder="请输入影片类型">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片语言</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_language"
                               id="play_language" placeholder="请输入影片语言">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片时长</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_duration"
                               id="play_duration" placeholder="请输入影片时长">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片国家</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="play_country"
                               id="play_country" placeholder="请输入影片国家">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">影片介绍</label>
                    <div class="col-sm-6">
                        <textarea class="form-control" name="play_intro"
                                  id="play_intro" placeholder="请输入影片介绍"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2 control-label"
                         style="color: red; font-weight: bold;"></div>
                    <div class="col-sm-6 text-center" style="width: 50%" >
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
<script src="../js/play.js"></script>
</body>
</html>
