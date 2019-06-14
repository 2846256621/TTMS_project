(function() {
    if (!String.prototype.trim) {
        (function() {
            let rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
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

function goto_register(){
    $("#register-username").val("");
    $("#register-password").val("");
    $("#register-repassword").val("");
    $("#register-code").val("");
    $("#tab-2").prop("checked",true);
}

function goto_login(){
    $("#login-username").val("");
    $("#login-password").val("");
    $("#tab-1").prop("checked",true);
}
//登录

//注册
function register(){
    var username = $("#register-username").val(),
        password = $("#register-password").val(),
        repassword = $("#register-repassword").val(),
        flag = false;
    //判断用户名密码是否为空
    if(username === ""){
        $.pt({
            target: $("#register-username"),
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
            target: $("#register-password"),
            position: 'r',
            align: 't',
            width: 'auto',
            height: 'auto',
            content:"密码不能为空"
        });
        flag = true;
    }
    else{
        if(password !== repassword){
            $.pt({
                target: $("#register-repassword"),
                position: 'r',
                align: 't',
                width: 'auto',
                height: 'auto',
                content:"两次输入的密码不一致"
            });
            flag = true;
        }
    }
    //用户名只能是15位以下的字母或数字
    let regExp = new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]{1,15}$");
    if(!regExp.test(username)){
        $.pt({
            target: $("#register-username"),
            position: 'r',
            align: 't',
            width: 'auto',
            height: 'auto',
            content:"用户名必须为15位以下的字母或数字"
        });
        flag = true;
    }
    //TODO 检查用户名是否已经存在
    //TODO 调后台代码检查用户名是否已经被注册

    if(flag){
        return false;
    }else{//注册
        spop({
            template: '<h4 class="spop-title">注册成功</h4>即将于1秒后返回登录',
            position: 'top-center',
            style: 'success',
            autoclose: 3000,
            onOpen : function(){
                let second = 1;
                let showPop = setTimeout(function(){
                    if(second === 0) {
                        clearTimeout(showPop);
                    }
                    let user ={};
                    user.username = username;
                    user.password = password;
                    $.ajax({
                        type:'POST',
                        dataType:'json',
                        data:user,
                        url:'http://ttms.time.com:8080/TTMS/Sign',
                        success:function (data) {
                            if( data === "true"){
                                $('.spop-body').html('<h4 class="spop-title">注册成功</h4>即将于'+second+'秒后返回登录');
                            }
                            else if(data === "false"){
                                alert('注册失败，请重新注册!');
                            }
                        }
                    });
                    second--;
                },1000);
            },
            onClose : function(){
                goto_login();
            }
        });
        return false;
    }
}


