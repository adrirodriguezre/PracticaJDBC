package Datos;

import java.sql.Connection;

public interface IConexion {
	
	public Connection crearConexion();
	public void cerrarConexion(Connection c);
	public void cargarDriver();

}
