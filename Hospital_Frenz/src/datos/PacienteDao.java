package datos;

import java.util.List;

import entidad.Paciente;

public interface PacienteDao {
	
	public List<Paciente> obtenerTodos();
	public Paciente obtenerUno(int id);
	public boolean insertar(Paciente pac);
}
