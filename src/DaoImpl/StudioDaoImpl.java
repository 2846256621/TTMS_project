package DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Dao.StudioDao;
import Util.JDBCUtil;
import domain.Studio;
import Util.TestUtil;

public class StudioDaoImpl implements StudioDao {

	//查询所有演出厅信息
	@Override
	public List<Studio> findAll()  throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		List<Studio> list=queryRunner.query("select * from studio", new BeanListHandler<Studio>(Studio.class));
		
		return list;
	}

	 //模糊查询  根据演出厅名称
	@Override
	public List<Studio> find(String name) throws SQLException {

		
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		
		String sql="select * from studio where studioname like '%"+name+"%'";
		List<Studio> list=queryRunner.query(sql, new BeanListHandler<Studio>(Studio.class));
		return list;
		
	}

	//添加演出厅
	@Override
	public int  insert(Studio studio) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Long studioid = (Long) queryRunner.insert("insert into studio(studioname,rowcount,colcount) values(?,?,?)", new ScalarHandler(),studio.getStudioname(),studio.getRowcount(),studio.getColcount());
		 return studioid.intValue();
	}
	
	//查询一个演出厅
	@Override
	public Studio find(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Studio studio=queryRunner.query("select * from studio", new BeanHandler<Studio>(Studio.class));
		return studio;
	}

	//删除演出厅
	@Override
	public void delete(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("delete from studio where studioid=?",studioid);
	}

	
	//修改演出厅
	@Override
	public void update(Studio studio) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("update studio set studioname=?,rowcount=?,colcount=? where studioid=?",
				studio.getStudioname(),
				studio.getRowcount(),
				studio.getColcount(),
				studio.getStudioid()
			);
		
	}



}
