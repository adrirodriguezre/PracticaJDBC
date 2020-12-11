package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Asignatura;
import Entidades.Ciclo;
import Entidades.ICicloDAO;

public class CicloDAO implements ICicloDAO{

	@Override
	public void insertarCiclo(Ciclo ciclo) {
		// TODO Auto-generated method stub
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		Ciclo cic = ciclo;
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("INSERT INTO CICLO VALUES ((?), (?), (?));");
			ps.setInt(1, cic.getIdCiclo());
			ps.setString(2, cic.getNombreCiclo());
			ps.setString(3, cic.getGrado());
			ps.execute();
			
			
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
	public void modificarCiclo(Ciclo ciclo) {
		// TODO Auto-generated method stub
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		Ciclo cic = ciclo;
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("UPDATE CICLO SET NOMBRECICLO = ?, GRADO = ? WHERE ID = ?");
			ps.setString(1, cic.getNombreCiclo());
			ps.setString(2, cic.getGrado());
			ps.setInt(3, cic.getIdCiclo());
			ps.execute();
			
			
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
	public void eliminarCiclo(Ciclo ciclo) {
		// TODO Auto-generated method stub
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		Ciclo cic = ciclo;
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("DELETE FROM CICLO WHERE ID = ?");
			ps.setInt(1, cic.getIdCiclo());
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
	public void crearCiclo(Ciclo ciclo, ArrayList <Asignatura> arrayAsignatura) {
		// TODO Auto-generated method stub
		
	}

}
