package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.PacienteDao;
import entidad.Cobertura;
import entidad.Localidad;
import entidad.Paciente;
import entidad.Provincia;

public class PacienteDaoImpl implements PacienteDao {

	private Conexion cn;
	
	@Override
	public List<Paciente> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Paciente> list = new ArrayList<Paciente>();
		 try
		 {
			 ResultSet rs= cn.query("Select * from pacientes INNER JOIN localidades ON pacientes.IDLocalidad=localidades.id "
			 		+ "INNER JOIN provincias ON localidades.provincia_id=provincias.id INNER JOIN coberturas ON "
			 		+ "pacientes.IDCobertura=coberturas.IDCobertura");
			 while(rs.next())
			 {
				 
				Paciente pac = new Paciente();
				Provincia prov = new Provincia();
				Localidad loc = new Localidad();
				Cobertura cob= new Cobertura();
				 
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
				
				pac.setLocalidad(loc);
				pac.setCobertura(cob);
				pac.setEstado(rs.getInt("pacientes.EstadoPaciente"));
				list.add(pac); 		 
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
	public Paciente obtenerUno(int dni) {
		
		 cn = new Conexion();
		 cn.Open();
		 Paciente pac = new Paciente();
		 Provincia prov = new Provincia();
		 Localidad loc = new Localidad();
		 Cobertura cob = new Cobertura();
		 
		 try
		 {
			 ResultSet rs= cn.query("Select * from pacientes INNER JOIN localidades ON pacientes.IDLocalidad=localidades.id "
				 		+ "INNER JOIN provincias ON localidades.provincia_id=provincias.id INNER JOIN coberturas ON "
				 		+ "pacientes.IDCobertura=coberturas.IDCobertura WHERE pacientes.DNIPaciente="+dni);
			 rs.next();
			 
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
			
			pac.setLocalidad(loc);
			pac.setCobertura(cob);
			 
			pac.setEstado(rs.getInt("pacientes.EstadoPaciente"));
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
	public boolean insertar(Paciente pac) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO pacientes (DNIPaciente, NombrePaciente, ApellidoPaciente, FechaNacPaciente, Telefono,"
				+ " DireccionPaciente, IDLocalidad, IDCobertura, EstadoPaciente) VALUES ("+pac.getDni()+", '"
				+pac.getNombre()+"', '"+pac.getApellido()+"', "+pac.getFecha()+", "+pac.getTelefono()+", '"+
				pac.getDireccion()+"', "+pac.getLocalidad().getId()+", "+ pac.getCobertura().getIdCobertura()+", "
				+ pac.getEstado()+")";
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
	public boolean editar(Paciente pac) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE pacientes SET NombrePaciente='"+pac.getNombre()+"', ApellidoPaciente='"+pac.getApellido()+"', FechaNacPaciente="
				+pac.getFecha()+", Telefono="+pac.getTelefono()+", DireccionPaciente='"+pac.getDireccion()+"', IDLocalidad="+
				pac.getLocalidad().getId()+", IDCobertura="+pac.getCobertura().getIdCobertura()
				+", EstadoPaciente="+ pac.getEstado()+" WHERE DNIPaciente="+pac.getDni();
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
	public boolean borrar(int dni) {
		
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE pacientes SET EstadoPaciente=0 WHERE DNIPaciente="+dni;
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
