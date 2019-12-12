package entidad;

import entidad.Medico;
import entidad.Sede;


public class MedicosPorSede {
	
	private Medico medico;
	private Sede sede;
	private int estado;
	
	public MedicosPorSede() {
		
	}
	
	public MedicosPorSede(Medico med, Sede sede, int estado) {
		this.medico=med;
		this.sede=sede;
		this.estado=estado;
	}
	
	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public Sede getSede() {
		return sede;
	}



	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public void setEstado(int estado) {
		this.estado=estado;
	}
	
	public int getEstado() {
		return this.estado;
	}

	@Override
	public String toString() {
		return "MedicosPorSede [medico=" + medico.getMatricula() + ", sede=" + sede.getId() + "]";
	}
	
	
	
}
