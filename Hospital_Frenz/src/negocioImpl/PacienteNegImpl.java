package negocioImpl;

import java.util.ArrayList;

import datos.PacienteDao;
import datosImpl.PacienteDaoImpl;
import entidad.Paciente;
import negocio.PacienteNeg;

public class PacienteNegImpl implements PacienteNeg {

	public PacienteDao pacDao = new PacienteDaoImpl();
	
	public PacienteNegImpl(PacienteDao pacDao) {
		this.pacDao = pacDao;
	}
	
	@Override
	public ArrayList<Paciente> listarPacientes() {
		return (ArrayList<Paciente>) pacDao.obtenerTodos();
	}

	@Override
	public Paciente obtenerUno(int dni) {
		return pacDao.obtenerUno(dni);
	}

	@Override
	public boolean insertar(Paciente pac) {
		return pacDao.insertar(pac);
	}

	@Override
	public boolean editar(Paciente pac) {
		return pacDao.editar(pac);
	}

	@Override
	public boolean borrar(int dni) {
		return pacDao.borrar(dni);
	}

}
