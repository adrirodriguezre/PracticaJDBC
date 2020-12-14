package Entidades;

import java.util.ArrayList;

public class Ciclo {
	
	private int idCiclo;
	private String nombreCiclo;
	private String grado;
	private ArrayList <Asignatura> arrayAsignatura;
	
	//GETTERS Y SETTERS
	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
	public String getNombreCiclo() {
		return nombreCiclo;
	}
	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public ArrayList <Asignatura> getArrayAsignatura() {
		return arrayAsignatura;
	}
	public void setArrayAsignatura(ArrayList <Asignatura> arrayAsignatura) {
		this.arrayAsignatura = arrayAsignatura;
	}
	
	//CONSTRUCTOR
	public Ciclo(int idCiclo, String nombreCiclo, String grado, ArrayList<Asignatura> arrayAsignatura) {
		super();
		this.idCiclo = idCiclo;
		this.nombreCiclo = nombreCiclo;
		this.grado = grado;
		this.arrayAsignatura = arrayAsignatura;
	}
	

}
