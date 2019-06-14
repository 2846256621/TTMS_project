    $(function () {
        $.ajax({
            type:'get',
            url:'http://ttms.time.com:8080/TTMS/MovieOrder?userid='+window.sessionStorage.getItem('userid'),
            dataType:'json',
            success:function (data) {
                let order_con = $('.oder-con');
                console.log(data);
                for(let i=0;i<data.length;i++){
                    let con = $(`
                    <div class="con">
                    <span>姓名：${window.sessionStorage.getItem('username')}</span>
                    <span>电影：${data[i].playname}</span>
                    <span>放映厅：${data[i].studioname}</span>
                    <span>时间：${data[i].date}  ${data[i].begintime}</span>
                    <span class="saled_seat">座位:</span>
                    <span>下单时间：${data[i].ordertime}</span>
                    <span style="color:#f2133c;display: inline-block;font-size: 18px">已支付：${data[i].allprice}元</span>
                    <button id="return_ticket">退票</button>
                    </div>
                `);
                    order_con.append(con);
                    let saled_seat = document.getElementsByClassName("saled_seat");
                    for(let j=0;j<data[i].seat.length;j++){
                        console.log(data[i].seat[j]);
                        saled_seat[i].append(`  ${data[i].seat[j].seatrow}排${data[i].seat[j].seatcol}列  `);
                    }

                    con.on('click','#return_ticket',function () {
                  
                    	if(confirm("确定退票吗？")){
                    		 $.ajax({
                                 type:'get',
                                 data:{
                                     "orderid": data[i].orderid
                                 },
                                 url:`http://ttms.time.com:8080/TTMS/ReturnTicket`,
                                 success:function () {
                                     alert('退票成功');
                                     window.location.href = `http://ttms.time.com:8080/TTMS/user/pages/order.jsp?orderid=${data[i].orderid}`;
                                 }
                             })
                    	}
                       
                    })
                }



            }
        });

    })