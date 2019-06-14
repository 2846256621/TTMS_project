package Dao;

import java.sql.SQLException;

import domain.Manager;

public interface ManagerDao {
	
	Manager login() throws SQLException;

}
