package negocio;

import java.util.ArrayList;

import entidad.Localidad;

public interface LocalidadNeg {
	
	public ArrayList<Localidad> listarLocalidades();
	public ArrayList<Localidad> listarLocalidadesxProv(int idProv);
	public Localidad obtenerUna(int id);
	public boolean insertar(Localidad loc);
}
