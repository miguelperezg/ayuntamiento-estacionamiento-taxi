package es.open4job.ProyectoServicioTaxi.opendata.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import es.open4job.ProyectoServicioTaxi.opendata.model.vo.ParadaTaxi;

public class ParadaTaxiDAO {

	public ParadaTaxiDAO() {
	}

	// Listado de las paradas de taxi

	public ArrayList<ParadaTaxi> getListadoParadaTaxi(Connection conexion)
			throws SQLException {

		ArrayList<ParadaTaxi> lista = new ArrayList<ParadaTaxi>();

		PreparedStatement st = conexion.prepareStatement("SELECT * FROM PARADA_TAXI");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			lista.add(new ParadaTaxi(rs.getInt(1), rs.getString(2), rs
					.getDate(3), rs.getFloat(4), rs.getFloat(5), rs
					.getString(6)));
		}
		return lista;
	}

	// Devuelve la parada del taxi por el id

	public ParadaTaxi getparadataxi(int id, Connection conexion)
			throws SQLException {
		ParadaTaxi idLista = null;

		ResultSet rs = null;
		PreparedStatement stmt = null;

		stmt = conexion.prepareStatement("SELECT * FROM PARADA_TAXI WHERE id = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()) {
			idLista = new ParadaTaxi(rs.getInt(1), rs.getString(2),
					rs.getDate(3), rs.getFloat(4), rs.getFloat(5),
					rs.getString(6));
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
		return idLista;

	}

}
