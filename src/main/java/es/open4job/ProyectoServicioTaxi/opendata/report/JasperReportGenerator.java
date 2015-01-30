package es.open4job.ProyectoServicioTaxi.opendata.report;

import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportGenerator {
/*
	public boolean generate(List<XXXXVO> xxxx) {
		/*
		boolean estado = false;
		
		// Cojo el jrxml usando la conexión a la base de datos
		// o usando los VO
		// ...
		
		// Lo proceso y lo meto en /var/www/html
		// ...
		
		return estado;
		*/
		// TODO Auto-generated method stub
	    // Cargamos el driver JDBC
	/*    
		try {
	      Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch (ClassNotFoundException e) {
	      System.out.println("MySQL JDBC Driver not found.");
	      System.exit(1);
	    }
	    //Para iniciar el Logger.
	    //inicializaLogger();
	    try {
	      conn = DriverManager.getConnection("jdbc:mysql://localhost/open4job","root", "open4job");
	      conn.setAutoCommit(false);
	    }
	    catch (SQLException e) {
	      System.out.println("Error de conexión: " + e.getMessage());
	      System.exit(4);
	    }
	 
	    try {
	      JasperReport report = JasperCompileManager.compileReport(
	          "/home/open4job/report2.jrxml");
	      JasperPrint print = JasperFillManager.fillReport(report, null, conn);
	      // Exporta el informe a PDF
	      JasperExportManager.exportReportToPdfFile(print,
	          "/home/open4job/InformeCallesMySQL.pdf");
	      //Para visualizar el pdf directamente desde java
	      JasperViewer.viewReport(print, false);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    finally {
	      /*
	       * Cleanup antes de salir
	       */
	    /*  try {
	        if (conn != null) {
	          conn.rollback();
	          System.out.println("ROLLBACK EJECUTADO");
	          conn.close();
	        }
	      }
	      catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	 
	  }
	}*/
	
}
