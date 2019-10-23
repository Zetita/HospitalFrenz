package datos;

import java.util.List;

import entidad.Medico;

public interface MedicoDao {
	public List<Medico> obtenerTodos();
	public Medico obtenerUnoDni(int dni);
	public Medico obtenerUnoMat(int mat);
	public boolean insertar(Medico med);
	public boolean editar(Medico med);
	public boolean borrar(int dni);
}
