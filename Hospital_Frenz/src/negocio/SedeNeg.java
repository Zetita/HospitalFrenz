package negocio;

import java.util.ArrayList;

import entidad.Sede;

public interface SedeNeg {
	public ArrayList<Sede> obtenerTodas();
	public Sede obtenerUna(int id);
	public boolean insertar(Sede sede);
	public boolean editar(Sede sede);
	public boolean borrar(int id);
}
