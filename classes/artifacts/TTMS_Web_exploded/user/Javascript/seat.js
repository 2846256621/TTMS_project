
$(function () {
    var data = resolveUrl(); //解析通过url从前一个页面带过来的数据
    login_change();//登录时导航栏变化

    //设置sessionStorage
    var seat = document.getElementById('seat');
    var username = document.querySelector("#name");
    username.innerText += window.sessionStorage.getItem("username");

    //阻止选中文字
    document.onselectstart = function () {
        return false;
    };
    //点击添加座位
    seat.onclick = function (e) {
        add_seats(e);
    };

    //弹窗显示
    document.getElementById('show').onclick = showtc;
    //弹窗关闭
    document.getElementById('close').onclick =  closetc;

    //请求座位数据
    again_load();
    //购买票 并发送所有关于票的数据
    all_seat_send(data);

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

        exit.onclick = function () {
            window.location = 'http://ttms.time.com:8080/TTMS/userIndex.jsp';
            window.sessionStorage.removeItem("username");
            window.sessionStorage.removeItem("password");
        }
    }
    else{
        order.href = '#';
    }
}
//弹窗显示
function showtc() {
    if(window.sessionStorage.getItem('username') === null){
        alert('请先登录');
        return;
    }
    var all_new_seat = document.querySelectorAll('#add-seat div'); //所以新添加的座位
    var all_price = document.getElementById('all_price');
    var price = document.getElementById('price');
    document.getElementById('pay').style.display = 'block';
    document.getElementById('fade').style.display = 'block';
    var hidden_Ele = document.getElementById('fade');
        hidden_Ele.style.width = document.scrollWidth;
        $("#fade").height($(document).height());
        all_price.innerHTML = `应付金额：<span style="color: red">￥${all_new_seat.length * parseInt(price.innerText)}</span>`;
}
//弹窗关闭
function closetc() {
    document.getElementById('pay').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
}
//动态显示总价
function computePrice() {
    var allSelectedSeat = document.querySelectorAll('#add-seat div');
    var singlePrice = document.querySelector('#price').innerText;
    var allPriceEle = document.querySelector('.all_price');

    allPriceEle.innerText = `总价: ￥${allSelectedSeat.length * parseInt(singlePrice)}`;
}

//创建座位请求
function again_load(){
     $.ajax({
         type:'get',
         dataType:'json',
         data:{
             studioid:data.studioid
         },
         url:"http://ttms.time.com:8080/TTMS/MovieSeat",
         success:function (data) {
           create_seat(data);
         }
     });
 }
