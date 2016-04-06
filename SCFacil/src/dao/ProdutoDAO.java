package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import modelo.Produto;
import to.ProdutoTO;

public class ProdutoDAO {
	
		public void incluir(ProdutoTO to) {
			String sqlInsert = "INSERT INTO produto(nome, quantidade, valor_custo, valor_venda) VALUES (?, ?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, to.getNome());
				stm.setInt(2, to.getQuantidade());
				stm.setDouble(3, to.getValorCusto());
				stm.setDouble(4, to.getValorVenda());
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void atualizar(ProdutoTO to) {
			String sqlUpdate = "UPDATE produto SET nome=?, quantidade=?, valor_custo=?, valor_venda=? WHERE cod_produto=?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, to.getNome());
				stm.setInt(2, to.getQuantidade());
				stm.setDouble(3, to.getValorCusto());
				stm.setDouble(4, to.getValorVenda());
				stm.setInt(6, to.getCod_produto());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void excluir(ProdutoTO to) {
			String sqlDelete = "DELETE FROM produto WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, to.getCod_produto());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public ProdutoTO carregar(int cod_produto) {
			ProdutoTO to = new ProdutoTO();
			String sqlSelect = "SELECT * FROM produto WHERE cod_produto = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, cod_produto);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						to.setNome(rs.getString("nome"));
						to.setQuantidade(rs.getInt("quantidade"));
						to.setValorCusto(rs.getDouble("valor_custo"));
						to.setValorVenda(rs.getDouble("valor_venda"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return to;
		}

		public List<ProdutoTO> lista(){
				List<ProdutoTO> produtos = new ArrayList<>();
				String sql = " SELECT * FROM produto";
				
				//try(PreparedStatement stmt = conn.prepareStatement(sql)) {
				try (Connection conn = ConnectionFactory. obtemConexao ();     
						PreparedStatement stm = conn.prepareStatement(sql);) {
					try(ResultSet rs = stm.executeQuery()) {
						ProdutoTO to;

						while (rs.next()) {
							to = new ProdutoTO();
							to.setCod_produto(rs.getInt("cod_produto"));
							to.setNome(rs.getString("nome"));
							to.setQuantidade(rs.getInt("quantidade"));
							to.setValorCusto(rs.getDouble("valor_custo"));
							to.setValorVenda(rs.getDouble("valor_venda"));
							produtos.add(to);
						}
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
				return produtos;
			
		}
}
