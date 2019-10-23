package negocio;

import java.util.ArrayList;

import entidad.Cobertura;

public interface CoberturaNeg {
	
	public ArrayList<Cobertura> listarCoberturas();
	public Cobertura obtenerUna(int id);
	public boolean insertar(Cobertura cob);
	public boolean editar(Cobertura cob);
}
