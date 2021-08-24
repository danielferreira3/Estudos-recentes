package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {
	public static void main(String[] args) throws SQLException {
		Connection connection = DataBase.GetConnection();
		
		Statement stm = connection.createStatement();
		stm.execute("delete from funcionarios where id > 3");
		int cont = stm.getUpdateCount();
		System.out.println(cont);
	}
}
