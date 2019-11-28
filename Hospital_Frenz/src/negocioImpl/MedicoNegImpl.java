package negocioImpl;

import java.util.ArrayList;

import datos.MedicoDao;
import datosImpl.MedicoDaoImpl;
import entidad.Medico;
import negocio.MedicoNeg;

public class MedicoNegImpl implements MedicoNeg {

	MedicoDao medDao = new MedicoDaoImpl();
	
	public MedicoNegImpl(MedicoDao medDao) {
		super();
		this.medDao = medDao;
	}
	public MedicoNegImpl()
	{
		
	}
	@Override
	public ArrayList<Medico> listarMedicos() {
		return (ArrayList<Medico>) medDao.obtenerTodos();
	}

	@Override
	public Medico obtenerUnoDni(String dni) {
		return medDao.obtenerUnoDni(dni);
	}

	@Override
	public Medico obtenerUnoMat(String mat) {
		return medDao.obtenerUnoMat(mat);
	}

	@Override
	public boolean insertar(Medico med) {
		return medDao.insertar(med);
	}

	@Override
	public boolean editar(Medico med) {
		return medDao.editar(med);
	}

	@Override
	public boolean borrar(String dni) {
		return medDao.borrar(dni);
	}

}
