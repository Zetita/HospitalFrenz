package negocioImpl;

import java.util.ArrayList;

import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
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
	public Usuario obtenerUsuario(int dni) {
		return userDao.obtenerUna(dni);
	}

	@Override
	public boolean borrar(int dni) {
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

}
