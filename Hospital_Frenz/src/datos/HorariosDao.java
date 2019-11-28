package datos;

import java.util.List;

import entidad.Horarios;

public interface HorariosDao {

	public List<Horarios> obtenerTodas();
	
	public List<Horarios> obtenerHorariosPorMedico(String idMatricula) ;
	
	public boolean insertar(Horarios hor);
	
	public boolean modificar (Horarios hor);
	
	public boolean borrar(String IDMatriculaMed, int IDSede, int IDEspecialidad);
	
}
