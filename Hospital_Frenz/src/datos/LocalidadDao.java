package datos;

import java.util.List;

import entidad.Localidad;

public interface LocalidadDao {
	public List<Localidad> obtenerTodas();
	public List<Localidad> obtenerLocxProv(int idProv);
	public List<Localidad> obtenerLocxProvxSed(int idProv);
	public Localidad obtenerUna(int id);
	public boolean insertar(Localidad loc);
}
