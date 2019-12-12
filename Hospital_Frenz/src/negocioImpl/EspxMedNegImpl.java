package negocioImpl;

import java.util.ArrayList;

import datos.EspxMedDao;
import datosImpl.EspxMedDaoImpl;
import entidad.EspxMed;
import negocio.EspxMedNeg;

public class EspxMedNegImpl implements EspxMedNeg {

	private EspxMedDao espDao =new EspxMedDaoImpl();
	
	public EspxMedNegImpl()
	{
	
	}
	
	@Override
	public ArrayList<EspxMed> listarEspxMed() {
		return (ArrayList<EspxMed>) espDao.obtenerTodas();
	}

	@Override
	public EspxMed obtenerUna(String MatMed,int IDEsp) {
		return espDao.obtenerUna(MatMed,IDEsp);
	}

	@Override
	public boolean insertar(EspxMed esp) {
		return espDao.insertar(esp);
	}

	@Override
	public boolean editar(EspxMed esp) {
		return espDao.editar(esp);
	}

	@Override
	public boolean borrar(EspxMed esp) {
		return espDao.borrar(esp);
	}

}
