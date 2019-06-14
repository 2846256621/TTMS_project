package Dao;

import java.sql.SQLException;
import java.util.List;

import domain.Studio;

public interface StudioDao {
	
	//查询所有的演出厅
	List<Studio> findAll()  throws SQLException;
	
	//模糊查询
	List<Studio> find(String name) throws SQLException;
	
	//添加演出厅
    int  insert (Studio studio) throws SQLException;
	
	//查询一个演出厅
	Studio find(int studioid) throws SQLException;
	
    //删除演出厅
	void delete (int studioid) throws SQLException;
	
	//修改演出厅
	void update(Studio studio) throws SQLException;
}
