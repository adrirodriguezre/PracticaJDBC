package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			
			ps = c.prepareStatement("INSERT INTO CICLO VALUES ((?), (?), (?));",Statement.RETURN_GENERATED_KEYS );
			ps.setInt(1, cic.getIdCiclo());
			ps.setString(2, cic.getNombreCiclo());
			ps.setString(3, cic.getGrado());
			ps.execute();
			ResultSet rsIds=ps.getGeneratedKeys();
			if(rsIds.next()) {
				int id= rsIds.getInt(1);
				ciclo.setIdCiclo(id);
			}
			
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
			
			ps = c.prepareStatement("UPDATE CICLO SET NOMBRE = ?, GRADO = ? WHERE ID = ?");
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
		int idGenerada = 0;
		
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.crearConexion();
		con.cargarDriver();
		
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("INSERT INTO CICLO VALUES ((?), (?), (?));", Statement.RETURN_GENERATED_KEYS);
			ps.setString(2, ciclo.getNombreCiclo());
			ps.setString(3, ciclo.getGrado());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				
				idGenerada = rs.getInt(1);
				System.out.println(idGenerada);
				
			}else {
				
				System.out.println("Error");
			}
			
			
			
			for (Asignatura a : arrayAsignatura) {
				
				PreparedStatement ps2 = null;
				ps2 = c.prepareStatement("INSERT INTO ASIGNATURA (nombre, horasSemanales, id_Ciclo) VALUES ((?), (?), (?));", Statement.RETURN_GENERATED_KEYS);
				ps2.setString(1, a.getNombreAsig());
				ps2.setInt(2, a.getHorasSem());
				ps2.setInt(3, idGenerada);
				ps2.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
	}
}
