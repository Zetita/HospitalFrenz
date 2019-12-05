package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.PacienteDao;
import entidad.Cobertura;
import entidad.Localidad;
import entidad.Paciente;
import entidad.Provincia;
import negocio.CoberturaNeg;
import negocio.LocalidadNeg;
import negocioImpl.CoberturaNegImpl;
import negocioImpl.LocalidadNegImpl;

public class PacienteDaoImpl implements PacienteDao {

	private Conexion cn;
	
	@Override
	public List<Paciente> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Paciente> list = new ArrayList<Paciente>();
		 try
		 {
			 ResultSet rs= cn.query("Select * from pacientes");
			 while(rs.next())
			 {
				 
				Paciente pac = new Paciente();
				Localidad loc = new Localidad();
				LocalidadNeg locNeg= new LocalidadNegImpl();
				CoberturaNeg cobNeg= new CoberturaNegImpl();
				Cobertura cob= new Cobertura();
				
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
	public Paciente obtenerUno(String dni) {
		
		 cn = new Conexion();
		 cn.Open();
		 Paciente pac = new Paciente();
		 Localidad loc = new Localidad();
		 LocalidadNeg locNeg= new LocalidadNegImpl();
		 Cobertura cob = new Cobertura();
		 CoberturaNeg cobNeg= new CoberturaNegImpl();
		 
		 try
		 {
			ResultSet rs= cn.query("Select * from pacientes WHERE pacientes.DNIPaciente='"+dni+"'");
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
	public boolean insertar(Paciente pac) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO pacientes (DNIPaciente, NombrePaciente, ApellidoPaciente, FechaNacPaciente, Telefono,"
				+ " DireccionPaciente, IDLocalidad, IDCobertura, EstadoPaciente) VALUES ('"+pac.getDni()+"', '"
				+pac.getNombre()+"', '"+pac.getApellido()+"', "+pac.getFecha()+", '"+pac.getTelefono()+"', '"+
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
				+pac.getFecha()+", Telefono='"+pac.getTelefono()+"', DireccionPaciente='"+pac.getDireccion()+"', IDLocalidad="+
				pac.getLocalidad().getId()+", IDCobertura="+pac.getCobertura().getIdCobertura()
				+", EstadoPaciente="+ pac.getEstado()+" WHERE DNIPaciente='"+pac.getDni()+"'";
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
	public boolean borrar(String dni) {
		
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE pacientes SET EstadoPaciente=0 WHERE DNIPaciente='"+dni+"'";
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
