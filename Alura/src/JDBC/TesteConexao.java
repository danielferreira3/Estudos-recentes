package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DataBase.GetConnection();
		System.out.println("conexão com o banco de dador com Sucesso!");
		connection.close();
	}

	
}

