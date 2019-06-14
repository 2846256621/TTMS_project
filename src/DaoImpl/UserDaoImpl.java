package DaoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Dao.UserDao;
import Util.JDBCUtil;
import domain.User;

public class UserDaoImpl implements UserDao{

	//用户注册
	@Override
	public void insert(String username, String password) throws SQLException {
		  QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		  queryRunner.update("insert into user values(null,?,?)",username,password);
		
	}

	
	

	
	//用户登录(相当于一个小查询)
	@Override
	public User login(String username, String password) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
		User user=queryRunner.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),username,password);
		return user;
	}

	
	

}
