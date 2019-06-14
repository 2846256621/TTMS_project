$(function () {
    login_change(); //更新导航栏
    $.ajax({
        type:'GET',
        url:'http://ttms.time.com:8080/TTMS/Index',
        dataType:'json',
        success:function (data) {
            load_movie(data);
        }

    })
});
//与首页请求的数据  共用数据 显示全部电影
function load_movie(data) {
    for(var i=0;i<data.length -1;i++){
        var con = $(`            <li class="poster-warp">
                <a href="../pages/watch.jsp?playid=${data[i].playid}">
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
        $('#movie-list').append(con);
        var val = con[0].querySelector(".movieImg");
        val.onmouseover = movie_info_show;
        val.onmouseout = movie_info_hidden;
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