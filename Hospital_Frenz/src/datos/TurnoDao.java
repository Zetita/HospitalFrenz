package datos;

import java.util.List;

import entidad.Turno;

public interface TurnoDao {
	public List<Turno> obtenerTodos();
	public Turno obtenerUno(int idturno, int idsede);
	public boolean insertar(Turno tur);
	public boolean editar(Turno tur);
	public boolean borrar(int idturno, int idsede);
}
