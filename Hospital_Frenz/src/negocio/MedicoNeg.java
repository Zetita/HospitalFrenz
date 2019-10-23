package negocio;

import java.util.ArrayList;

import entidad.Medico;

public interface MedicoNeg {
	public ArrayList<Medico> listarMedicos();
	public Medico obtenerUnoDni(int dni);
	public Medico obtenerUnoMat(int mat);
	public boolean insertar(Medico med);
	public boolean editar(Medico med);
	public boolean borrar(int dni);
}
