package ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import Dao.ScheduleDao;
import DaoImpl.ScheduleDaoImpl;
import Service.ScheduleService;
import domain.Schedule;

public class ScheduleServiceImpl implements ScheduleService {

	//根据剧目名称查询剧目id
	@Override
	public int findPlayID(String playname) throws SQLException {
		 ScheduleDao dao=new ScheduleDaoImpl();
		 
		return  dao.findPlayID(playname);
	}

	//根据playid查询剧目的所有演出计划
	@Override
	public List<Schedule> findAll(int playid) throws SQLException {
		 ScheduleDao dao=new ScheduleDaoImpl();
		return dao.findAll(playid);
	}

	//根据studioid插叙studioname
	@Override
	public String findStudioName(int studioid) throws SQLException {
		 ScheduleDao dao=new ScheduleDaoImpl();
		return dao.findStudioName(studioid);
	}

	//根据studioname查询studioid
	@Override
	public int findStudioID(String studioname) throws SQLException {
		 ScheduleDao dao=new ScheduleDaoImpl();
		return dao.findStudioID(studioname);
	}

	//添加剧目
	@Override
	public void insert(Schedule schedule) throws SQLException {
		 ScheduleDao dao=new ScheduleDaoImpl();
		 dao.insert(schedule);
		
	}

	//删除剧目
	@Override
	public void delete(int scheduleid) throws SQLException {
		 ScheduleDao dao=new ScheduleDaoImpl();
		 dao.delete(scheduleid);
		
	}

	@Override
	public void update(Schedule schedule) throws SQLException {
		ScheduleDao dao=new ScheduleDaoImpl();
		dao.update(schedule);
	}

}
