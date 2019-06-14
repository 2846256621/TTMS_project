package ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import Dao.StudioDao;
import DaoImpl.StudioDaoImpl;
import Service.StudioService;
import domain.Studio;

public class StudioServiceImpl implements  StudioService {

	 //查询所有的演出厅
	@Override
	public List<Studio> findAll() throws SQLException {
		
		StudioDao dao=new StudioDaoImpl();
		return dao.findAll();
	}

	//模糊查询
	@Override
	public List<Studio> find(String name) throws SQLException {
		StudioDao dao=new StudioDaoImpl();
		return dao.find(name);
	}

	 //添加演出厅
	@Override
	public int  insert(Studio studio) throws SQLException {
		StudioDao dao=new StudioDaoImpl();
		 return dao.insert(studio);
		
		
	}

	 //删除演出厅
	@Override
	public  void  delete(int studioid) throws SQLException {
		StudioDao dao=new StudioDaoImpl();
		dao.delete(studioid);
		
	}

	//修改演出厅
	@Override
	public void  update(Studio studio) throws SQLException {
		StudioDao dao=new StudioDaoImpl();
		dao.update(studio);
	   
	}

	//查询一个演出厅
	@Override
	public Studio find(int studioid) throws SQLException {
		StudioDao dao=new StudioDaoImpl();
		return dao.find(studioid);
	}
	
	
	

		
	

}
