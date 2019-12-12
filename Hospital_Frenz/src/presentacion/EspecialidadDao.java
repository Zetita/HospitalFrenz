package datos;

import java.util.List;

import entidad.Especialidad;

public interface EspecialidadDao {
	public List<Especialidad> obtenerTodas(int Origen);
	public Especialidad obtenerUna(int id);
	public boolean insertar(Especialidad esp);
	public boolean editar(Especialidad esp);
	public boolean borrar(int id);
}
