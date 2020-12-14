package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements IConexion {

	@Override
	public Connection crearConexion() {
		
		String url = "jdbc:mysql://localhost:3306/aulanosa?useSSL=false";
		String usuario = "root";
		String pass = "";
		Connection c = null;
		try {
			c = (Connection) DriverManager.getConnection(url,usuario,pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de conexión");
		}
		
		
		return c;
	}

	@Override
	public void cargarDriver() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de conexión");
		}
	}

	@Override
	public void cerrarConexion(Connection c) {
		// TODO Auto-generated method stub
		try {
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de conexión");
		}
	}

}