function arrTrans(num, arr) { // 一维数组转换为二维数组
    var iconsArr = []; // 声明数组
    arr.forEach(function(item, index){
        var page = Math.floor(index / num); // 计算该元素为第几个素组内
        if (!iconsArr[page]) { // 判断是否存在
            iconsArr[page] = [];
        }
        iconsArr[page].push(item);
});
    return iconsArr;
}
//动态请求 创建座位
function create_seat(data) {
    //循环创建座位
    var arr2 =[];
    for(var i=0;i<data.seat.length;i++){
        arr2.push(data.seat[i].seatstatus);
    }
    var arr = arrTrans(data.colcount,arr2); //一维数组变成二维数组
    console.log(arr);

    for ( i = 0; i < data.rowcount; i++) {
        var seatEle = document.getElementById('seat');
        var div = document.createElement('div');
        var div_row = document.createElement('div');
        div.innerText += i+1; //列
        div.className = 'div2';
        div_row.appendChild(div);
        div_row.className="div_row";
        for ( j = 0; j < data.colcount; j++) {

            if (arr[i][j] === 1) {
                var div1 = document.createElement('div');
                var seat_data1 = JSON.stringify({seatrow: i+1 , seatcol: j+1}); //设置每个座位的行列号
                div1.className = 'div1';
                div1.innerText += j+1 ; //行
                div1.setAttribute('pos', seat_data1); //将行列号设置为div的pos属性
                div_row.appendChild(div1);
            }
            else if (arr[i][j] === 2) {
                var div2 = document.createElement('div');
                var seat_data2 = JSON.stringify({seatrow: i+1, seatcol: j+1 }); //设置每个座位的行列号
                div2.className = 'div3';
                div2.innerText += j+1 ; //行
                div2.setAttribute('pos', seat_data2); //将行列号设置为div的pos属性
                div_row.appendChild(div2);
            }
            else if(arr[i][j] === 3){
                var div3 = document.createElement('div');
                var seat_data3 = JSON.stringify({seatrow: i+1, seatcol: j+1}); //设置每个座位的行列号
                div3.className = 'div4';
                div3.innerText += j+1 ; //行
                div3.setAttribute('pos', seat_data3); //将行列号设置为div的pos属性
                div_row.appendChild(div3);
            }
            else {
                var div4 = document.createElement('div');
                div4.className = 'div2';
                div_row.appendChild(div4);
            }
            seatEle.appendChild(div_row);
        }
    }
}
//点击添加座位
function add_seats(e) {
    var event = e || window.event;
    var target = event.target || event.srcElement;
    if (target.className.toLowerCase() === 'div1') {
        var data = JSON.parse(target.getAttribute('pos'));//获取行列对象
        var data_content = `${data.seatrow}排${data.seatcol}列`;//设置添加座位的内容
        var add_seat = document.querySelector('#add-seat'); //添加座位的父元素
        var all_new_seat = document.querySelectorAll('#add-seat div'); //所以新添加的座位
        var saled_seat = document.getElementById('saled_seat');//售出的座位
        var all_saled_seat = document.querySelectorAll('#saled_seat span'); //售出的具体座位

        if (target.style.backgroundColor === 'red') {
            for (var i = 0; i < all_new_seat.length; i++) {
                if (data_content === all_new_seat[i].innerText) {
                    add_seat.removeChild(all_new_seat[i]);
                    saled_seat.removeChild(all_saled_seat[i]);
                    computePrice();
                }
            }
            target.style.backgroundColor = '#4f984f';
        }
        else {
            var new_seat = document.createElement('div'); //创建添加的座位结点
            new_seat.setAttribute('pos', JSON.stringify(data));
            new_seat.innerText = data_content;//设置座位内容
            var saled_seat2 = document.getElementById('saled_seat');//售出的座位
            saled_seat2.innerHTML += `<span>${data_content}</span>`;//设置遮罩部分座位的信息
            add_seat.appendChild(new_seat);
            target.style.backgroundColor = 'red';
            computePrice();
        }

    }
}
var data = {};
//解析跳转的url
function resolveUrl(){
    //解析url的search内容
    var search = window.location.search;
    search = decodeURI(search);
    var dataArr = search.slice(1).split('&');

    dataArr.forEach(function (val){
        var tmp = val.split('=');
        data[tmp[0]] = tmp[1];
    });

    return data;
}


//获取到所有购买的座位  设置支付页面内容  并发送数据
function all_seat_send(data){
    console.log(data);
    //通过url地址分解出a便签携带的数据
    var con = $(`<label> 电影：<span id="movie-title">${data.playname}</span>
                </label>
                <div>时间：${data.date}  ${data.begintime}</div>
                <div>放映厅：${data.studioname}</div>
                <div id="add-seat"><p>座位：</p></div><br>
                票价：￥<div id="price">${data.price}</div>
                <div class="all_price">总价：￥ 0</div>
                `);
    $('#select-right').append(con);

    //设置支付订单的内容
    $("#movie-studio").text(data.studioname);
    $('#movie-date').text(data.date);
    $('#movie_name').text(data.playname);


    //点击购买发送给后台座位的数据

    $('#pay_ok').on('click',function () {
        var date = new Date();
        var all_new_seat = $('#add-seat div'); //所有要购买的座位
        var seat =[]; //所购买的座位
        for(var i=0;i<all_new_seat.length;i++){
            seat.push(all_new_seat[i].getAttribute('pos'));//获取行列对象
        }
        //需要发送的数据存储的对象
        var ticket_data= {
            userid:window.sessionStorage.getItem('userid'), //购买的用户名
            scheduleid :data.scheduleid,
            studioid : data.studioid,
            playid : data.playid,
            allprice:data.price * all_new_seat.length,
            ordertime:ordertime = date.toLocaleString( ),
            seat:seat
        };
        
        // 发送购票数据
        $.ajax({
            type:'post',
            data:ticket_data,
            dataType:'json',
            url:"http://ttms.time.com:8080/TTMS/MovieTicket",
            success:function (data) {
                if(ticket_data.seat.length === 0){
                    alert("请先选择座位！");
                }
                else if(data.flag === '1'){
                	alert("正在跳转支付宝界面！请稍等");
                	window.location.href= 'http://ttms.time.com:8080/TTMS/pay/alipay.trade.page.pay.jsp?orderId='+data.orderid+"&allprice="+data.allprice+"&orderName="+data.orderName+"&shopDesc=";
                   // alert("购买成功!");
                   // closetc();
                   // window.location.href= 'http://ttms.time.com:8080/TTMS/user/pages/seat.jsp'+window.location.search;
                }
            }
        });
    });
}


