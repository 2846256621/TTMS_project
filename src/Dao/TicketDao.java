package Dao;

import java.sql.SQLException;
import java.util.List;

import domain.Ticket;
import domain.User_Seat;
import net.sf.json.JSONObject;

public interface TicketDao {

	//存储订单
	long  insert(Ticket order) throws SQLException;
	
	//查询所有的订单      一个用户一个订单   
	List<Ticket> findAll(int userid) throws SQLException;
	
	//通过playid查playname
	String findPlayName(int playid) throws SQLException;
	
	//通过studioid查studioname
	String findStudioName(int studioid) throws SQLException;
	
	//通过scheduleid查 上映时间   开始时间    成为订单上的时间
	String findDate(int scheduleid) throws SQLException;
	String findBeginTime(int scheduleid) throws SQLException;
	
	//通过userid查询username
	String findUserName(int userid) throws SQLException;
	
	//根据utid在user_seat中查询一个用户的所有的seatid   然后找到所有的行号和列号
	String findSeatID(int utid) throws SQLException;
	
    //通过seatrow和seatcol找到seatid
	int  findSeatid(int row,int col,int studioid) throws SQLException;
	
	 //通过seatid找到seatrow和seatcol   放在jsonobject里
	JSONObject  findSeat(int seatid) throws SQLException;
	
	//关联表的插入数据
	int add(User_Seat us)  throws SQLException;
	
	//根据userid查找utid
	//int findUtid(int userid) throws SQLException;
	
	//根据orderid查找订单
	Ticket search(int orderid) throws SQLException;
	
	//根据utid在user_seat里找记录
	 String find(int utid) throws SQLException;
	 
	 //根据演出厅id和座位id修改座位状态
	 void update(int studioid,int seatid) throws SQLException;
	 
	 //根据utid删除对应的user_seat表的对应的记录
	 void deleteUtid(int utid) throws SQLException;
	 
	 //退订单
	 void deleteOrder(int orderid) throws SQLException;
	 
	 void modify(int studioid,int seatid) throws SQLException;
}
