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
	public boolean borrar(int idturno, int idsede) {
		return turDao.borrar(idturno, idsede);
	}

}
