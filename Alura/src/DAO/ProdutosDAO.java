package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
	

	private final Connection connection;
	
	

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}
	
	

	public void salva(Produto mesa) throws SQLException {
		// 2-inserir Query
		String sql = "INSERT INTO produto ( nome, descricao) VALUES(?, ?);";
		// 3-Pegar statement
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			// 4- setando valores
			statement.setString(1, mesa.getNome());
			statement.setString(2, mesa.getDescricao());
			statement.execute();
			// 5- Pegar id gerado
			try (ResultSet result = statement.getGeneratedKeys()) {
				// 6- se ir para a linha pegar o id
				if (result.next()) { // ir para a linha que tem algum valor
					int id = result.getInt(1);
					mesa.setId(id);
				}
			}
		}
	}


 
	public List<Produto> lista() throws SQLException {
		// criar uma lista de produto
		List<Produto> produtos = new ArrayList<>();
		
		// prepara o banco e busca
		String sql = "SELECT * FROM  produto";		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.execute();
			//vai para cada linha de produto
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					//le os parametros
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");
					//cria o produto
					Produto produto = new Produto(nome, descricao);
					produto.setId(id);
					//adiciona na lista
					produtos.add(produto);
				}
			}
		}
		
		return produtos;
		
	}

}
