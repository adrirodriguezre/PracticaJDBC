package Vista;

import Datos.AsignaturaDAO;
import Datos.CicloDAO;
import Datos.ConexionMySQL;
import Entidades.Asignatura;
import Entidades.Ciclo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexionMySQL con = new ConexionMySQL();
		AsignaturaDAO ad = new AsignaturaDAO();
		CicloDAO co = new CicloDAO();
		Asignatura as = new Asignatura(20, "Acceso a datos", 6);
		Ciclo cl = new Ciclo(4, "Desarrollo Apps", "FP superior", null);
		
		//MÉTODOS
		
		con.cargarDriver();
		con.crearConexion();
		ad.insertarAsig(as);
		ad.modificarAsig(as);
		ad.eliminarAsig(as);
		co.insertarCiclo(cl);
		co.modificarCiclo(cl);
		co.eliminarCiclo(cl);
		con.cerrarConexion(null);

	}

}
