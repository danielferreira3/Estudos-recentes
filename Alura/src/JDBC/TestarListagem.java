package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestarListagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = DataBase.GetConnection();
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("SELECT * FROM funcionarios");
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			String nome = resultSet.getString("nome");
			System.out.println("ID " + id);
			System.out.println("Nome: " + nome);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
}
