package ServiceImpl;

import java.sql.SQLException;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Service.UserService;
import domain.User;

public class UserServiceImpl implements UserService {

	//用户注册
	@Override
	public void insert(String username, String password) throws SQLException {
		UserDao dao=new UserDaoImpl();
		dao.insert(username, password);
	}

	//用户登录   如果存在用户就返回用户的id
	@Override
	public int login(String username, String password) throws SQLException {
		UserDao dao=new UserDaoImpl();
		User user=dao.login(username, password);
		if(user!=null)
			 return user.getUserid();
		else
			return 0;               //不存在这个用户
			
	}

}
