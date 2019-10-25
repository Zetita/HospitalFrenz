package negocioImpl;

import java.util.ArrayList;

import datos.SedeDao;
import datosImpl.SedeDaoImpl;
import entidad.Sede;
import negocio.SedeNeg;

public class SedeNegImpl implements SedeNeg {

	SedeDao sedeDao = new SedeDaoImpl();
	
	@Override
	public ArrayList<Sede> obtenerTodas() {
		return (ArrayList<Sede>) sedeDao.obtenerTodas();
	}

	@Override
	public Sede obtenerUna(int id) {
		return sedeDao.obtenerUna(id);
	}

	@Override
	public boolean insertar(Sede sede) {
		return sedeDao.insertar(sede);
	}

	@Override
	public boolean editar(Sede sede) {
		return sedeDao.editar(sede);
	}

	@Override
	public boolean borrar(int id) {
		return sedeDao.borrar(id);
	}

}
