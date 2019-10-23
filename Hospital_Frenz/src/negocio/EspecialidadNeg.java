package negocio;

import java.util.ArrayList;

import entidad.Especialidad;

public interface EspecialidadNeg {

	public ArrayList<Especialidad> listarEspecialidades();
	public Especialidad obtenerUna(int id);
	public boolean insertar(Especialidad esp);
	public boolean editar(Especialidad esp);
	public boolean borrar(int id);
}
