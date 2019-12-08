package negocioImpl;

import java.util.ArrayList;

import datos.TurnoDao;
import datosImpl.TurnoDaoImpl;
import entidad.Turno;
import negocio.TurnoNeg;

public class TurnoNegImpl implements TurnoNeg {

	TurnoDao turDao= new TurnoDaoImpl();
	
	@Override
	public ArrayList<Turno> obtenerTodos() {
		return (ArrayList<Turno>) turDao.obtenerTodos();
	}
	

	@Override
	public Turno obtenerUno(int idturno, int idsede) {
		return turDao.obtenerUno(idturno, idsede);
	}

	@Override
	public boolean insertar(Turno tur) {
		return turDao.insertar(tur);
	}

	@Override
	public boolean editar(Turno tur) {
		return turDao.editar(tur);
	}

	@Override
	public boolean baja(int idturno, int idsede, int est) {
		return turDao.baja(idturno, idsede, est);
	}

	@Override
	public boolean cargarAsistencia(int idturno, int idsede, int est) {
		return turDao.cargarAsistencia(idturno, idsede, est);
	}
	@Override
	public ArrayList<Turno> obtenerPendientes(String OP, String id) {
		return (ArrayList<Turno>) turDao.obtenerPendientes(OP, id);
	}


	@Override
	public ArrayList<Turno> obtenerPasados(String OP, String id) {
		return (ArrayList<Turno>) turDao.obtenerPasados(OP, id);
	}


	

}
