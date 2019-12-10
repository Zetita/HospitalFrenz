package datos;

import java.util.List;

import entidad.Provincia;

public interface ProvinciaDao {

	public List<Provincia> obtenerTodos();
	public List<Provincia> obtenerProvinciasConSedes();
	public Provincia obtenerUna(int id);
	public boolean insertar(Provincia prov);
}
