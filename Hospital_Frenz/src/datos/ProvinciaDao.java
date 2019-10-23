package datos;

import java.util.List;

import entidad.Provincia;

public interface ProvinciaDao {

	public List<Provincia> obtenerTodos();
	public Provincia obtenerUno(int id);
	public boolean insertar(Provincia prov);
}
