package negocioImpl;

import java.util.ArrayList;

import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import entidad.Medico;
import entidad.Paciente;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{

	private UsuarioDao userDao= new UsuarioDaoImpl();
	
	public UsuarioNegImpl() {
		
	}

	public UsuarioNegImpl(UsuarioDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		return (ArrayList<Usuario>) userDao.obtenerTodas();
	}

	@Override
	public ArrayList<Usuario> listarUsuarios(String Consulta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuario(String dni) {
		return userDao.obtenerUna(dni);
	}
	@Override
	public Usuario obtenerUsuarioUser(String usuario) {
		return userDao.obtenerUnoUser(usuario);
	}
	@Override
	public boolean borrar(String dni) {
		return userDao.eliminar(dni);
	}

	@Override
	public boolean insertar(Usuario user) {
		return userDao.insertar(user);
	}

	@Override
	public boolean editar(Usuario user) {
		return userDao.editar(user);
	}

	@Override
	public Usuario ingresar(String usuario, String pass) {
		return userDao.ingresar(usuario,pass);
	}

	@Override
	public Paciente buscarPaciente(String usuario) {
		return userDao.buscarPaciente(usuario);
	}

	@Override
	public Medico buscarMedico(String usuario) {
		return userDao.buscarMedico(usuario);
	}
	
}
