package negocioImpl;

import java.util.ArrayList;

import datos.CoberturaDao;
import datosImpl.CoberturaDaoImpl;
import entidad.Cobertura;
import negocio.CoberturaNeg;

public class CoberturaNegImpl implements CoberturaNeg {

	private CoberturaDao cobDao = new CoberturaDaoImpl();
	

	public CoberturaNegImpl(CoberturaDao cobDao) {
		this.cobDao=cobDao;
	}
	public CoberturaNegImpl() {
		
	}
	
	@Override
	public ArrayList<Cobertura> listarCoberturas() {
		return (ArrayList<Cobertura>) cobDao.obtenerTodas();
	}

	@Override
	public Cobertura obtenerUna(int id) {
		return cobDao.obtenerUna(id);
	}

	@Override
	public boolean insertar(Cobertura cob) {
		return cobDao.insertar(cob);
	}

	@Override
	public boolean editar(Cobertura cob) {
		return cobDao.editar(cob);
	}

}
