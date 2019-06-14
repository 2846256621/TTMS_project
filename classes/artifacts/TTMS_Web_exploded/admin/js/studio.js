//查询
function search(){
    $.ajax({
        type:'post',
        url:"http://ttms.time.com:8080/TTMS/StudioSearch",
        dataType:'json',
        data:{
            studioname:document.getElementById("studio_name").value
        },
        success:function (json) {
            if(json.flag === '0'){
                alert("无该演出厅")
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
                    row.insertCell(0).innerHTML = json.data[i].studioid;
                    row.insertCell(1).innerHTML = json.data[i].studioname;
                    row.insertCell(2).innerHTML = json.data[i].rowcount;
                    row.insertCell(3).innerHTML = json.data[i].colcount;
                    row.insertCell(4).innerHTML =
                        '<span  class="iconfont icon-xiugaiziliao" title="修改" onclick="addDetail(\'modify\')"></span>&nbsp;&nbsp;' +
                        '<span class="iconfont icon-shanchu" title="删除" onclick="del(' + json.data[i].studioid + ')"></span>&nbsp;&nbsp;' +
                        `<a href="http://ttms.time.com:8080/TTMS/admin/pages/seat.jsp?studioid=${json.data[i].studioid}" style="color:white"><span title="座位管理" class="iconfont icon-zuowei"></span></a>`;
                }
            }

        }
    });

}








//删除  发送id
function del(studioid){
  
    if(confirm("确定删除？")) {
        $.ajax({
            url:"http://ttms.time.com:8080/TTMS/StudioDelete",
            type:"post",
            dataType:'json',
            data:{
            	studioid:studioid
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


function init(){
    search();

}

//更新演出厅
function check(type) {
    var form = document.getElementById("myform");
    if(form.studioname.value==="" || form.rowcount.value==="" || form.colcount.value===""){
        alert("请填写完整信息");
        return;
    }
    if(isNaN(form.rowcount.value) || isNaN(form.colcount.value)){
        alert("座位行数和座位列数不是数字");
        return;
    }
    var url ='';
    if(type === 'add'){
         url = "http://ttms.time.com:8080/TTMS/StudioAdd";
    }
    else if(type === 'modify'){
        url = "http://ttms.time.com:8080/TTMS/StudioModify";
    }
    $.ajax({
    	type:'post',
    	url:url,
    	dataType:'json',
    	data:{
    		studioid : form.studioid.value,
            studioname : form.studioname.value,
            rowcount :form.rowcount.value,
            colcount : form.colcount.value
    	},
    	success:function(data){
    		if(data.flag === "1"){

        		var addDiv = document.getElementById("addDiv");
                var bgDiv = document.getElementById("bgDiv");
                bgDiv.style.display = addDiv.style.display = "none";
                window.location.href = 'http://ttms.time.com:8080/TTMS/admin/pages/studio.jsp';
    		}
    	
    	},
    	error:function(){
    		console.log("error");
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
    //根据类型  选择弹框
    changeType(type,curRowEle);
}

//根据类型  选择弹框
function changeType(type,curRowEle) {
    if(type==="modify"){
        var sub_btn = document.getElementById('sub_btn');
        sub_btn.outerHTML = '<button type=\"button\" class=\"btn btn-primary\" onclick=\"check(\'modify\')\" id=\"sub_btn\">提交</button>' ;
        var studioid = curRowEle.querySelector('tr td:nth-child(1)').innerHTML;
        var studioname = curRowEle.querySelector('tr td:nth-child(2)').innerHTML;
        var rowcount = curRowEle.querySelector('tr td:nth-child(3)').innerHTML;
        var colcount = curRowEle.querySelector('tr td:nth-child(4)').innerHTML;
        document.getElementById("studioid").value = studioid;
        document.getElementById("studioname").value = studioname;
        document.getElementById("rowcount").value = rowcount;
        document.getElementById("colcount").value = colcount;
    }
    else if(type ==='add'){
        var sub_btn2 = document.getElementById('sub_btn');
        sub_btn2.outerHTML = '<button type=\"button\" class=\"btn btn-primary\" onclick=\"check(\'add\')\" id="sub_btn">提交</button>' ;
        document.getElementById("studioid").value = "";
        document.getElementById("studioname").value = "";
        document.getElementById("rowcount").value = "";
        document.getElementById("colcount").value = "";
    }
}
