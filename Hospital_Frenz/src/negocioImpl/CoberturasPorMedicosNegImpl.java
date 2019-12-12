package negocioImpl;

import java.util.ArrayList;

import datosImpl.CoberturasPorMedicosDaoImpl;
import entidad.CoberturasPorMedicos;
import negocio.CoberturasPorMedioNeg;

public class CoberturasPorMedicosNegImpl implements CoberturasPorMedioNeg {

	CoberturasPorMedicosDaoImpl cob1 = new CoberturasPorMedicosDaoImpl();
	
	@Override
	public ArrayList<CoberturasPorMedicos> obtenerTodasLasCoberturasPorMedico() {
		return (ArrayList<CoberturasPorMedicos>) cob1.obtenerTodasLasCoberturasPorMedico();
	}

	@Override
	public CoberturasPorMedicos obtenerUna(CoberturasPorMedicos cob) {
		return cob1.obtenerUna(cob);
	}

	@Override
	public boolean insertar(CoberturasPorMedicos cob) {
		return cob1.insertar(cob);
	}

	@Override
	public boolean modificar(CoberturasPorMedicos cob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(CoberturasPorMedicos cob) {
		return cob1.borrar(cob);
	}

}
