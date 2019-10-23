package negocioImpl;

import java.util.ArrayList;

import datos.EspecialidadDao;
import datosImpl.EspecialidadDaoImpl;
import entidad.Especialidad;
import negocio.EspecialidadNeg;

public class EspecialidadNegImpl implements EspecialidadNeg {

	private EspecialidadDao espDao = new EspecialidadDaoImpl();
	
	public EspecialidadNegImpl(EspecialidadDao espDao)
	{
		this.espDao=espDao;
	}
	public EspecialidadNegImpl()
	{
		
	}
	@Override
	public ArrayList<Especialidad> listarEspecialidades() {
		return (ArrayList<Especialidad>) espDao.obtenerTodas();
	}

	@Override
	public Especialidad obtenerUna(int id) {
		return espDao.obtenerUna(id);
	}

	@Override
	public boolean insertar(Especialidad esp) {
		return espDao.insertar(esp);
	}

	@Override
	public boolean editar(Especialidad esp) {
		return espDao.editar(esp);
	}

	@Override
	public boolean borrar(int id) {
		return espDao.borrar(id);
	}

}
