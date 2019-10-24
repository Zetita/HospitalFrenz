package datosImpl;

import datos.UsuarioDao;
import entidad.Especialidad;
import entidad.Usuario;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frgp.bd.SQLException;

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
				user.setAdmin(rs.getBoolean("usuarios.AdminUser"));
				user.setTipo(rs.getBoolean("usuarios.TipoUser"));
				
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
			user.setAdmin(rs.getBoolean("usuarios.AdminUser"));
			user.setTipo(rs.getBoolean("usuarios.TipoUser"));
			
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
			class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean estado=true;
		int cantFilas = 0;
		cn = new Conexion();
		cn.Open();
		
		try {
			estado= cn.execute("DELETE from usuarios WHERE DNIUser="+dni);
		}
		catch(SQLException e){
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
				+ "ContraseniaUser, AdminUser, TipoUser) VALUES ('"
				+ user.getUsuario()+"', '"+user.getEmail()+"', "+user.getDNI()+", '"
				+ user.getContrasenia()+	"', "+user.isAdmin()+", "+user.isTipo()+")";	
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
		+"',ContraseniaUser='"+user.getContrasenia()+"', AdminUser="+user.isAdmin()+
		", TipoUser="+user.isTipo()+" WHERE IDCobertura="+user.getDNI();
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

	
	
}
