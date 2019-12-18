package datos;

import java.util.List;

import entidad.Paciente;

public interface PacienteDao {
	
	public List<Paciente> obtenerTodos();
	public Paciente obtenerUno(String dni);
	public boolean existe(String consulta);
	public boolean insertar(Paciente pac);
	public boolean editar(Paciente pac);
	public boolean editar(String Consulta);
	public boolean borrar(String dni);
}
