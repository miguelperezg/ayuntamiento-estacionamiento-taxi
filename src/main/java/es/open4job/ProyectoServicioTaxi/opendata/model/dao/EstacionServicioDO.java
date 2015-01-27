package es.open4job.ProyectoServicioTaxi.opendata.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.open4job.ProyectoServicioTaxi.opendata.model.vo.EstacionServicio;

public class EstacionServicioDO {

	// Listado de la estacion de servicio
	
		public ArrayList<EstacionServicio> getlistataxi(Connection conexion) throws SQLException {
		
			ArrayList<EstacionServicio> lista = new ArrayList<EstacionServicio>();
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				lista.add(new EstacionServicio(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6)));
			}
			
		return lista;
		}
		
		//Devuelve la la estacion de servicio por el id
		
		public  EstacionServicio getEstacionServicio(int id, Connection conexion) throws SQLException {
			
			EstacionServicio idLista = null;
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO WHERE id = this.id");
			ResultSet rs = st.executeQuery();
			idLista = new EstacionServicio(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6));
			
		return idLista;
		
		}
}
