package negocio;

import java.util.ArrayList;
import entidad.Turno;

public interface TurnoNeg {
	public ArrayList<Turno> obtenerTodos();
	public ArrayList<Turno> obtenerPendientes(String OP, String id);
	public ArrayList<Turno> obtenerPasados(String OP, String id);
	public Turno obtenerUno(int idturno, int idsede);
	public boolean insertar(Turno tur);
	public boolean editar(Turno tur);
	public boolean baja(int idturno, int idsede, int est);
	public boolean cargarAsistencia(int idturno, int idsede, int est);
}
