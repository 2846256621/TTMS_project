package Dao;

import java.sql.SQLException;
import java.util.List;

import domain.Seat;

public interface SeatDao {
    
	//根据演出厅查询演出厅内的座位行数和列数   在演出厅数据库中
	int  findRow(int studioid) throws SQLException;   
	int  findCol(int studioid) throws SQLException;
	
	//根据演出厅查询演出厅id查询所有的座位信息    在座位数据库中
	 List<Seat> findAll (int studioid) throws SQLException;
	 
	 //添加座位
	 void  add(Seat seat) throws SQLException;
	 
	//查询该演出厅的一个座位的状态
	int search(int studioid,int row,int col) throws SQLException;
	
	//修改座位状态
	void update(int studioid,int row,int col,int status) throws SQLException;
}
