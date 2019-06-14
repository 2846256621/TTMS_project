package ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import Dao.PlayDao;
import DaoImpl.PlayDaoImpl;
import Service.PlayService;
import domain.Play;

public class PlayServiceImpl implements PlayService {

	//模糊查询
	@Override
	public List<Play> find(String name) throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		return dao.find(name);
	}

	//查询全部信息
	@Override
	public List<Play> findAll() throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		return dao.findAll();
	}

	//添加剧目
	@Override
	public int insert(Play play) throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		return dao.insert(play);
	}

	//删除剧目
	@Override
	public void delete(int playid) throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		dao.delete(playid);
		
	}

	//修改剧目
	@Override
	public void update(int playid, Play play) throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		dao.update(playid, play);
		
	}

	//查询一个剧目的所有信息
	@Override
	public Play search(int playid) throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		return dao.search(playid);
	}

	//根据playid查找playname
	@Override
	public String FindPlayName(int playid) throws SQLException {
		PlayDao dao=new PlayDaoImpl();
		return dao.FindPlayName(playid);
	}

}
