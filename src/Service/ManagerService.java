package Service;

import java.sql.SQLException;

import domain.Manager;

public interface ManagerService {

	Manager login() throws SQLException;
}
