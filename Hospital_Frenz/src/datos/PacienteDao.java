package datos;

import java.util.List;

import entidad.Paciente;

public interface PacienteDao {
	
	public List<Paciente> obtenerTodos();
	public Paciente obtenerUno(int dni);
	public boolean insertar(Paciente pac);
	public boolean editar(Paciente pac);
	public boolean borrar(int dni);
}