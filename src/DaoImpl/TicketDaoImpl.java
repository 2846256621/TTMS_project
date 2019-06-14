package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Dao.TicketDao;
import Util.JDBCUtil;
import domain.Play;
import domain.Schedule;
import domain.Seat;
import domain.Studio;
import domain.Ticket;
import domain.User;
import domain.User_Seat;
import net.sf.json.JSONObject;

public class TicketDaoImpl implements TicketDao {

	//存储订单
	@Override
	public long insert(Ticket order) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		long orderid =  (Long) queryRunner.insert("insert into orders(playid,utid,userid,studioid,scheduleid,allprice,ordertime,order_status) values(?,?,?,?,?,?,?,?)",new ScalarHandler(),
				order.getPlayid(),
				order.getUtid(),
				order.getUserid(),
				order.getStudioid(),
				order.getScheduleid(),
				order.getAllprice(),
				order.getOrdertime(),
				order.getOrder_status()
				
			);
		
		return orderid;
		
	}

	//查询用户的订单   （一个用户几个座位几个订单)
	@Override
	public List<Ticket> findAll(int userid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		List<Ticket> list=queryRunner.query("select * from orders where userid=?", new BeanListHandler<Ticket>(Ticket.class),userid);
		return list;
	}

	
	//通过playid查playname
	@Override
	public String findPlayName(int playid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Play play=queryRunner.query("select * from play where playid=?",new BeanHandler<Play>(Play.class), playid);
		return play.getPlayname();
	}

	
	
	//通过studioid查studioname
	@Override
	public String findStudioName(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Studio studio=queryRunner.query("select * from studio where studioid=?", new BeanHandler<Studio>(Studio.class),studioid);
		return studio.getStudioname();
	}

	//通过scheduleid查  上映时间  开始时间 
	@Override
	public String findDate(int scheduleid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Schedule schedule=queryRunner.query("select * from schedule where scheduleid=?", new BeanHandler<Schedule>(Schedule.class),scheduleid);
		
		return schedule.getDate();
	}
	@Override
	public String findBeginTime(int scheduleid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Schedule schedule=queryRunner.query("select * from schedule where scheduleid=?", new BeanHandler<Schedule>(Schedule.class),scheduleid);
		
		return schedule.getBegintime() ;
	}
	
	
	//通过userid查询username
	public String findUserName(int userid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		User user=queryRunner.query("select * from user where userid=?", new BeanHandler<User>(User.class),userid);
	     return user.getUsername();
	}
	
    //根据userid在user_seat中查询一个用户的所有的seatid   然后找到所有的行号和列号  
	
	@Override
	public String  findSeatID(int utid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		User_Seat us=queryRunner.query("select * from user_seat where utid=?", new BeanHandler<User_Seat>(User_Seat.class),utid);
		
		
		if(us==null)
			return "0";
		return us.getSeatid();
	}
	
	

	
	//通过seatrow和seatcol找到seatid
	@Override
	public int findSeatid(int row, int col,int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Seat seat=queryRunner.query("select * from seat where seatrow=? and seatcol=? and studioid =?", new BeanHandler<Seat>(Seat.class),row,col,studioid);
		return seat.getSeatid();
	}

	
	//根据seatid和演出厅id找到seatrow和seatcol
	@Override
	public JSONObject  findSeat(int seatid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Seat  seat=queryRunner.query("select * from seat where seatid=?", new BeanHandler<Seat>(Seat.class),seatid);
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("seatrow", seat.getSeatrow());
		jsonobject.put("seatcol", seat.getSeatcol());
		
		//System.out.println(seat.getSeatrow()+" "+seat.getSeatcol());
		return jsonobject;
	}

	
	
	//关联表
	@Override
	public int  add(User_Seat us) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Long utid=(Long)queryRunner.insert("insert into user_seat(userid,seatid,studioid) values(?,?,?)",new ScalarHandler(),
				us.getUserid(),
				us.getSeatid(),
				us.getStudioid()
				);
		return utid.intValue();
		
	}

//	//根据userid查找utid
//	@Override
//	public int findUtid(int userid) throws SQLException {
//		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
//		User_Seat us=queryRunner.query("select * from user_seat where userid=?", new BeanHandler<User_Seat>(User_Seat.class),userid);
//		return us.getUtid();
//	}

	//根据orderid查询对应的订单
	@Override
	public Ticket search(int orderid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Ticket order=queryRunner.query("select * from orders where orderid=?", new BeanHandler<Ticket>(Ticket.class),orderid);
		return order;
	}

	//根据utid找到该记录里的seatid
	@Override
	public String find(int utid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		User_Seat us=queryRunner.query("select * from user_seat where utid=?", new BeanHandler<User_Seat>(User_Seat.class),utid);
		return us.getSeatid();
	}

	
	//根据演出厅id和座位id修改座位状态  状态2为不可选
	@Override
	public void update(int studioid, int seatid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("update seat set  seatstatus=? where studioid=? and seatid=?",2,studioid,seatid);
	}
	
	//根据演出厅id和座位id修改座位状态  状态1为可选
		@Override
		public void modify(int studioid, int seatid) throws SQLException {
			QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
			queryRunner.update("update seat set  seatstatus=? where studioid=? and seatid=?",1,studioid,seatid);
		}

	//根据utid删除关联表中的记录
	@Override
	public void deleteUtid(int utid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("delete from user_seat where utid=?",utid);
		
	}

	//根据orderid退订单
	@Override
	public void deleteOrder(int orderid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("delete from orders where orderid=?",orderid);
		
	}

	

	
	

	
	

}
