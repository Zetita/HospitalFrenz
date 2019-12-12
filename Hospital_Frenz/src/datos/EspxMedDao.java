package datos;

import java.util.List;

import entidad.EspxMed;

public interface EspxMedDao {
	public List<EspxMed> obtenerTodas();
	public EspxMed obtenerUna(String MatMed,int IDEsp);
	public boolean insertar(EspxMed esp);
	public boolean editar(EspxMed esp);
	public boolean borrar(EspxMed esp);
}
