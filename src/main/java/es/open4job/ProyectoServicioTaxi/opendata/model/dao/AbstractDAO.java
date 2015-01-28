package es.open4job.ProyectoServicioTaxi.opendata.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class AbstractDAO {
	private String driver;
	private String url;
	private String user;
	private String password;
	protected Connection connection = null;

	public AbstractDAO(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} EstacionServicio

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void abrirConexion() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void consultas(ParadaTaxiDAO taxiDao, EstacionServicioDAO servicioDao ) throws SQLException, ClassNotFoundException {
		this.abrirConexion();
		taxiDao.getparadataxi(id, conexion);
		this.cerrarConexion();
	}

	public void cerrarConexion() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
