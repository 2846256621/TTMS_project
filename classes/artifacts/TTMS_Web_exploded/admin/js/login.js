(function() {
    if (!String.prototype.trim) {
        (function() {
            var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
            String.prototype.trim = function() {
                return this.replace(rtrim, '');
            };
        })();
    }
    [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
        // in case the input is already filled..
        if( inputEl.value.trim() !== '' ) {
            classie.add( inputEl.parentNode, 'input--filled' );
        }
        // events:
        inputEl.addEventListener( 'focus', onInputFocus );
        inputEl.addEventListener( 'blur', onInputBlur );
    } );
    function onInputFocus( ev ) {
        classie.add( ev.target.parentNode, 'input--filled' );
    }
    function onInputBlur( ev ) {
        if( ev.target.value.trim() === '' ) {
            classie.remove( ev.target.parentNode, 'input--filled' );
        }
    }
})();

$(function() {
    $('#login #login-password').focus(function() {
        $('.login-owl').addClass('password');
    }).blur(function() {
        $('.login-owl').removeClass('password');
    });
    $('#login #register-password').focus(function() {
        $('.register-owl').addClass('password');
    }).blur(function() {
        $('.register-owl').removeClass('password');
    });
    $('#login #register-repassword').focus(function() {
        $('.register-owl').addClass('password');
    }).blur(function() {
        $('.register-owl').removeClass('password');
    });
    $('#login #forget-password').focus(function() {
        $('.forget-owl').addClass('password');
    }).blur(function() {
        $('.forget-owl').removeClass('password');
    });
});

//登录
function login(){
    var managername = $("#login-username").val(),
        managerpassword = $("#login-password").val(),
        validatecode = null,
        flag = false;
    //判断用户名密码是否为空
    if(managername === ""){
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
    if(managerpassword === ""){
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
    var regExp = new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]{1,15}$");
    if(!regExp.test(managername)){
        $.pt({
            target: $("#login-username"),
            position: 'r',
            align: 't',
            width: 'auto',
            height: 'auto',
            content:"用户名必须为15位以下的字母或数字或汉字"
        });
        flag = true;
    }

    if(flag){
        return false;
    }else{//登录
        //调用后台登录验证的方法
        var user ={};
        user.managername = managername;
        user.managerpassword = managerpassword;
        $.ajax({
            type:'POST',
            dataType:'json',
            data:user,
            traditional:true,
            url:'http://ttms.time.com:8080/TTMS/LoginManager',
            success:function (data) {
                console.log(data);
                if(data){
                    alert('登录成功');
                   sessionStorage.setItem("managername",managername);
                   sessionStorage.setItem("managerpassword",managerpassword);
                   window.location = 'http://ttms.time.com:8080/TTMS/admin/pages/studio.jsp';
                }
                else {
                    alert('请重新重新登录');
                    $("#login-password").val("");
                }
            }
        });
        // sessionStorage.setItem("managername",managername);
        //            sessionStorage.setItem("managerpassword",managerpassword);
        //            window.location = 'http://ttms.time.com:8080/TTMS/admin/pages/studio.jsp';
    }
}

