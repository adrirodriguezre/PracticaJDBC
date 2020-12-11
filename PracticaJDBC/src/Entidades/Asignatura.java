package Entidades;


public class Asignatura {
	
	private int idAsig;
	private String nombreAsig;
	private int horasSem;
	
	//GETTERS Y SETTERS
	public int getIdAsig() {
		return idAsig;
	}
	public void setId(int idAsig) {
		this.idAsig = idAsig;
	}
	public String getNombreAsig() {
		return nombreAsig;
	}
	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}
	public int getHorasSem() {
		return horasSem;
	}
	public void setHorasSem(int horasSem) {
		this.horasSem = horasSem;
	}
	
	
	//CONSTRUCTOR
	public Asignatura(int idAsig, String nombreAsig, int horasSem) {
		super();
		this.idAsig = idAsig;
		this.nombreAsig = nombreAsig;
		this.horasSem = horasSem;
	}
	

}
