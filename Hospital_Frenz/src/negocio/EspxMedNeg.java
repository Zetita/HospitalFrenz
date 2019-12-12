package negocio;

import java.util.ArrayList;

import entidad.EspxMed;

public interface EspxMedNeg {
	public ArrayList<EspxMed> listarEspxMed();
	public EspxMed obtenerUna(String MatMed,int IDEsp);
	public boolean insertar(EspxMed esp);
	public boolean editar(EspxMed esp);
	public boolean borrar(EspxMed esp);
}
