package datos;

import entidad.Sede;
import entidad.Medico;
import java.util.List;

import entidad.MedicosPorSede;

public interface MedicosPorSedeDao {

	public List<MedicosPorSede> obtenerTodos();
	public MedicosPorSede obtenerUno(MedicosPorSede med);
	public boolean insertar(MedicosPorSede med);
	public boolean editar(MedicosPorSede med);
	public boolean borrar(int IdSede,String matricula);
	
	
}
