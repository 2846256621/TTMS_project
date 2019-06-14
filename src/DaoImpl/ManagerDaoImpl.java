package DaoImpl;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Dao.ManagerDao;
import Util.JDBCUtil;
import domain.Manager;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager login() throws SQLException {
		
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		Manager user=queryRunner.query("select * from manager", new BeanHandler<Manager>(Manager.class));
		
		return user;
	}

	
}
