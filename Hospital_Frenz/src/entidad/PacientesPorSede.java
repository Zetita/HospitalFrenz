package entidad;

import entidad.Paciente;
import entidad.Sede;


public class PacientesPorSede {

	private Paciente pac;
	private Sede sede;
	public Paciente getPac() {
		return pac;
	}
	public void setPac(Paciente pac) {
		this.pac = pac;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	@Override
	public String toString() {
		return "PacientesPorSede [pac=" + pac.getDni() + ", sede=" + sede.getId() + "]";
	}

	

	
}
