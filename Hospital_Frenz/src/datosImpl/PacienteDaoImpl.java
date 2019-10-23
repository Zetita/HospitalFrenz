package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.PacienteDao;
import datos.ProvinciaDao;
import entidad.Cobertura;
import entidad.Localidad;
import entidad.Paciente;
import entidad.Provincia;

public class PacienteDaoImpl implements PacienteDao {

	private Conexion cn;
	
	public List<Paciente> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Paciente> list = new ArrayList<Paciente>();
		 try
		 {
			 ResultSet rs= cn.query("Select * from Pacientes");
			 while(rs.next())
			 {
				 
				 Paciente pac = new Paciente();
				 pac.setDni(rs.getInt("Pacientes.DNIPaciente"));
				 pac.setNombre(rs.getString("Pacientes.NombrePaciente"));
				 pac.setApellido(rs.getString("Pacientes.ApellidoPaciente"));
				 pac.setFecha(rs.getString("Pacientes.FechaNacPaciente"));
				 pac.setTelefono(rs.getInt("Pacientes.Telefono"));
				 pac.setDireccion(rs.getString("Pacientes.DireccionPaciente"));
				 
				 /*
				  * private Provincia provincia;
					private Localidad localidad;
					private Cobertura cobertura; 
				  * */
				 pac.setEstado(rs.getBoolean("Pacientes.EstadoPaciente"));
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
	public Paciente obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		 Paciente pac = new Paciente();
		 try
		 {
			 ResultSet rs= cn.query("Select * from Pacientes where DNIPaciente="+id);
			 pac.setDni(rs.getInt("Pacientes.DNIPaciente"));
			 pac.setNombre(rs.getString("Pacientes.NombrePaciente"));
			 pac.setApellido(rs.getString("Pacientes.ApellidoPaciente"));
			 pac.setFecha(rs.getString("Pacientes.FechaNacPaciente"));
			 pac.setTelefono(rs.getInt("Pacientes.Telefono"));
			 pac.setDireccion(rs.getString("Pacientes.DireccionPaciente"));
		
			 /*
			  * private Provincia provincia;
				private Localidad localidad;
				private Cobertura cobertura; 
			  * */
			 pac.setEstado(rs.getBoolean("Pacientes.EstadoPaciente"));
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
	public boolean insertar(Paciente pac) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO Pacientes (DNIPaciente, NombrePaciente, ApellidoPaciente, FechaNacPaciente, Telefono,"
				+ " DireccionPaciente, IDLocalidadPaciente, IDProvinciaPaciente, IDCobertura, EstadoPaciente) VALUES ('"
				+pac.getDni()+"', '"+pac.getNombre()+"', '"+pac.getApellido()+"', '"+pac.getFecha()+"', '"+pac.getTelefono()+
				pac.getDireccion()+"', '"+pac.getLocalidad().getId()+"', '"+pac.getProvincia().getId()+"', '"+ pac.getCobertura().getIdCobertura()
				+"', '"+ pac.getEstado()+"')";
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
