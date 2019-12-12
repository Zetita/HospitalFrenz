package negocioImpl;

import java.util.ArrayList;

import datosImpl.MedicosPorSedeDaoImpl;
import entidad.MedicosPorSede;
import negocio.MedicosPorSedeNeg;

public class MedicosPorSedeNegImpl implements MedicosPorSedeNeg{
	
	MedicosPorSedeDaoImpl medicos = new MedicosPorSedeDaoImpl();
	
	
	@Override
	public ArrayList<MedicosPorSede> obtenerTodos() {
		 return (ArrayList<MedicosPorSede>) medicos.obtenerTodos();
	}

	@Override
	public MedicosPorSede obtenerUno(MedicosPorSede medPorSede) {
		return medicos.obtenerUno(medPorSede);
	}

	@Override
	public boolean insertar(MedicosPorSede med) {
		return medicos.insertar(med);
	}

	@Override
	public boolean editar(MedicosPorSede med) {
		return medicos.editar(med);
	}

	@Override
	public boolean borrar(int IdSede, String matricula) {
		return medicos.borrar(IdSede, matricula);
	}

}
