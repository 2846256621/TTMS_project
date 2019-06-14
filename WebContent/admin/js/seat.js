var urlObj = {};
//解析url
function resolveUrl(){
    var search = window.location.search;
    search = decodeURI(search);
    var dataArr = search.slice(1).split('&');
    urlObj = {};
    dataArr.forEach(function (val) {
        var tmp = val.split('=');
        urlObj[tmp[0]] = tmp[1];
    });
}
//请求座位
function get_seat(){
    $.ajax({
        type: 'get',
        dataType: 'json',
        
        data:{
            studioid:urlObj['studioid']
        },
        url: 'http://ttms.time.com:8080/TTMS/SeatSearch',
        success: function (data) {
                console.log(data.rowcount);
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
        	        div.innerText += i+1 ; //列
        	        div.className = 'div2';
        	        div_row.appendChild(div);
        	        div_row.className="div_row";
        	        for ( j = 0; j < data.colcount; j++) {

        	            if (arr[i][j] === 1 || arr[i][j] === 2) {
        	                var div1 = document.createElement('div');
        	                var seat_data1 = JSON.stringify({seatrow: i+1 , seatcol: j+1 }); //设置每个座位的行列号
        	                div1.className = 'div1';
        	                div1.innerText += j+1 ; //行
        	                div1.setAttribute('pos', seat_data1); //将行列号设置为div的pos属性
        	                div_row.appendChild(div1);
        	            }
        	            else if(arr[i][j] === 3){
        	                var div2 = document.createElement('div');
        	                var seat_data2 = JSON.stringify({seatrow: i+1 , seatcol: j+1 }); //设置每个座位的行列号
        	                div2.className = 'div3';
        	                div2.innerText += j+1 ; //行
        	                div2.setAttribute('pos', seat_data2); //将行列号设置为div的pos属性
        	                div_row.appendChild(div2);
        	            }
        	            else {
        	                var div3 = document.createElement('div');
        	                div3.className = 'div2';
        	                div_row.appendChild(div3);
        	            }
        	            seatEle.appendChild(div_row);
        	        }
        	    }
        	        var seat = document.getElementById('seat');
        	        //阻止选中文字
        	        document.onselectstart = function () {
        	            return false;
        	        };
        	        //点击添加座位
        	        seat.onclick = function (e) {
        	            var event = e || window.event;
        	            var target = event.target || event.srcElement;
        	            refresh(target);
        	            if (target.className.toLowerCase() === 'div1') {
        	                target.className = 'div3';
        	            }
        	            else if (target.className.toLowerCase() === 'div3') {
        	                target.className = 'div1';
        	            }
        	        };

        	        //确认修改 发送请求
        	        var modify_ok = document.getElementById("modify_ok");
        	        modify_ok.onclick = modifySub_ok;

        	    }
    });
}


//动态创建座位

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

//添加修改
function refresh(target) {
    var data = JSON.parse(target.getAttribute('pos'));//获取行列对象
    var data_content = `${data.seatrow}排${data.seatcol}列`;//设置修改的元素内容
    var modify_seat = document.querySelector('#modify_seat');
    var all_modify_seat = document.querySelectorAll('#modify_seat div'); //获取所有修改的座位
    //遍历 存在则删除  不存在则添加
    var flag = 1;
    for (var i = 0; i < all_modify_seat.length; i++) {
        if (data_content === all_modify_seat[i].innerText) {
            modify_seat.removeChild(all_modify_seat[i]);
            flag = 0;
        }
    }

    //创建结点
    if(flag === 1){
        var new_seat = document.createElement('div'); //创建添加的座位结点
        new_seat.setAttribute('pos', JSON.stringify(data));
        new_seat.innerText = data_content;//设置座位内容
        modify_seat.appendChild(new_seat);
    }

}
//提交修改  发送请求
function modifySub_ok(){
    var all_modify_seat = document.querySelectorAll('#modify_seat div'); //获取所有修改的座位
    var modify_seat = [];
    for(var i =0;i<all_modify_seat.length;i++){
        modify_seat.push(all_modify_seat[i].getAttribute('pos'));
    }
   
    console.log(modify_seat);
    var data = {
    		"studioid":urlObj.studioid,
    		"modify_seat":modify_seat	
    		};
    console.log(data);
    $.ajax({
        type:'post',
        data :data,
        dataType: "json",
//        traditional: true,
        url:"http://ttms.time.com:8080/TTMS/SeatModify"+window.location.search,
        success:function (data) {
            if(data.flag === "1"){
                alert("修改成功");
                window.location.href ='http://ttms.time.com:8080/TTMS/admin/pages/seat.jsp'+window.location.search;
            }
        }
    })
}

window.onload = function (ev){
    resolveUrl();
    get_seat();
};
