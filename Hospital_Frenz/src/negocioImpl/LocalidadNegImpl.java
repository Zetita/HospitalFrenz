package negocioImpl;

import java.util.ArrayList;

import datos.LocalidadDao;
import datosImpl.LocalidadDaoImpl;
import entidad.Localidad;
import negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg {

	public LocalidadDao locDao = new LocalidadDaoImpl();
	
	public LocalidadNegImpl(LocalidadDao locDao) {
		this.locDao = locDao;
	}
	public LocalidadNegImpl() {

	}
	@Override
	public ArrayList<Localidad> listarLocalidades() {
		return (ArrayList<Localidad>) locDao.obtenerTodas();
	}
	@Override
	public ArrayList<Localidad> listarLocalidadesxProv(int idProv){
		return (ArrayList<Localidad>) locDao.obtenerLocxProv(idProv);
	}
	@Override
	public Localidad obtenerUna(int id) {
		return locDao.obtenerUna(id);
	}

	@Override
	public boolean insertar(Localidad loc) {
		return locDao.insertar(loc);
	}

}
