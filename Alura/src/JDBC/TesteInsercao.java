package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TesteInsercao {
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		
		try(Connection connection = DataBase.GetConnection()){
			//System.out.print("Digite o seu nome: ");
			//String nome = input.next();
			//String sobre = "ferreira";
			connection.setAutoCommit(false); //padrão do JDBC (ou seja do Driver) para lidar com transações e o banco de dados
			String sql = "INSERT INTO funcionarios (nome) VALUES(?);";
			
		 
			try(PreparedStatement statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS)) {	
					adiciona( "mariana", statement);
					adiciona( "maria", statement);
					connection.commit();
					statement.close();
			} catch(Exception ex){
				ex.printStackTrace();// imprimir mensagem de erro
				connection.rollback(); // voltar atras nas modificações
			}
			
		}
		
	}

	private static void adiciona(String nome, PreparedStatement statement) throws SQLException {
		if(nome.equals("maria")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}
		statement.setString(1, nome);
		statement.execute();
		
		
		
		ResultSet resultSet = statement.getGeneratedKeys();
		while(resultSet.next()) {
			String id = resultSet.getString(1);
			System.out.println("ID Gerado " + id);
		}
		
		resultSet.close();
		
	}
}
