package entidad;

import java.sql.Date;

public class Horarios {
	private String IDMatriculaMed;
	private int IDSede;
	private int IDEspecialidad;
	private String Dia;
	private Date Hora;
	
	public Horarios() {
		
	}
	
	public Horarios (String IDMatriculaMed, int IDSede, int IDEspecialidad,String Dia, Date Hora) {
		super();
		this.IDMatriculaMed=IDMatriculaMed;
		this.IDSede=IDSede;
		this.IDEspecialidad=IDEspecialidad;
		this.Dia=Dia;
		this.Hora=Hora;
	}
	
	public String getIDMatriculaMed() {
		return IDMatriculaMed;
	}

	public void setIDMatriculaMed(String iDMatriculaMed) {
		IDMatriculaMed = iDMatriculaMed;
	}

	public int getIDSede() {
		return IDSede;
	}

	public void setIDSede(int iDSede) {
		IDSede = iDSede;
	}

	public int getIDEspecialidad() {
		return IDEspecialidad;
	}

	public void setIDEspecialidad(int numEspecialidad) {
		IDEspecialidad = numEspecialidad;
	}

	public String getDia() {
		return Dia;
	}

	public void setDia(String dia) {
		Dia = dia;
	}

	public Date getHora() {
		return Hora;
	}

	public void setHora(Date hora) {
		Hora = hora;
	}

	public String toString() {
		return "Horarios IDMatriculaMed=" + IDMatriculaMed + ", IDSede=" + IDSede + ", IDEspecialidad="
				+ IDEspecialidad + ", Dia=" + Dia + ", Hora=" + Hora;
	}
	
	
}
