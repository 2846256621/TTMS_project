package ServiceImpl;

import java.sql.SQLException;
import java.util.List;


import Dao.TicketDao;
import DaoImpl.TicketDaoImpl;
import Service.TicketService;
import domain.Ticket;
import domain.User_Seat;

public class TicketServiceImpl implements TicketService {
   //存储订单
	@Override
	public long insert(Ticket order) throws SQLException {
		 TicketDao dao=new TicketDaoImpl();
		 return dao.insert(order);
		
	}

	//查询一个用户的订单    在业务逻辑层进行提取信息  用id提取名字
	@Override
	public List<Ticket> findAll(int userid) throws SQLException {
		 TicketDao dao=new TicketDaoImpl();
		 List<Ticket> order= dao.findAll(userid);           //在数据库中用userid找到所有的订单
		 return  order;
	}

	////通过seatrow和seatcol找到seatid
	@Override
	public int findSeatid(int row, int col,int studioid) throws SQLException {
		 TicketDao dao=new TicketDaoImpl();
		return dao.findSeatid(row, col,studioid);
	}

	//关联表的插入数据
	@Override
	public int  add(User_Seat us) throws SQLException {
		 TicketDao dao=new TicketDaoImpl();
		 return dao.add(us);
		
	}

	//根据userid查找utid
//	@Override
//	public int findUtid(int userid) throws SQLException {
//		 TicketDao dao=new TicketDaoImpl();
//		 return dao.findUtid(userid);
//	}



	//删除订单    一个订单对应user_sea表里一条数据
	@Override
	public void delete(int orderid) throws SQLException {
		TicketDao dao=new TicketDaoImpl();
		   //查询对应的订单
		Ticket order=dao.search(orderid);
		int utid=order.getUtid();               //order表和user_表里都有utid   根据order表的utid查user_seat表的记录

		int studioid=order.getStudioid();
		  //找到utid对应的seatid
		String seat=dao.find(utid);

		String[] arr=seat.split(",");
		for(int i=0;i<arr.length;i++)
		{
			//根据seatid和studioid修改座位状态
			int seatid=Integer.parseInt(arr[i]);                  //在字符串中找到不同的座位seatid
			dao.modify(studioid,seatid);

		}
		//删除user_seat表里的utid对应的记录
		dao.deleteUtid(utid);
		
		//删除orderid对应的order表里的数据
		dao.deleteOrder(orderid);
		
	}

	//修改座位状态
	@Override
	public void update(int studioid, int seatid) throws SQLException {
		TicketDao dao=new TicketDaoImpl();
		dao.update(studioid, seatid);
		
	}

	
	
	
}
