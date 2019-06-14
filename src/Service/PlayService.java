package Service;

import java.sql.SQLException;
import java.util.List;

import domain.Play;

public interface PlayService {

	    //剧目的模糊查询
		List<Play>  find(String name) throws SQLException;
		
		//查询全部剧目的所有信息
		List<Play> findAll() throws SQLException;
		
		//增加剧目
		int insert(Play play) throws SQLException;
		
		//删除剧目
		void  delete(int playid) throws SQLException;
		
		//修改剧目
		void update(int playid,Play play) throws SQLException;
		
		//查询一个剧目的所有信息
		Play search(int playid) throws SQLException;

		//根据playid查找playname
		  String FindPlayName(int playid) throws SQLException;
	}
