package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Venda;

import java.sql.Connection;
import java.sql.Date;

public class VendasDAO {
	
	private int ultimaVenda;

	public void cadastrar(Connection con, Venda venda) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO venda (data, cod_cliente) values ( ?, ?)";

		try {
			// insert table vendas
			stmt = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
			stmt.setDate(1, new Date(venda.getDate().getTimeInMillis()));
			stmt.setInt(2, venda.getCliente().getCod_cliente());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				ultimaVenda = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getUltimaVenda() {
		return ultimaVenda;
	}

}
