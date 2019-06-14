<%--
  Created by IntelliJ IDEA.
  User: 小本
  Date: 2019/6/9
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/sign-up-login.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/inputEffect.css" />
    <link rel="stylesheet" href="css/tooltips.css" />
    <link rel="stylesheet" href="css/spop.min.css" />

    <script src="js/jquery.min.js"></script>
    <script src="js/snow.js"></script>
    <script src="js/jquery.pure.tooltips.js"></script>
    <script src="js/spop.min.js"></script>
    <script src="js/login.js"></script>

    <!-- vaptcha  css js -->

    <script src="https://cdn.vaptcha.com/v2.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.vaptcha.com/theme_https.2.2.1.css" id="vaptcha_style">
    <style>
        .vaptcha-init-main {
            display: table;
            width: 100%;
            height: 100%;
            background-color: #EEEEEE;
        }
        .vaptcha-init-loading {
            display: table-cell;
            vertical-align: middle;
            text-align: center
        }
        .vaptcha-init-loading>a {
            display: inline-block;
            width: 18px;
            height: 18px;
            border: none;
        }
        .vaptcha-init-loading>a img {
            vertical-align: middle
        }
        .vaptcha-init-loading .vaptcha-text {
            font-family: sans-serif;
            font-size: 12px;
            color: #CCCCCC;
            vertical-align: middle
        }
    </style>
    <!-- vaptcha  css js -->

</head>
<body>
<!-- 雪花背景 -->
<div class="snow-container"></div>
<!-- 登录控件 -->
<div id="login">
    <input id="tab-1" type="radio" name="tab" class="sign-in hidden" checked />
    <input id="tab-2" type="radio" name="tab" class="sign-up hidden" />
    <input id="tab-3" type="radio" name="tab" class="sign-out hidden" />
    <div class="wrapper">
        <!-- 登录页面 -->
        <div class="login sign-in-htm">
            <form action="" method="post" class="container offset1 loginform" style="border-radius: 5px">
                <!-- 猫头鹰控件 -->
                <div  class="login-owl">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad input-container">
                    <section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="login-username"
                                       autocomplete="off" placeholder="请输入用户名" tabindex="1" maxlength="15" name="username"/>
								<label class="input__label input__label--hideo" for="login-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="login-password" placeholder="请输入密码" tabindex="2" maxlength="15" name="password"/>
								<label class="input__label input__label--hideo" for="login-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
                                <div id="vaptchaContainer" style="width:310px;height:200px;"></div>
                        </span>
                    </section>
                </div>
                <div class="form-actions">
                    <a tabindex="4" class="btn pull-left btn-link text-muted">欢迎登录</a>
                    <a tabindex="5" class="btn btn-link text-muted" onClick="goto_register()">注册</a>
                    <input type="hidden" name="ifAuth" id="ifAuth" value="0"/>
                    <input class="btn btn-primary" id="loginButon" type="button" tabindex="3"  value="登录" style="color:white;"/>
                </div>
            </form>
    </div>

        <!-- 注册页面 -->
        <div class="login sign-up-htm">
            <form action="" method="post" class="container offset1 loginform" style="border-radius: 5px">
                <!-- 猫头鹰控件 -->
                <div id="owl-login" class="register-owl">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad input-container">
                    <section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="register-username"
                                       autocomplete="off" placeholder="请输入用户名" maxlength="15" name="username"/>
								<label class="input__label input__label--hideo" for="register-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="register-password" placeholder="请输入密码" maxlength="15" name="password"/>
								<label class="input__label input__label--hideo" for="register-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="register-repassword" placeholder="请确认密码" maxlength="15" name="password_again"/>
								<label class="input__label input__label--hideo" for="register-repassword">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>

                    </section>
                </div>
                <div class="form-actions">
                    <a class="btn pull-left btn-link text-muted" onClick="goto_login()">返回登录</a>
                    <input class="btn btn-primary" type="button" onClick="register()" value="注册" style="color:white;"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../Javascript/tool/jquery-3.3.1.min.js"></script>
<script>
$("#loginButon").click(function(){
	 
	    let username = $("#login-username").val(),
	        password = $("#login-password").val(),
	        ifAuth = $("#ifAuth").val();
	        validatecode = null,
	        flag = false;
	        //校验是否 人机认证
	        if(ifAuth == 0){
	        	alert("请先认证！");
	        	return ;
	        }
	        
	    //判断用户名密码是否为空
	    if(username === ""){
	        $.pt({
	            target: $("#login-username"),
	            position: 'r',
	            align: 't',
	            width: 'auto',
	            height: 'auto',
	            content:"用户名不能为空"
	        });
	        flag = true;
	    }
	    if(password === ""){
	        $.pt({
	            target: $("#login-password"),
	            position: 'r',
	            align: 't',
	            width: 'auto',
	            height: 'auto',
	            content:"密码不能为空"
	        });
	        flag = true;
	    }
	    //用户名只能是15位以下的字母或数字
	    let regExp = new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]{1,15}$");
	    if(!regExp.test(username)){
	        $.pt({
	            target: $("#login-username"),
	            position: 'r',
	            align: 't',
	            width: 'auto',
	            height: 'auto',
	            content:"用户名必须为15位以下的字母或数字"
	        });
	        flag = true;
	    }

	    if(flag){
	        return false;
	    }else{//登录
	        //调用后台登录验证的方法
	        let user ={};
	        user.username = username;
	        user.password = password;
	        $.ajax({
	            type:'POST',
	            dataType:'json',
	            data:user,
	            url:'http://ttms.time.com:8080/TTMS/Login',
	      
	            success:function (data) {
	                console.log(data);
	                if(data.flag === 'true'){
	                    alert('登录成功');
	                    // TODO cookies  localStorage
	                   sessionStorage.setItem("username",username);
	                   sessionStorage.setItem("password",password);
	                   sessionStorage.setItem('userid',data.userid);
	                   window.location = 'http://ttms.time.com:8080/TTMS/userIndex.jsp';
	                }
	                else {
	                    alert('请重新重新登录');
	                    $("#login-password").val("");
	                }
	            }
	        });
	        // sessionStorage.setItem("username",username);
	        // sessionStorage.setItem("password",password);
	        // window.location = 'http://ttms.time.com:8080/TTMS/userIndex.jsp';
	    }
	
});


    vaptcha({
        vid: '5d008acdfc650e4fe0a3b2a2', // 验证单元id
        type: 'embed', // 显示类型 点击式
        container: '#vaptchaContainer' // 按钮容器，可为Element 或者 selector
    }).then(function (vaptchaObj) {

        vaptchaObj.listen('pass', function() {
            // 验证成功， 进行登录操作
            console.log("验证成功！");
            $("#ifAuth").val("1");
            
        });
        vaptchaObj.render()// 调用验证实例 vpObj 的 render 方法加载验证按钮
    });
</script>

</body>
</html>
