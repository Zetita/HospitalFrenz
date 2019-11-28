package negocio;

import java.util.ArrayList;

import entidad.Medico;

public interface MedicoNeg {
	public ArrayList<Medico> listarMedicos();
	public Medico obtenerUnoDni(String dni);
	public Medico obtenerUnoMat(String mat);
	public boolean insertar(Medico med);
	public boolean editar(Medico med);
	public boolean borrar(String dni);
}
