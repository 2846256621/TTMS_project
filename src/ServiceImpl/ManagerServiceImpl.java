package ServiceImpl;

import java.sql.SQLException;

import Dao.ManagerDao;
import DaoImpl.ManagerDaoImpl;
import Service.ManagerService;
import domain.Manager;

public class ManagerServiceImpl implements ManagerService {

	@Override
	public Manager login() throws SQLException {
		
		ManagerDao dao=new ManagerDaoImpl();
		return dao.login();
	}


}
