package es.open4job.ProyectoServicioTaxi.opendata;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.ProyectoServicioTaxi.opendata.model.dao.EstacionServicioDAO;
import es.open4job.ProyectoServicioTaxi.opendata.model.dao.ParadaTaxiDAO;
import es.open4job.ProyectoServicioTaxi.opendata.model.dao.BaseDatosDAO;

public class App {

	public static final Logger logger = Logger.getLogger(ParadaTaxiDAO.class
			.getName());

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";
		String user = "open4job";
		String password = "open4job";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;

		BaseDatosDAO bbdd = new BaseDatosDAO(driver, url, user, password);
		int id = 3;
		try {
			Connection conexion = bbdd.abrirConexion();
			
			
			ParadaTaxiDAO paradaTaxi = new ParadaTaxiDAO();
			paradaTaxi.getListadoParadaTaxi(conexion);
			paradaTaxi.getparadataxi(id, conexion);
			
			EstacionServicioDAO estacionServicio = new EstacionServicioDAO();
			estacionServicio.getlistaServicio(conexion);
			estacionServicio.getEstacionServicio(id, conexion);
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		bbdd.cerrarConexion();

	}
}