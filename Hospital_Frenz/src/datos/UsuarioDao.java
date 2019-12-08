package datos;

import java.util.List;

import entidad.Medico;
import entidad.Paciente;
import entidad.Usuario;

public interface UsuarioDao {
	public List<Usuario> obtenerTodas();
	public List<Usuario> obtenerTodas(String Consulta);
	public Usuario obtenerUna(String dni);
	public Usuario obtenerUnoUser(String usuario);
	public boolean eliminar(String dni);
	public boolean insertar(Usuario user);
	public boolean editar(Usuario user);
	public Usuario ingresar(String usuario, String pass);
	public Paciente buscarPaciente(String usuario);
	public Medico buscarMedico(String usuario);
}
