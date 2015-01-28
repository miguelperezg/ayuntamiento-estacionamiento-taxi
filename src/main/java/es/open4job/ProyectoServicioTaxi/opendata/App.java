package es.open4job.ProyectoServicioTaxi.opendata;

import java.sql.SQLException;


import es.open4job.ProyectoServicioTaxi.opendata.model.dao.EstacionServicioDAO;
import es.open4job.ProyectoServicioTaxi.opendata.model.dao.ParadaTaxiDAO;



public class App {
	
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";
		String user = "open4job";
		String password = "open4job";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;
		
		ParadaTaxiDAO  = new ParadaTaxiDAO(driver,
				url, user, password);
		
		EstacionServicioDAO  = new EstacionServicioDAO(
				driver, url, user, password);
		
	}
}