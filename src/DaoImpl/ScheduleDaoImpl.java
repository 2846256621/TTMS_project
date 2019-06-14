package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Dao.ScheduleDao;
import Util.JDBCUtil;
import domain.Play;
import domain.Schedule;
import domain.Studio;

public class ScheduleDaoImpl implements ScheduleDao {

	//根据剧目名称查询剧目id
	@Override
	public int findPlayID(String playname) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Play play=queryRunner.query("select * from play where playname=?", new BeanHandler<Play>(Play.class),playname);
		if(play == null ) {
			return 0;
		}
		return play.getPlayid();
	}

	//根据剧目id查询剧目的演出计划
	@Override
	public List<Schedule> findAll(int playid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		List<Schedule> list=queryRunner.query("select * from schedule where playid=?", new BeanListHandler<Schedule>(Schedule.class),playid);
		return list;
	}

	//根据studioid查询studioname
	@Override
	public String findStudioName(int studioid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Studio studio=queryRunner.query("select * from studio where studioid = ?", new BeanHandler<Studio>(Studio.class),studioid);
		if(studio==null)
		{
			return "0";
		}
		return studio.getStudioname();
	}

	//studioname查询studioid
	@Override
	public int findStudioID(String studioname) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Studio studio=queryRunner.query("select * from studio where studioname = ?", new BeanHandler<Studio>(Studio.class),studioname);
		if(studio == null)
		{
			return 0;
		}
		return studio.getStudioid();
	}

	//增加演出计划
	@Override
	public void insert(Schedule schedule) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("insert into schedule values(null,?,?,?,?,?)",
				schedule.getDate(),
				schedule.getStudioid(),
				schedule.getPrice(),
				schedule.getPlayid(),
				schedule.getBegintime()
			);
		
	}

	//删除演出计划
	@Override
	public void delete(int scheduleid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("delete from schedule where scheduleid=?",scheduleid);
		
	}

	//修改演出计划
	@Override
	public void update(Schedule schedule) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("update schedule set date=?,studioid=?,price=?,playid=?,begintime=? where scheduleid=?",
				schedule.getDate(),
				schedule.getStudioid(),
				schedule.getPrice(),
				schedule.getPlayid(),
				schedule.getBegintime(),
				schedule.getScheduleid()
				
	);
		
		
		
		
		
		
	}

}
