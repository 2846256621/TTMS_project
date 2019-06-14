package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Dao.PlayDao;
import Util.JDBCUtil;
import domain.Play;

public class PlayDaoImpl implements PlayDao {

	//模糊查询
	@Override
	public List<Play> find(String name) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		String sql="select * from play  where playname like '%"+name+"%'";
		List<Play> list=queryRunner.query(sql, new BeanListHandler<Play>(Play.class));
		return list;
	}

	//查询全部
	@Override
	public List<Play> findAll() throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		List<Play> list=queryRunner.query("select * from play ", new BeanListHandler<Play>(Play.class));
		return list;
	}

	//增加剧目  要得到剧目id  ，根据剧目id添加演出计划
	@Override
	public int insert(Play play) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Long playid= (Long) queryRunner.insert("insert into play(playname,director,actor,playtype,country,language,duration,introduction,picture) values(?,?,?,?,?,?,?,?,?)", new ScalarHandler(),
				play.getPlayname(),
				play.getDirector(),
				play.getActor(),
				play.getPlaytype(),
				play.getCountry(),
				play.getLanguage(),
				play.getDuration(),
				play.getIntroduction(),
				"https://img.alicdn.com/bao/uploaded/i2/TB1gmvgh_dYBeNkSmLyXXXfnVXa_.jpg_160x240.jpg"
				);
		 return playid.intValue();
	}

	//删除剧目
	@Override
	public void delete(int playid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("delete from play where playid=?",playid);
		
	}

	//修改剧目
	@Override
	public void update(int playid,Play play) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		queryRunner.update("update play set playname=?,director=?,actor=?,playtype=?,country=?,language=?,duration=?,introduction=? where playid=?",
			play.getPlayname(),
			play.getDirector(),
			play.getActor(),
			play.getPlaytype(),
			play.getCountry(),
			play.getLanguage(),
			play.getDuration(),
			play.getIntroduction(),
			playid
		);
		
	}

	//查询一个剧目的所有信息
	@Override
	public Play search(int playid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Play play=queryRunner.query("select * from play where playid=?", new BeanHandler<Play>(Play.class),playid);
		return play;
	}
	
	
	//根据playid查找playname
	@Override
	public String FindPlayName(int playid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Play play=queryRunner.query("select * from play where playid=?", new BeanHandler<Play>(Play.class),playid);
		return play.getPlayname();

	}
	
	

	
	
	
	
	

}
