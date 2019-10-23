package negocioImpl;

import java.util.ArrayList;

import datos.ProvinciaDao;
import datosImpl.ProvinciaDaoImpl;
import entidad.Provincia;
import negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg {

	public ProvinciaDao provDao = new ProvinciaDaoImpl();
	
	public ProvinciaNegImpl(ProvinciaDao provDao) {
		super();
		this.provDao = provDao;
	}
	public ProvinciaNegImpl()
	{
		
	}
	@Override
	public ArrayList<Provincia> listarProvincias() {
		return (ArrayList<Provincia>) provDao.obtenerTodos();
	}

	@Override
	public Provincia obtenerUna(int id) {
		return provDao.obtenerUna(id);
	}

	@Override
	public boolean insertar(Provincia prov) {
		return provDao.insertar(prov);
	}

}
