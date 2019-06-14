package Dao;

import java.sql.SQLException;
import java.util.List;

import domain.Schedule;
public interface ScheduleDao {
	
	//根据playname查询playid
	int  findPlayID(String playname) throws SQLException;
	
	//根据playid查询剧目的所有演出计划
	List<Schedule> findAll(int playid) throws SQLException;

	//根据studioid查询studioname
	String findStudioName(int studioid) throws SQLException;
	
	//根据studioname查询studioid
	int findStudioID(String studioname) throws SQLException;
	
	//添加演出计划
	void  insert (Schedule schedule) throws SQLException;
	
	//删除演出计划
	void delete(int scheduleid) throws SQLException;
	
	//修改演出计划
	void update(Schedule schedule) throws SQLException;
	
}
