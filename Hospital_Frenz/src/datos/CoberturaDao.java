package datos;

import java.util.List;

import entidad.Cobertura;

public interface CoberturaDao {

	public List<Cobertura> obtenerTodas();
	public Cobertura obtenerUna(int id);
	public boolean insertar(Cobertura cob);
}
