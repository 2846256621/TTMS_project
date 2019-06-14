package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Dao.SeatDao;
import Util.JDBCUtil;
import domain.Seat;
import domain.Studio;

public class SeatDaoImpl implements SeatDao{

	//在演出厅数据库中查询该演出厅的行数
	@Override
	public int findRow(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Studio studio=queryRunner.query("select * from studio where studioid=?", new BeanHandler<Studio>(Studio.class),studioid);
		int rowcount=studio.getRowcount();
		return rowcount;
	}
  
	//在演出厅数据库中查询该演出厅的列数
	@Override
	public int findCol(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Studio studio=queryRunner.query("select * from studio where studioid=?", new BeanHandler<Studio>(Studio.class),studioid);
		int rowcount=studio.getColcount();
		return rowcount;
	}

	//在座位数据库中查询对应的演出厅的所有座位信息
	@Override
	public List<Seat> findAll(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		List<Seat> list=queryRunner.query("select * from seat where studioid=?", new BeanListHandler<Seat>(Seat.class),studioid);
		return list;
	}

	//增加座位
	@Override
	public void add(Seat seat) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("insert into seat(seatrow,seatcol,seatstatus,studioid) values(?,?,?,?)",
		seat.getSeatrow(),
		seat.getSeatcol(),
		seat.getSeatstatus(),
		seat.getStudioid()
		);
		
	}

	//查询一个演出厅里的座位状态
	@Override
	public int search(int studioid, int row, int col) throws SQLException {
	   QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
	   Seat seat=queryRunner.query("select * from seat where studioid=? and seatrow=? and seatcol=?",new BeanHandler<Seat>(Seat.class),studioid,row,col);
	   return seat.getSeatstatus();
	}

	//修改座位状态
	@Override
	public void update(int studioid, int row, int col,int status) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("update seat set seatstatus=? where studioid=? and seatrow=? and seatcol=?",status,studioid,row,col);
		
	}
		

}
