package datosImpl;

import datos.UsuarioDao;
import entidad.Cobertura;
import entidad.Localidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Provincia;
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
			rs.next();
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
		String sql= "Select * from usuarios WHERE NombreUser='"+usuario+"' AND ContraseniaUser='"+pass+"'";
		System.out.println(sql);
		try 
		{
			
			ResultSet rs= cn.query(sql);
			rs.next();
			
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
		System.out.println(u);
		return u;
	}

	@Override
	public Paciente buscarPaciente(String usuario) {
		cn = new Conexion();
		cn.Open();
		Paciente pac = new Paciente();
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		Cobertura cob= new Cobertura();
		try 
		{
			ResultSet rs= cn.query("Select * from pacientes INNER JOIN usuarios ON pacientes.DNIPaciente=usuarios.DNIUser "
					+ "WHERE usuarios.NombreUser=" + usuario);
			 
			pac.setDni(rs.getInt("pacientes.DNIPaciente"));
			pac.setNombre(rs.getString("pacientes.NombrePaciente"));
			pac.setApellido(rs.getString("pacientes.ApellidoPaciente"));
			pac.setFecha(rs.getString("pacientes.FechaNacPaciente"));
			pac.setTelefono(rs.getInt("pacientes.Telefono"));
			pac.setDireccion(rs.getString("pacientes.DireccionPaciente"));
			 
			prov.setId(rs.getInt("provincias.id"));
			prov.setNombre(rs.getString("provincias.nombre"));
			prov.setCodigo31662(rs.getString("provincias.codigo31662"));
			 
			loc.setId(rs.getInt("localidades.id"));
			loc.setNombre(rs.getString("localidades.nombre"));
			loc.setCp(rs.getInt("localidades.codigopostal"));
			loc.setProvincia(prov);
			
			cob.setIdCobertura(rs.getInt("coberturas.IDCobertura"));
			cob.setNombre(rs.getString("coberturas.NombreCobertura"));
			cob.setTipo(rs.getString("coberturas.TipoCobertura"));
			
			pac.setIdProvincia(prov);
			pac.setLocalidad(loc);
			pac.setCobertura(cob);
			pac.setEstado(rs.getBoolean("pacientes.EstadoPaciente"));
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
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		try 
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN usuarios ON medicos.DNIPaciente=usuarios.DNIUser "
					+ "WHERE usuarios.NombreUser=" + usuario);
			 		
			 
			med.setDni(rs.getInt("medicos.DNIMed"));
			med.setMatricula(rs.getInt("medicos.MatriculaMed"));
			med.setNombre(rs.getString("medicos.NombreMedico"));
			med.setApellido(rs.getString("medicos.ApellidosMedico"));
			med.setTelefono(rs.getInt("medicos.Telefono"));
			med.setDireccion(rs.getString("medicos.DireccionMedico"));
			 
			prov.setId(rs.getInt("provincias.id"));
			prov.setNombre(rs.getString("provincias.nombre"));
			prov.setCodigo31662(rs.getString("provincias.codigo31662"));
			 
			loc.setId(rs.getInt("localidades.id"));
			loc.setNombre(rs.getString("localidades.nombre"));
			loc.setCp(rs.getInt("localidades.codigopostal"));
			loc.setProvincia(prov);
		
			med.setIdProvincia(prov);
			med.setLocalidad(loc);
			med.setEstado(rs.getInt("medicos.EstadoMed"));
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
