package es.open4job.ProyectoServicioTaxi.opendata;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.ProyectoServicioTaxi.opendata.model.dao.EstacionServicioDAO;
import es.open4job.ProyectoServicioTaxi.opendata.model.dao.ParadaTaxiDAO;
import es.open4job.ProyectoServicioTaxi.opendata.model.dao.BaseDatosDAO;
import es.open4job.ProyectoServicioTaxi.opendata.model.vo.EstacionServicio;
import es.open4job.ProyectoServicioTaxi.opendata.model.vo.ParadaTaxi;

public class App {

	public static final Logger logger = Logger.getLogger(ParadaTaxiDAO.class
			.getName());

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";
		String user = "test";
		String password = "test";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;

		BaseDatosDAO bbdd = new BaseDatosDAO(driver, url, user, password);
		int id = 3;

		
		try {
			
			Connection conexion = bbdd.abrirConexion();
			
			
			ParadaTaxiDAO paradaTaxi = new ParadaTaxiDAO();
			List<ParadaTaxi> paradasTaxi = paradaTaxi.getListadoParadaTaxi(conexion);
			
			// Prueba que valida la lista de paradas de taxis
			Iterator iterator = paradasTaxi.iterator();
			
			while (iterator.hasNext()) {
				
				System.out.println(iterator.next().toString());
				
			}
			
			paradaTaxi.getparadataxi(id, conexion);
			
			EstacionServicioDAO estacionServicio = new EstacionServicioDAO();
			List<EstacionServicio> estacionesServicio = estacionServicio.getlistaServicio(conexion);
			estacionServicio.getEstacionServicio(id, conexion);
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		
		bbdd.cerrarConexion();

		/* Generar informes en PDF
		JasperReportGenerator jasperReport = new XXX();
		
		boolean estado = jasperReport.generate();
		*/
		
	}
}