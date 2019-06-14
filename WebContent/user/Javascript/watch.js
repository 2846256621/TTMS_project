$(function () {
    login_change();//登录时导航栏发生变化
    $.ajax({
        type:'GET',
        url:'http://ttms.time.com:8080/TTMS/MovieDetails'+window.location.search,
        dataType:'json',
        success:function (data) {
            //请求数据  动态创建 电影详情 和 演出计划
            load(data);
        }
    })
});

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

//请求数据 根据所请求的id  动态创建 此电影详情 和 演出计划
function load(data) {
    var content = $(` <div id="movie-img">
                      <img src="${data.picture}">
                      </div>
                      <div id="movie-content">
                       <div id="movie-title"><span>${data.playname}</span></div>
                       <div id="movie-desc">
                       <p>导演:${data.director}</p>
                        <p>主演:${data.actor}</p>
                        <p>类型:${data.playtype}</p>
                        <p>地区:${data.country}</p>
                        <p>语言:${data.language}</p>
                        <p>片长:${data.duration}分钟</p>
                        <p>剧情介绍:${data.introduction}</p>
                       </div>
                     </div>

                 `) ;
    $('#container').append(content);
    var movie_buy_nav = $('#movie-buy-nav');
    var ticket = $(`<span>放映日期</span>
                                <span>开始时间</span>
                                <span>放映厅</span>
                                <span>片长</span>
                                <span>票价</span>
                                <span>购票</span><br>
                                `);

    movie_buy_nav.append(ticket);

    // TODO 多条演出计划
    for(var i=0;i<data.schedule.length;i++){
        var play_plan = $(` <span class="add-desc">${data.schedule[i].date}</span>
                                <span class="add-desc">${data.schedule[i].begintime}</span>
                                <span class="add-desc">${data.schedule[i].studioname}</span>
                                <span class="add-desc">${data.duration}分钟</span>
                                <span class="add-desc" style="color: red">￥${data.schedule[i].price}</span>
                                <span class="add-desc"><a href="http://ttms.time.com:8080/TTMS/user/pages/seat.jsp?playid=${data.playid}&playname=${data.playname}&scheduleid=${data.schedule[i].scheduleid}&price=${data.schedule[i].price}&date=${data.schedule[i].date}&studioid=${data.schedule[i].studioid}&begintime=${data.schedule[i].begintime}&studioname=${data.schedule[i].studioname}">
                                购买
                                </a>
                                </span>
                                <br>
                `);
        movie_buy_nav.append(play_plan);
    }
}