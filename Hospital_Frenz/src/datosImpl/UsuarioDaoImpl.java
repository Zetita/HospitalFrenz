package datosImpl;

import datos.UsuarioDao;
import entidad.Cobertura;
import entidad.Localidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Usuario;
import negocio.CoberturaNeg;
import negocio.LocalidadNeg;
import negocioImpl.CoberturaNegImpl;
import negocioImpl.LocalidadNegImpl;

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
				user.setDNI(rs.getString("usuarios.DNIUser"));
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
		cn = new Conexion();
		cn.Open();
		List<Usuario> list = new ArrayList<Usuario>();
		try
		{
			ResultSet rs = cn.query(Consulta);
			while(rs.next())
			{
				Usuario user = new Usuario();
				user.setUsuario(rs.getString("usuarios.NombreUser"));
				user.setEmail(rs.getString("usuarios.EmailUser"));
				user.setDNI(rs.getString("usuarios.DNIUser"));
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
	public String obtenerTipo(String dni) {
		cn = new Conexion();
		cn.Open();

		String Tipo="";
		
		try 
		{
			ResultSet rs= cn.query("SELECT IF ((SELECT COUNT(DNIPaciente) FROM PACIENTES WHERE DNIPACIENTE LIKE '"+dni+"')>0,\"Paciente\",\r\n" + 
					"	IF ((SELECT COUNT(DNIMed) FROM Medicos WHERE DNIMed LIKE '"+dni+"')>0,\"Medico\",\"Administrador\")) as Tipo");
			rs.next();
			Tipo=rs.getString("Tipo");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return Tipo;
	}
	
	@Override
	public Usuario obtenerUna(String dni) {
		cn = new Conexion();
		cn.Open();
		Usuario user = new Usuario();
		try 
		{
			ResultSet rs= cn.query("Select * from usuarios WHERE DNIUser='"+dni+"'");
			rs.next();
			user.setUsuario(rs.getString("usuarios.NombreUser"));
			user.setEmail(rs.getString("usuarios.EmailUser"));
			user.setDNI(rs.getString("usuarios.DNIUser"));
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
	public Usuario obtenerUnoUser(String usuario) {
		cn = new Conexion();
		cn.Open();
		Usuario user = new Usuario();
		try 
		{
			ResultSet rs= cn.query("Select * from usuarios WHERE NombreUser='"+usuario+"'");
			rs.next();
			user.setUsuario(rs.getString("usuarios.NombreUser"));
			user.setEmail(rs.getString("usuarios.EmailUser"));
			user.setDNI(rs.getString("usuarios.DNIUser"));
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
	public boolean eliminar(String dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean estado=true;
		cn = new Conexion();
		cn.Open();
		
		try {
			estado= cn.execute("DELETE from usuarios WHERE DNIUser='"+dni+"'");
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
		
		String query="INSERT INTO usuarios(NombreUser, EmailUser, DNIUser, ContraseniaUser, TipoUser, EstadoUser) VALUES ('"
				+ user.getUsuario()+"', '"+user.getEmail()+"', '"+user.getDNI()+"', '"
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
	public boolean editar(String Consulta) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		try
		 {
			estado=cn.execute(Consulta);
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
		+"', ContraseniaUser='"+user.getContrasenia()+"', TipoUser='"+user.getTipo()+"', EstadoUser="+user.isEstado()+
		" WHERE DNIUser='"+user.getDNI()+"'";
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
		String sql= "Select * from usuarios WHERE NombreUser='"+usuario+"' AND ContraseniaUser='"+pass+"'";
		try 
		{
			
			ResultSet rs= cn.query(sql);
			rs.next();
			
			u.setUsuario(rs.getString("usuarios.NombreUser"));
			u.setEmail(rs.getString("usuarios.EmailUser"));
			u.setDNI(rs.getString("usuarios.DNIUser"));
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

	@Override
	public Paciente buscarPaciente(String usuario) {
		cn = new Conexion();
		cn.Open();
		Paciente pac = new Paciente();
		LocalidadNeg locNeg= new LocalidadNegImpl();
		Localidad loc = new Localidad();
		Cobertura cob= new Cobertura();
		CoberturaNeg cobNeg= new CoberturaNegImpl();
		try 
		{
			ResultSet rs= cn.query("Select * from pacientes INNER JOIN usuarios ON pacientes.DNIPaciente=usuarios.DNIUser "
					+ "WHERE usuarios.NombreUser='" + usuario +"'");
			rs.next();
			
			pac.setDni(rs.getString("pacientes.DNIPaciente"));
			pac.setNombre(rs.getString("pacientes.NombrePaciente"));
			pac.setApellido(rs.getString("pacientes.ApellidoPaciente"));
			pac.setFecha(rs.getString("pacientes.FechaNacPaciente"));
			pac.setTelefono(rs.getString("pacientes.Telefono"));
			pac.setDireccion(rs.getString("pacientes.DireccionPaciente"));
			pac.setEstado(rs.getInt("pacientes.EstadoPaciente"));
			 
			loc=locNeg.obtenerUna(rs.getInt("pacientes.IDLocalidad"));
			cob=cobNeg.obtenerUna(rs.getInt("pacientes.IDCobertura"));
			
			pac.setLocalidad(loc);
			pac.setCobertura(cob);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return pac;
	}

	@Override
	public Medico buscarMedico(String usuario) {
		cn = new Conexion();
		cn.Open();
		Medico med = new Medico();
		LocalidadNeg locNeg= new LocalidadNegImpl();
		Localidad loc = new Localidad();
		try 
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN usuarios ON medicos.DNIMed=usuarios.DNIUser "
					+ "WHERE usuarios.NombreUser='" + usuario+"'");
			 		
			rs.next();

			med.setDni(rs.getString("medicos.DNIMed"));
			med.setMatricula(rs.getString("medicos.MatriculaMed"));
			med.setNombre(rs.getString("medicos.NombreMed"));
			med.setApellido(rs.getString("medicos.ApellidosMed"));
			med.setTelefono(rs.getString("medicos.TelefonoMed"));
			med.setDireccion(rs.getString("medicos.DireccionMed"));
			med.setEstado(rs.getInt("medicos.EstadoMed"));
			
			loc=locNeg.obtenerUna(rs.getInt("medicos.IDLocalidad"));

			med.setLocalidad(loc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return med;
	}

	
	
}
