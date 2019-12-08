package negocio;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Paciente;
import entidad.Usuario;

public interface UsuarioNeg {
	public ArrayList<Usuario> listarUsuarios();
	public ArrayList<Usuario> listarUsuarios(String Consulta);
	public Usuario obtenerUsuario(String dni);
	public Usuario obtenerUsuarioUser(String usuario);
	public boolean borrar(String dni);
	public boolean insertar(Usuario user);
	public boolean editar(Usuario user);
	public Usuario ingresar(String usuario, String pass);
	public Paciente buscarPaciente(String usuario);
	public Medico buscarMedico(String usuario);
}
