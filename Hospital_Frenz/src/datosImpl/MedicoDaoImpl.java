package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.MedicoDao;
import entidad.Localidad;
import entidad.Medico;
import negocio.LocalidadNeg;
import negocioImpl.LocalidadNegImpl;

public class MedicoDaoImpl implements MedicoDao {

	private Conexion cn;
	
	@Override
	public List<Medico> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		List<Medico> list = new ArrayList<Medico>();
		try
		{
			ResultSet rs= cn.query("Select * from medicos");
			while(rs.next())
			 {
				Medico med = new Medico();
				LocalidadNeg locNeg= new LocalidadNegImpl();
				Localidad loc = new Localidad();
				 
				med.setDni(rs.getString("medicos.DNIMed"));
				med.setMatricula(rs.getString("medicos.MatriculaMed"));
				med.setNombre(rs.getString("medicos.NombreMed"));
				med.setApellido(rs.getString("medicos.ApellidosMed"));
				med.setTelefono(rs.getString("medicos.TelefonoMed"));
				med.setDireccion(rs.getString("medicos.DireccionMed"));
				med.setEstado(rs.getInt("medicos.EstadoMed"));
				
				loc=locNeg.obtenerUna(rs.getInt("medicos.IDLocalidad"));

				med.setLocalidad(loc);
				list.add(med); 	
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
	public Medico obtenerUnoDni(String dni) {
		cn = new Conexion();
		cn.Open();
		Medico med = new Medico();
		LocalidadNeg locNeg= new LocalidadNegImpl();
		Localidad loc = new Localidad();
		
		try
		{
			ResultSet rs= cn.query("Select * from medicos WHERE medicos.DNIMed='"+dni+"'");
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

	@Override
	public Medico obtenerUnoMat(String mat) {
		cn = new Conexion();
		cn.Open();
		Medico med = new Medico();
		Localidad loc = new Localidad();
		LocalidadNeg locNeg= new LocalidadNegImpl();
		
		try
		{
			ResultSet rs= cn.query("Select * from medicos WHERE medicos.MatriculaMed='"+mat+"'");
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

	@Override
	public boolean insertar(Medico med) {
		
		boolean estado = true;
		
		cn = new Conexion();
		cn.Open();
		
		String query = "INSERT INTO medicos (DNIMed, MatriculaMed, NombreMed, ApellidosMed, DireccionMed, IDLocalidad," + 
				" TelefonoMed, EstadoMed) VALUES ('"+med.getDni()+"', '"+med.getMatricula()+"', '"+med.getNombre()+"', '"+
				med.getApellido()+"', '"+med.getDireccion()+"', "+med.getLocalidad().getId()+", '"+med.getTelefono()
				+"', "+med.getEstado()+")";
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
	public boolean editar(Medico med) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE medicos SET NombreMed='"+med.getNombre()+"', ApellidosMed='"+med.getApellido()+"', DireccionMed='"+
				med.getDireccion()+"', IDLocalidad="+ med.getLocalidad().getId()+", TelefonoMed='"+med.getTelefono()
				+"', EstadoMed="+med.getEstado()+" WHERE DNIMed='"+med.getDni()+"'";
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
		String query = "UPDATE medicos SET EstadoMed=0 WHERE DNIMed='"+dni+"'";
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
