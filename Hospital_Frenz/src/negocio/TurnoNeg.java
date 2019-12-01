package negocio;

import java.util.ArrayList;

import entidad.Turno;

public interface TurnoNeg {
	public ArrayList<Turno> obtenerTodos();
	public Turno obtenerUno(int idturno, int idsede);
	public boolean insertar(Turno tur);
	public boolean editar(Turno tur);
	public boolean borrar(int idturno, int idsede);
}
