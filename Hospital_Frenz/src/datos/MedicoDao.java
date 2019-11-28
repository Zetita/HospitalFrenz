package datos;

import java.util.List;

import entidad.Medico;

public interface MedicoDao {
	public List<Medico> obtenerTodos();
	public Medico obtenerUnoDni(String dni);
	public Medico obtenerUnoMat(String mat);
	public boolean insertar(Medico med);
	public boolean editar(Medico med);
	public boolean borrar(String dni);
}
