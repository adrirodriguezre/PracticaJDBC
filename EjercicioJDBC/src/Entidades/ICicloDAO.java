package Entidades;

import java.util.ArrayList;

public interface ICicloDAO {
	
	public void insertarCiclo(Ciclo ciclo);
	public void modificarCiclo(Ciclo ciclo);
	public void eliminarCiclo(Ciclo ciclo);
	public void crearCiclo(Ciclo ciclo, ArrayList <Asignatura> arrayAsignatura);
}
