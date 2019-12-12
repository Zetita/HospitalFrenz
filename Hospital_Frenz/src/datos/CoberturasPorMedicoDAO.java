package datos;

import entidad.Medico;

import java.util.List;

import entidad.Cobertura;
import entidad.CoberturasPorMedicos;

public interface CoberturasPorMedicoDAO {

	public List <CoberturasPorMedicos> obtenerTodasLasCoberturasPorMedico();
	public CoberturasPorMedicos obtenerUna(CoberturasPorMedicos cob);
	public boolean insertar(CoberturasPorMedicos cob);
	public boolean modificar (CoberturasPorMedicos cob);
	public boolean borrar (CoberturasPorMedicos cob);
	
}
