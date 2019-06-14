package Service;

import java.sql.SQLException;

import domain.User;

public interface UserService {

	//用户注册   向数据库中建立用户
	void insert (String username,String password) throws SQLException ;

	//用户登录    如果存在该用户 则返回该用户的id
	int login(String username, String password) throws SQLException;
}
