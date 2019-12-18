package negocio;

import java.util.ArrayList;

import entidad.Paciente;

public interface PacienteNeg {
	public ArrayList<Paciente> listarPacientes();
	public Paciente obtenerUno(String dni);
	public boolean existe(String consulta);
	public boolean insertar(Paciente pac);
	public boolean editar(Paciente pac);
	public boolean editar(String Consulta);
	public boolean borrar(String dni);
}
