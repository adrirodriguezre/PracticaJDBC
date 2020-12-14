package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Entidades.Asignatura;
import Entidades.IAsignaturaDAO;

public class AsignaturaDAO implements IAsignaturaDAO{

	@Override
	public void insertarAsig(Asignatura asignatura) {
		// TODO Auto-generated method stub
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		Asignatura asig = asignatura;
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("INSERT INTO ASIGNATURA (nombre, horasSemanales, id_ciclo)  VALUES (?,?,?);");
			ps.setString(1, asig.getNombreAsig());
			ps.setInt(2, asig.getHorasSem());
			ps.setInt(3, asig.getIdCiclo());
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps != null) {
				
				try {
					ps.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void modificarAsig(Asignatura asignatura) {
		// TODO Auto-generated method stub
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		Asignatura asig = asignatura;
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("UPDATE ASIGNATURA SET NOMBRE = ?, HORASSEMANALES = ? WHERE ID = ?");
			ps.setString(1, asig.getNombreAsig());
			ps.setInt(2, asig.getHorasSem());
			ps.setInt(3, asig.getIdAsig());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			
		}
		finally {
			
			if(ps != null) {
				
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}

	@Override
	public void eliminarAsig(Asignatura asignatura) {
		// TODO Auto-generated method stub
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		Asignatura asig = asignatura;
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("DELETE FROM ASIGNATURA WHERE ID = ?");
			ps.setInt(1, asig.getIdAsig());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			
		}
		finally {
			
			if(ps != null) {
				
				try {
					ps.close();
					
				}catch(SQLException e) {
					
				}
			}
		}
	}


}
