
//查询
function search(){
     $.ajax({
         type:'post',
         url:"http://ttms.time.com:8080/TTMS/PlaySearch",
         dataType:'json',
         data:{
             playname:document.getElementById("play_name").value
         },
         success:function (data) {
        	 if(data.flag === '0'){
        	     alert("无该剧目!");
             }
             else{
                 var theTable = document.getElementById("table");//table的id
                 var num = theTable.rows.length;
                 while (num > 1) {
                     theTable.deleteRow(num - 1);
                     num = theTable.rows.length;
                 }
                 for (var i = 0; i < data.data.length; i++) {
                     var rowCount = theTable.rows.length; //获得当前表格的行数
                     var row = theTable.insertRow(rowCount);//在tale里动态的增加tr
                     row.insertCell(0).innerHTML = data.data[i].playid;
                     row.insertCell(1).innerHTML = data.data[i].playname;
                     row.insertCell(2).innerHTML = data.data[i].director;
                     row.insertCell(3).innerHTML = data.data[i].actor;
                     row.insertCell(4).innerHTML = data.data[i].playtype;
                     row.insertCell(5).innerHTML = data.data[i].language;
                     row.insertCell(6).innerHTML = data.data[i].duration;
                     row.insertCell(7).innerHTML = data.data[i].country;
                     row.insertCell(8).innerHTML = data.data[i].introduction;
                     row.insertCell(9).innerHTML = '<span class="iconfont icon-xiugaiziliao" title="修改" onclick="addDetail(\'modify\')"></span>  <span class="iconfont icon-shanchu" title="删除" onclick="del('+data.data[i].playid+')"></span> ';
                 }
             }

         }
     });
}

//删除
function del(playid){

    if(confirm("确定删除？")) {
        $.ajax({
            url:"http://ttms.time.com:8080/TTMS/PlayDelete",
            type:"post",
            dataType:'json',
            data:{
                playid:playid
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

//初始化 查询
function init(){
    search();

}

//更新演出厅
function check(type) {
    var form = document.getElementById("myform");
    if (form.type.value === "" || form.play_director.value === "" || form.play_intro.value === "" || form.play_names.value === "") {
        alert("请填写完整信息");
        return;
    }
    var url = '';
    if (type === 'add') {
        url = "http://ttms.time.com:8080/TTMS/PlayAdd";
    }
    else if (type === 'modify') {
        url = "http://ttms.time.com:8080/TTMS/PlayModify";
    }
    $.ajax({
        type: 'post',
        url: url,
        dataType:'json',
        data: {
            playid: form.play_id.value,
            playname: form.play_names.value,
            actor: form.play_actor.value,
            director: form.play_director.value,
            playtype: form.play_type.value,
            language: form.play_language.value,
            introduction: form.play_intro.value,
            duration:form.play_duration.value,
            country:form.play_country.value
        },
        success: function (data) {
            if (data.flag === "1") {
                var addDiv = document.getElementById("addDiv");
                var bgDiv = document.getElementById("bgDiv");
                bgDiv.style.display = addDiv.style.display = "none";
                window.location.href = 'http://ttms.time.com:8080/TTMS/admin/pages/play.jsp';
            }

        }
    });
}

//弹出框 增加
function addDetail(type){
    var  addDiv = document.getElementById("addDiv");
    addDiv.style.marginTop = -75 + document.documentElement.scrollTop + "px";
    var  bgDiv = document.getElementById("bgDiv");
    bgDiv.style.width = document.body.offsetwidth + "px";
    bgDiv.style.height = screen.height + "px";
    var  addShut = document.getElementById("addShut");
    addShut.onclick = function(){
        bgDiv.style.display = addDiv.style.display = "none";
    };
    addDiv.style.display = bgDiv.style.display = "block";
    var  curRowEle = event.target.parentElement.parentElement;
    document.getElementById("type").value = type;
    //区别添加与修改的弹出框
    changeType(type,curRowEle);

}

//分类型弹窗
function  changeType(type,curRowEle) {
    if(type==="modify"){
        var sub_btn = document.getElementById('sub_btn');
        sub_btn.outerHTML = '<button type=\"button\" class=\"btn btn-primary\" onclick=\"check(\'modify\')\" id=\"sub_btn\">提交</button>' ;
        var play_id = curRowEle.querySelector('tr td:nth-child(1)').innerHTML;
        var play_names = curRowEle.querySelector('tr td:nth-child(2)').innerHTML;
        var play_director = curRowEle.querySelector('tr td:nth-child(3)').innerHTML;
        var play_actor = curRowEle.querySelector('tr td:nth-child(4)').innerHTML;
        var play_type = curRowEle.querySelector('tr td:nth-child(5)').innerHTML;
        var play_language = curRowEle.querySelector('tr td:nth-child(6)').innerHTML;
        var play_duration = curRowEle.querySelector('tr td:nth-child(7)').innerHTML;
        var play_country = curRowEle.querySelector('tr td:nth-child(8)').innerHTML;
        var play_intro = curRowEle.querySelector('tr td:nth-child(9)').innerHTML;
        document.getElementById("play_id").value = play_id;
        document.getElementById("play_names").value = play_names;
        document.getElementById("play_director").value = play_director;
        document.getElementById("play_type").value = play_type;
        document.getElementById("play_actor").value = play_actor;
        document.getElementById("play_language").value = play_language;
        document.getElementById("play_duration").value = play_duration;
        document.getElementById("play_country").value = play_country;
        document.getElementById("play_intro").value = play_intro;
    }
    else if(type ==='add'){
        var sub_btn2 = document.getElementById('sub_btn');
        sub_btn2.outerHTML = '<button type=\"button\" class=\"btn btn-primary\" onclick=\"check(\'add\')\" id="sub_btn">提交</button>' ;
        document.getElementById("play_id").value = "";
        document.getElementById("play_names").value = "";
        document.getElementById("play_director").value = "";
        document.getElementById("play_actor").value = "";
        document.getElementById("play_type").value = "";
        document.getElementById("play_language").value = "";
        document.getElementById("play_duration").value = "";
        document.getElementById("play_country").value = "";
        document.getElementById("play_intro").value = "";
    }
}