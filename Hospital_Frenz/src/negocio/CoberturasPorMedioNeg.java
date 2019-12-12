package negocio;

import java.util.ArrayList;


import entidad.CoberturasPorMedicos;

public interface CoberturasPorMedioNeg {
	public ArrayList <CoberturasPorMedicos> obtenerTodasLasCoberturasPorMedico();
	public CoberturasPorMedicos obtenerUna(CoberturasPorMedicos cob);
	public boolean insertar(CoberturasPorMedicos cob);
	public boolean modificar (CoberturasPorMedicos cob);
	public boolean borrar (CoberturasPorMedicos cob);
}
