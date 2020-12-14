package Vista;

import java.util.ArrayList;

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
		Asignatura as = new Asignatura(1, "Acceso a datos", 6, 1);
		Ciclo cl = new Ciclo(1, "Desarrollo Apps", "FP superior", null);
		
		//MÉTODOS
		
		ArrayList<Asignatura> arrayAsignatura = new ArrayList<Asignatura>();
		arrayAsignatura.add(as);
		//con.cargarDriver();
		//con.crearConexion();
		co.insertarCiclo(cl);
		as.setIdCiclo(cl.getIdCiclo());
		ad.insertarAsig(as);
		/*ad.modificarAsig(as);
		ad.eliminarAsig(as);
		co.insertarCiclo(cl);
		co.modificarCiclo(cl);
		co.eliminarCiclo(cl);
		con.cerrarConexion(null);*/
		//co.crearCiclo(cl, arrayAsignatura);

	}

}
