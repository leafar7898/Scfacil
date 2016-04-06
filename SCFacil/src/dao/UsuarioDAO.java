package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import modelo.Usuario;

public class UsuarioDAO {
	private Connection conn;

	public UsuarioDAO() throws SQLException {
		conn = ConnectionFactory.obtemConexao();
	}

	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO usuarios(nome, senha, administrador) VALUES (?,?,?)";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSenha());
			stm.setBoolean(3, usuario.isAdministrador());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuario(String nome, String senha) {
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios where nome = ? and senha = ?";

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, nome);
			stm.setString(2, senha);
			// executa a consulta sql
			rs = stm.executeQuery();

			while (rs.next()) {
				String nomeBanco = rs.getString("nome");
				String senhaBanco = rs.getString("senha");

				// retorna usuario se a senha e login for igual ao banco de
				// dados
				if (nomeBanco.equals(nome) && senhaBanco.equals(senha)) {
					usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
					usuario.setAdministrador(rs.getBoolean("administrador"));
					return usuario;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);

			// executa a consulta sql
			rs = stmt.executeQuery();

			Usuario usuario;

			while (rs.next()) {
				// cria um objeto usuario com id, nome e admin
				usuario = new Usuario();
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setAdministrador(rs.getBoolean("administrador"));

				// adiciona usuario na lista
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void deletar(Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE codigo = ? ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodigo());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
