package entidad;

import java.sql.Time;

public class Turno {
	private int id;
	private Sede sede;
	private Medico medico;
	private Paciente paciente;
	private String fecha;
	private Time hora;
	private Especialidad especialidad;
	private int estado;
	private int asistencia;
	
	public Turno() {
		
	}

	public Turno(int id, Sede sede, Medico medico, Paciente paciente, String fecha, Time hora,
			Especialidad especialidad, int estado, int asistencia) {
		super();
		this.id = id;
		this.sede = sede;
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.especialidad = especialidad;
		this.estado = estado;
		this.asistencia = asistencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(int asistencia) {
		this.asistencia = asistencia;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", sede=" + sede + ", medico=" + medico + ", paciente=" + paciente + ", fecha="
				+ fecha + ", hora=" + hora + ", especialidad=" + especialidad + ", estado=" + estado + ", asistencia="
				+ asistencia + "]";
	}
	
	
}
