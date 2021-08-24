package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import JDBC.DataBase;

public class TestaDaoDeProdutos {
	public static void main(String[] args) throws SQLException {
		Produto mesa = new Produto("mesa de vidro", "mesa de vidro na cor preta");
		// 1-pegar conexao
		try (Connection connection = DataBase.GetConnection()) {
			ProdutosDAO dao = new ProdutosDAO(connection);
			dao.salva(mesa);
			
			List<Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println("Exixte o Produto" + produto);
			} 
		}
		
		
	}

	
}
