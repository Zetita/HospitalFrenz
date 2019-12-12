package negocio;

import java.util.ArrayList;
import entidad.Sede;

public interface SedeNeg {
	public ArrayList<Sede> obtenerTodas();
	public ArrayList<Sede> obtenerSedesxLoc(int idLoc); 
	public Sede obtenerUna(int id);
	public boolean insertar(Sede sede);
	public boolean editar(Sede sede);
	public boolean borrar(int id);
}
