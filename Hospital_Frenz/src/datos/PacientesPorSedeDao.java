package datos;


import java.util.List;
import entidad.PacientesPorSede;

public interface PacientesPorSedeDao {

	public List <PacientesPorSede> obtenerTodosLosPacientesPorSede();
	public PacientesPorSede obtenerUno(PacientesPorSede pacxsede);
	public boolean insertar (PacientesPorSede pacxsede);
	public boolean modificar (PacientesPorSede pacxsede);
	public boolean borrar (PacientesPorSede pacxsede);
}
