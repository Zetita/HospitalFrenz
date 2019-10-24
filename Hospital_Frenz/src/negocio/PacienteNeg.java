package negocio;

import java.util.ArrayList;

import entidad.Paciente;

public interface PacienteNeg {
	public ArrayList<Paciente> listarPacientes();
	public Paciente obtenerUno(int dni);
	public boolean insertar(Paciente pac);
	public boolean editar(Paciente pac);
	public boolean borrar(int dni);
}