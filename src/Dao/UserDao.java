package Dao;

import java.sql.SQLException;

import domain.User;

public interface UserDao {
	
	//用户注册   向数据库中建立用户,判断该用户是否注册成功
	void insert (String username,String password) throws SQLException ;
	
	
	//用户登录  在数据库中进行查询
	 User  login(String username,String password) throws SQLException;

}
