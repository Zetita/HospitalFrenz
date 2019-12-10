package negocio;

import java.util.ArrayList;

import entidad.Provincia;

public interface ProvinciaNeg {
	public ArrayList<Provincia> listarProvincias();
	public ArrayList<Provincia> listarProvinciasConSedes();
	public Provincia obtenerUna(int id);
	public boolean insertar(Provincia prov);
}
