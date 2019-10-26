package datosImpl;

import datos.UsuarioDao;
import entidad.Usuario;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{

	private Conexion cn;
	
	public List<Usuario> obtenerTodas() {
		cn = new Conexion();
		cn.Open();
		List<Usuario> list = new ArrayList<Usuario>();
		try
		{
			ResultSet rs = cn.query("Select * from usuarios");
			while(rs.next())
			{
				Usuario user = new Usuario();
				user.setUsuario(rs.getString("usuarios.NombreUser"));
				user.setEmail(rs.getString("usuarios.EmailUser"));
				user.setDNI(rs.getInt("usuarios.DNIUser"));
				user.setContrasenia(rs.getString("usuarios.ContraseniaUser"));
				user.setTipo(rs.getString("usuarios.TipoUser"));
				user.setEstado(rs.getBoolean("usuarios.EstadoUser"));
				list.add(user);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return list;
		
	}

	@Override
	public List<Usuario> obtenerTodas(String Consulta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Usuario obtenerUna(int dni) {
		cn = new Conexion();
		cn.Open();
		Usuario user = new Usuario();
		try 
		{
			ResultSet rs= cn.query("Select * from usuarios WHERE DNIUser="+dni);
			
			user.setUsuario(rs.getString("usuarios.NombreUser"));
			user.setEmail(rs.getString("usuarios.EmailUser"));
			user.setDNI(rs.getInt("usuarios.DNIUser"));
			user.setContrasenia(rs.getString("usuarios.ContraseniaUser"));
			user.setTipo(rs.getString("usuarios.TipoUser"));
			user.setEstado(rs.getBoolean("usuarios.EstadoUser"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return user;
	}

	@Override
	public boolean eliminar(int dni) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean estado=true;
		cn = new Conexion();
		cn.Open();
		
		try {
			estado= cn.execute("DELETE from usuarios WHERE DNIUser="+dni);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}finally{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean insertar(Usuario user) {
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		
		String query="INSERT INTO usuarios(NombreUser, EmailUser, DNIUser, "
				+ "ContraseniaUser, TipoUser, EstadoUser) VALUES ('"
				+ user.getUsuario()+"', '"+user.getEmail()+"', "+user.getDNI()+", '"
				+ user.getContrasenia()+"', '"+user.getTipo()+"', true)";	
		try
		{
			estado= cn.execute(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean editar(Usuario user) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE usuarios SET NombreUser='"+user.getUsuario()+"', EmailUser='"+user.getEmail()
		+"',ContraseniaUser='"+user.getContrasenia()+"', TipoUser='"+user.getTipo()+"', EstadoUser="+user.isEstado()+" WHERE IDCobertura="+user.getDNI();
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public Usuario ingresar(String usuario, String pass) {
		Usuario u = new Usuario();
		cn = new Conexion();
		cn.Open();

		try 
		{
			ResultSet rs= cn.query("Select * from usuarios WHERE NombreUser='"+usuario+"' AND ContraseniaUser='"+pass+"'");
			
			u.setUsuario(rs.getString("usuarios.NombreUser"));
			u.setEmail(rs.getString("usuarios.EmailUser"));
			u.setDNI(rs.getInt("usuarios.DNIUser"));
			u.setContrasenia(rs.getString("usuarios.ContraseniaUser"));
			u.setTipo(rs.getString("usuarios.TipoUser"));
			u.setEstado(rs.getBoolean("usuarios.EstadoUser"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return u;
	}

	
	
}
