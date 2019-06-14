$(function () {
    login_change(); //登录导航栏变化
    init(); //轮播图初始化
    clickChange(); //点击切换轮播图
    setInterval(change,3000); //自动切换轮播图
    $.ajax({
        type:'GET',
        url:'http://ttms.time.com:8080/TTMS/Index',
        traditional: true,
        dataType:"json",
        success:function (data) {
            load(data);//得到请求的页面数据  动态加载
        }
    });

});
//得到请求的页面数据  动态加载
function load(data) {
    for(var i=0;i<data.length;i++){
        var con =  $(`            <li class="poster-warp">
                <a href="./user/pages/watch.jsp?playid=${data[i].playid}">
                    <div class="movieImg">
                        <img src="${data[i].picture}" width="100%" height="100%">
                    </div>
                    <div class="movieInfo">
                        <p>导演:${data[i].director}</p>
                        <p>主演:${data[i].actor}</p>
                        <p>类型:${data[i].playtype}</p>
                        <p>地区:${data[i].country}</p>
                        <p>语言:${data[i].language}</p>
                        <p>片长:${data[i].duration}分钟</p>
                    </div>
                    <div class="movie-name">
                        <div class="film-name-warp">${data[i].playname}</div>
                    </div>
                    <div class="openTime">
                        <span class="buy-ticket">
                            <p style="text-align: center;padding-top:10px ">购票</p>
                        </span>
                    </div>
                </a>
            </li>`);
        if(i<6){
            $('#one').append(con);
            var val1 = con[0].querySelector(".movieImg");
            val1.onmouseover = movie_info_show;
            val1.onmouseout = movie_info_hidden;
        }
        else{
            $('#two').append(con);
            var val2 = con[0].querySelector(".movieImg");
            val2.onmouseover = movie_info_show;
            val2.onmouseout = movie_info_hidden;
        }
    }

}

//登录时导航栏变化
function login_change() {
    var login = document.getElementById("login");
    var order = document.getElementById("order");
    login.innerText = window.sessionStorage.getItem("username") === null?'登录注册':sessionStorage.getItem("username");
    if(login.innerText !== '登录注册'){
        login.href ="#";
        var exit = document.createElement('div');
        exit.innerText='退出登录';
        exit.className = 'exit';
        order.innerText = '我的订单';
        order.parentElement.appendChild(exit);

        exit.onclick=function () {
            window.location = 'http://ttms.time.com:8080/TTMS/userIndex.jsp';
            window.sessionStorage.removeItem("username");
            window.sessionStorage.removeItem("password");
        }
    }
    else{
        order.href = '#';
    }
}

/*初始化*/
function init(){
    var imgs = document.getElementsByClassName("movie-img");
    var spans = document.querySelectorAll("#count span");
    for (var i = 0; i < imgs.length; i++) {
        imgs[i].style.opacity = '0';
        spans[i].style.backgroundColor = "";
    }
    imgs[0].style.opacity = '1';
    spans[0].style.backgroundColor = "#e97405";
}

/*电影详细信息显示*/
function movie_info_show(e) {
    var event = e.target.parentElement.nextElementSibling;
    event.style.visibility = "visible";
}
/*电影详细信息隐藏*/
function movie_info_hidden(e) {
    var event = e.target.parentElement.nextElementSibling;
    event.style.visibility = "hidden";
}

var num = 0;
/*点击切换图片*/
function clickChange(){
    var leftDiv = document.getElementById("left");
    var rightDiv =document.getElementById("right");
    var imgs = document.getElementsByClassName("movie-img");
    var spans = document.querySelectorAll("#count span");
    rightDiv.onclick = function () {
        num++;
        num = num % 5 ;
        for (var i = 0; i < imgs.length; i++) {
            imgs[i].style.opacity = '0';
            spans[i].style.backgroundColor = "";
        }
        spans[num].style.backgroundColor = "#e97405";
        imgs[num].style.opacity = '1';
    };
    leftDiv.onclick = function () {
        num--;
        if(num < 0){
            num= 4;
        }
        for (var i = 0; i < imgs.length; i++) {
            imgs[i].style.opacity = '0';
            spans[i].style.backgroundColor = "";
        }
        spans[num].style.backgroundColor = "#e97405";
        imgs[num].style.opacity = '1';
    }
}

/*自动切换*/
function change() {
    var imgs = document.getElementsByClassName("movie-img");
    var spans = document.querySelectorAll("#count span");
    num++;
    num = num % 5 ;
    for (var i = 0; i < imgs.length; i++) {
        imgs[i].style.opacity = '0';
        spans[i].style.backgroundColor = "";
    }
    spans[num].style.backgroundColor = "#e97405";
    imgs[num].style.opacity = '1';
}
