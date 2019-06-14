package Service;

import java.sql.SQLException;
import java.util.List;

import domain.Ticket;
import domain.User_Seat;

public interface TicketService {
	
	
	//存储订单
	long  insert(Ticket order) throws SQLException;
	
	//查询所有的订单
	List<Ticket>  findAll(int userid) throws SQLException;
	
	//通过seatrow和seatcol找到seatid
	int findSeatid(int row,int col,int studidoid) throws SQLException;
	
	//关联表
	int  add(User_Seat us) throws SQLException;
	
	//根据userid查找utid
	//int findUtid(int userid) throws SQLException;
	
	//删除订单
	void delete(int orderid) throws SQLException;
  	
	 //根据演出厅id和座位id修改座位状态
	 void update(int studioid,int seatid) throws SQLException;

  
}
