package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Factory.ConnectionFactory;
import modelo.Caixa;
import modelo.Produto;
import modelo.Venda;
import to.ClienteTO;
import to.CaixaTO;
import to.ProdutoTO;

public class CaixaDAO {
	
	public void incluir(CaixaTO to) {
		String sqlInsert = "INSERT INTO caixa(quantidade, cod_venda, cod_produto,) VALUES (?, ?, ?,)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getQuantidade());
			stm.setInt(2, to.getVenda().getCodVenda());
			stm.setInt(3, to.getProduto().getCod_produto());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
		
	





/*public void cadastrar(Connection con, Caixa caixa, Venda venda, ProdutoTO produto) throws SQLException {
	PreparedStatement stmt = null;
	String sql = "INSERT INTO caixa (quantidade, cod_venda, cod_produto) values (?, ?, ?)";
	
	try {
		// Salva caixa (itens venda)
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, caixa.getQuantidade());
		stmt.setInt(2, caixa.getVenda().getCodVenda());
		stmt.setInt(3, caixa.getProduto().getCod_produto());
		stmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		con.rollback();
	}
}*/




