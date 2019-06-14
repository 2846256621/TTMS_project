
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>登录</title>
  <link rel="stylesheet" href="admin/css/css/normalize.css">
  <link rel="stylesheet" href="admin/css/css/login.css">
  <link rel="stylesheet" href="admin/css/css/sign-up-login.css">
  <link rel="stylesheet" type="text/css" href="admin/css/css/font-awesome.min.css">
  <link rel="stylesheet" href="admin/css/css/inputEffect.css" />
  <link rel="stylesheet" href="admin/css/css/tooltips.css" />
  <link rel="stylesheet" href="admin/css/css/spop.min.css" />

  <script src="admin/js/tools/jquery-3.3.1.min.js"></script>
  <script src="admin/js/snow.js"></script>
  <script src="admin/js/tools/jquery.pure.tooltips.js"></script>
  <script src="admin/js/tools/spop.min.js"></script>
  <script src="admin/js/login.js"></script>
</head>
<body>
<!-- 雪花背景 -->
<div class="snow-container"></div>
<div id="title">小时光影院管理系统</div>
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
                                       autocomplete="off" placeholder="请输入管理员名" tabindex="1" maxlength="15" name="username"/>
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
          </section>
        </div>
        <div class="form-actions">
          <a tabindex="4" class="btn pull-left btn-link text-muted">欢迎登录</a>
          <input class="btn btn-primary" type="button" tabindex="3" onClick="login()" value="登录"
                 style="color:white;"/>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
