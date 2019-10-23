package negocio;

import java.util.ArrayList;

import entidad.Provincia;

public interface ProvinciaNeg {
	public ArrayList<Provincia> listarProvincias();
	public Provincia obtenerUna(int id);
	public boolean insertar(Provincia prov);
}
