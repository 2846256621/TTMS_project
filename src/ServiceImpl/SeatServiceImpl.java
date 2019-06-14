package ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import Dao.SeatDao;
import DaoImpl.SeatDaoImpl;
import Service.SeatService;
import domain.Seat;

public class SeatServiceImpl implements SeatService{
  
	//查询该演出厅的所有座位
	@Override
	public List<Seat> findAll(int studioid) throws SQLException {
		SeatDao dao=new SeatDaoImpl();
		List<Seat> list=dao.findAll(studioid);
//		int[][] status=new int[dao.findRow(studioid)][dao.findCol(studioid)];
//		
//		for(Seat seat:list)
//		{
//			 int row=seat.getSeatrow();
//			 int col=seat.getSeatcol();
//			 status[row][col]=seat.getSeatstatus();
//		}
//		
//		return status;
		return list;
	}
	
	
	
	
	@Override
	public int findRow(int studioid) throws SQLException {
		  SeatDao dao=new SeatDaoImpl();
		return dao.findRow(studioid);
	}

	@Override
	public int findCol(int studioid) throws SQLException {
		  SeatDao dao=new SeatDaoImpl();
		  return dao.findCol(studioid);
	}


	//添加座位
	@Override
	public void add(Seat seat) throws SQLException {
		   SeatDao dao=new SeatDaoImpl();
		   dao.add(seat);
	}

	
	//查询该演出厅的一个座位的状态
	@Override
	public int search(int studioid, int row, int col) throws SQLException {
		SeatDao dao=new SeatDaoImpl();
		return dao.search(studioid, row, col);
	}

	
	//修改座位状态
	@Override
	public void update(int studioid, int row, int col, int status) throws SQLException {
		SeatDao dao=new SeatDaoImpl();
		dao.update(studioid, row, col, status);
		
	}

	
	
}
