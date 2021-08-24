package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	 public static Connection GetConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/teste?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC", "root", "123456789");
		return connection;
	}
}
