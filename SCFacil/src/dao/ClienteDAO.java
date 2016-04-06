package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import modelo.Cliente;
import to.ClienteTO;

public class ClienteDAO {
	public void incluir(ClienteTO to) {
		String sqlInsert = "INSERT INTO cliente(nome, cpf, telefone, endereco, cep) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getCpf());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEndereco());
			stm.setString(5, to.getCep());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(ClienteTO to) {
		String sqlUpdate = "UPDATE cliente SET nome=?, cpf=?, telefone=?, endereco=?, cep=? WHERE cod_cliente=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getCpf());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEndereco());
			stm.setString(5, to.getCep());
			stm.setInt(6, to.getCod_cliente());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(ClienteTO to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCod_cliente());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClienteTO carregar(int cod_cliente) {
		ClienteTO to = new ClienteTO();
		String sqlSelect = "SELECT * FROM cliente WHERE cod_cliente = ?";
		// String sqlSelect = "SELECT nome, cpf, telefone, endereco, cep FROM
		// cliente WHERE cod_cliente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cod_cliente);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setTelefone(rs.getString("telefone"));
					to.setEndereco(rs.getString("endereco"));
					to.setCep(rs.getString("cep"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public List<ClienteTO> lista(){
			List<ClienteTO> clientes = new ArrayList<>();
			String sql = " SELECT * FROM cliente";
			
			//try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			try (Connection conn = ConnectionFactory. obtemConexao ();     
					PreparedStatement stm = conn.prepareStatement(sql);) {
				try(ResultSet rs = stm.executeQuery()) {
					ClienteTO to;

					while (rs.next()) {
						to = new ClienteTO();
						to.setCod_cliente(rs.getInt("cod_cliente"));
						to.setNome(rs.getString("nome"));
						to.setCpf(rs.getString("cpf"));
						to.setTelefone(rs.getString("telefone"));
						to.setEndereco(rs.getString("endereco"));
						to.setCep(rs.getString("cep"));
						clientes.add(to);
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			return clientes;
		
	}


	}

