package negocio;

import java.util.ArrayList;

import entidad.MedicosPorSede;

public interface MedicosPorSedeNeg {

	public ArrayList<MedicosPorSede> obtenerTodos();
	public MedicosPorSede obtenerUno(MedicosPorSede medPorSede);
	public boolean insertar(MedicosPorSede med);
	public boolean editar(MedicosPorSede med);
	public boolean borrar(int IdSede,String matricula);
	
}
