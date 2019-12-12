package datos;

import java.util.List;

import entidad.Sede;

public interface SedeDao {
	public List<Sede> obtenerTodas();
	public List<Sede> obtenerSedesxLoc(int idLoc);
	public Sede obtenerUna(int id);
	public boolean insertar(Sede sede);
	public boolean editar(Sede sede);
	public boolean borrar(int id);
}
