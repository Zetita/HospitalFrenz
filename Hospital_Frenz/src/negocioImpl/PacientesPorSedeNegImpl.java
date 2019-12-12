package negocioImpl;

import java.util.ArrayList;

import datosImpl.PacientesPorSedeDaoImpl;
import datos.PacientesPorSedeDao;
import entidad.PacientesPorSede;
import negocio.PacientesPorSedeNeg;

public class PacientesPorSedeNegImpl implements PacientesPorSedeNeg {

	PacientesPorSedeDaoImpl pac = new PacientesPorSedeDaoImpl();
	
	@Override
	public ArrayList<PacientesPorSede> obtenerTodosLosPacientesPorSede() {
		return (ArrayList<PacientesPorSede>) pac.obtenerTodosLosPacientesPorSede();
	}

	@Override
	public PacientesPorSede obtenerUno(PacientesPorSede pacxsede) {
		return pac.obtenerUno(pacxsede);
	}

	@Override
	public boolean insertar(PacientesPorSede pacxsede) {
		return pac.insertar(pacxsede);
	}

	@Override
	public boolean modificar(PacientesPorSede pacxsede) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(PacientesPorSede pacxsede) {
		return pac.borrar(pacxsede);
	}

}
