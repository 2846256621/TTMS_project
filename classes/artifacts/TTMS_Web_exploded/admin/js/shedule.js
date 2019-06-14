//查询
function search(){
    $.ajax({
        type:'post',
        url:"http://ttms.time.com:8080/TTMS/ScheduleSearch",
        dataType:'json',
        data:{
            playname : document.getElementById("shedule_search").value
        },
        success:function (json) {
        	if(json.flag === '0'){
        		alert('无演出计划');
        	}
        	else{
        		 var theTable = document.getElementById("table");//table的id
                 var num = theTable.rows.length;
                 while (num > 1) {
                     theTable.deleteRow(num - 1);
                     num = theTable.rows.length;
                 }
                 for (var i = 0; i < json.data.length; i++) {
                     var rowCount = theTable.rows.length; //获得当前表格的行数
                     var row = theTable.insertRow(rowCount);//在tale里动态的增加tr
                     row.insertCell(0).innerHTML = json.data[i].scheduleid;
                     row.insertCell(1).innerHTML = json.data[i].playname;
                     row.insertCell(2).innerHTML = json.data[i].date;
                     row.insertCell(3).innerHTML = json.data[i].studioname;
                     row.insertCell(4).innerHTML = json.data[i].price;
                     row.insertCell(5).innerHTML = json.data[i].begintime;
                     row.insertCell(6).innerHTML = '<span class="iconfont icon-xiugaiziliao" title="修改" onclick="addDetail(\'modify\')"></span>&nbsp;&nbsp;<span class="iconfont icon-shanchu" title="删除" onclick="del(' + json.data[i].scheduleid + ')" ></span>';
                 }
        	}
           
        }
    });
}

//删除  发送id
function del(scheduleid){

    if(confirm("确定删除？")) {
        $.ajax({
            url:"http://ttms.time.com:8080/TTMS/ScheduleDelete",
            type:"post",
            dataType:'json',
            data:{
                scheduleid:scheduleid
            },
            success:function (data) {
                if(data.flag === "1")
                    search();
                // alert('删除成功');
                else
                    alert("数据删除失败，请重试");
            }
        });

    }

}


//初始化  查询
function init(){
    search();

}

//更新演出厅
function check(type) {
    var form = document.getElementById("myform");
    if(form.shedule_name.value==="" || form.shedule_date.value==="" || form.shedule_price.value==="" || form.shedule_name.value===""){
        alert("请填写完整信息");
        return;
    }
    if(isNaN(form.shedule_price.value)){
        alert("座位行数和座位列数不是数字");
        return;
    }
    var url ='';
    if(type === 'add'){
        url = "http://ttms.time.com:8080/TTMS/ScheduleAdd";
    }
    else if(type === 'modify'){
        url = "http://ttms.time.com:8080/TTMS/ScheduleModify";
    }
    $.ajax({
        type:'post',
        url:url,
        dataType:'json',
        data:{
            scheduleid : form.shedule_id.value,
            playname : form.shedule_name.value,
            date :form.shedule_date.value,
            studioname : form.shedule_studio.value,
            price : form.shedule_price.value,
            begintime:form.shedule_begintime.value
        },
        success:function (data) {
            if(data.flag === "1"){
                var addDiv = document.getElementById("addDiv");
                var bgDiv = document.getElementById("bgDiv");
                bgDiv.style.display = addDiv.style.display = "none";
                window.location.href = 'http://ttms.time.com:8080/TTMS/admin/pages/schedule.jsp';
            }
        }
    });

}

//弹出框 增加
function addDetail(type){
    var addDiv = document.getElementById("addDiv");
    addDiv.style.marginTop = -75 + document.documentElement.scrollTop + "px";
    var bgDiv = document.getElementById("bgDiv");
    bgDiv.style.width = document.body.offsetwidth + "px";
    bgDiv.style.height = screen.height + "px";
    var addShut = document.getElementById("addShut");
    addShut.onclick = function(){
        bgDiv.style.display = addDiv.style.display = "none";
    };
    addDiv.style.display = bgDiv.style.display = "block";
    var curRowEle = event.target.parentElement.parentElement;
    document.getElementById("type").value = type;

    //区别不同的类型 弹出框不同
    changeType(type,curRowEle)

}

//根据类型  选择弹框
function changeType(type,curRowEle) {
    if(type==="modify"){
        var sub_btn = document.getElementById('sub_btn');
        sub_btn.outerHTML = '<button type=\"button\" class=\"btn btn-primary\" onclick=\"check(\'modify\')\" id=\"sub_btn\">提交</button>' ;
        var shedule_id = curRowEle.querySelector('tr td:nth-child(1)').innerHTML;
        var shedule_name = curRowEle.querySelector('tr td:nth-child(2)').innerHTML;
        var shedule_date = curRowEle.querySelector('tr td:nth-child(3)').innerHTML;
        var shedule_studio = curRowEle.querySelector('tr td:nth-child(4)').innerHTML;
        var shedule_price = curRowEle.querySelector('tr td:nth-child(5)').innerHTML;
        var shedule_begintime = curRowEle.querySelector('tr td:nth-child(6)').innerHTML;
        document.getElementById("shedule_id").value = shedule_id;
        document.getElementById("shedule_name").value = shedule_name;
        document.getElementById("shedule_date").value = shedule_date;
        document.getElementById("shedule_studio").value = shedule_studio;
        document.getElementById("shedule_price").value = shedule_price;
        document.getElementById("shedule_begintime").value = shedule_begintime;
    }
    else if(type ==='add'){
        var sub_btn2 = document.getElementById('sub_btn');
        sub_btn2.outerHTML = '<button type=\"button\" class=\"btn btn-primary\" onclick=\"check(\'add\')\" id="sub_btn">提交</button>' ;
        document.getElementById("shedule_id").value = "";
        document.getElementById("shedule_name").value = "";
        document.getElementById("shedule_date").value = "";
        document.getElementById("shedule_studio").value = "";
        document.getElementById("shedule_price").value = "";
        document.getElementById("shedule_begintime").value = "";
    }
}