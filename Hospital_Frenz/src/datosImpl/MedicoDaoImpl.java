package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.MedicoDao;
import entidad.Localidad;
import entidad.Medico;
import entidad.Provincia;

public class MedicoDaoImpl implements MedicoDao {

	private Conexion cn;
	
	@Override
	public List<Medico> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		List<Medico> list = new ArrayList<Medico>();
		try
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN localidades ON medicos.IDLocalidad=localidades.id"
					+"INNER JOIN provincias ON localidades.provincia_id=provincias.id");
			while(rs.next())
			 {
				Medico med = new Medico();
				Provincia prov = new Provincia();
				Localidad loc = new Localidad();
				 
				med.setDni(rs.getString("medicos.DNIMed"));
				med.setMatricula(rs.getString("medicos.MatriculaMed"));
				med.setNombre(rs.getString("medicos.NombreMed"));
				med.setApellido(rs.getString("medicos.ApellidosMed"));
				med.setTelefono(rs.getString("medicos.TelefonoMed"));
				med.setDireccion(rs.getString("medicos.DireccionMed"));
				med.setEstado(rs.getInt("medicos.EstadoMed"));
				 
				prov.setId(rs.getInt("provincias.id"));
				prov.setNombre(rs.getString("provincias.nombre"));
				prov.setCodigo31662(rs.getString("provincias.codigo31662"));
				 
				loc.setId(rs.getInt("localidades.id"));
				loc.setNombre(rs.getString("localidades.nombre"));
				loc.setCp(rs.getInt("localidades.codigopostal"));
				loc.setProvincia(prov);
			
				med.setLocalidad(loc);
				med.setEstado(rs.getInt("medicos.EstadoMed"));
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
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		
		try
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN localidades ON medicos.IDLocalidad=localidades.id"
					+"INNER JOIN provincias ON localidades.provincia_id=provincias.id WHERE medicos.DNIMed='"+dni+"'");
			rs.next();
			
			med.setDni(rs.getString("medicos.DNIMed"));
			med.setMatricula(rs.getString("medicos.MatriculaMed"));
			med.setNombre(rs.getString("medicos.NombreMed"));
			med.setApellido(rs.getString("medicos.ApellidosMed"));
			med.setTelefono(rs.getString("medicos.TelefonoMed"));
			med.setDireccion(rs.getString("medicos.DireccionMed"));
			med.setEstado(rs.getInt("medicos.EstadoMed"));
			 
			prov.setId(rs.getInt("provincias.id"));
			prov.setNombre(rs.getString("provincias.nombre"));
			prov.setCodigo31662(rs.getString("provincias.codigo31662"));
			 
			loc.setId(rs.getInt("localidades.id"));
			loc.setNombre(rs.getString("localidades.nombre"));
			loc.setCp(rs.getInt("localidades.codigopostal"));
			loc.setProvincia(prov);
		
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

	@Override
	public Medico obtenerUnoMat(String mat) {
		cn = new Conexion();
		cn.Open();
		Medico med = new Medico();
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		
		try
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN localidades ON medicos.IDLocalidad=localidades.id"
					+"INNER JOIN provincias ON localidades.provincia_id=provincias.id WHERE medicos.MatriculaMed='"+mat+"'");
			rs.next(); 
			
			med.setDni(rs.getString("medicos.DNIMed"));
			med.setMatricula(rs.getString("medicos.MatriculaMed"));
			med.setNombre(rs.getString("medicos.NombreMed"));
			med.setApellido(rs.getString("medicos.ApellidosMed"));
			med.setTelefono(rs.getString("medicos.TelefonoMed"));
			med.setDireccion(rs.getString("medicos.DireccionMed"));
			med.setEstado(rs.getInt("medicos.EstadoMed"));
			 
			prov.setId(rs.getInt("provincias.id"));
			prov.setNombre(rs.getString("provincias.nombre"));
			prov.setCodigo31662(rs.getString("provincias.codigo31662"));
			 
			loc.setId(rs.getInt("localidades.id"));
			loc.setNombre(rs.getString("localidades.nombre"));
			loc.setCp(rs.getInt("localidades.codigopostal"));
			loc.setProvincia(prov);
		
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

	@Override
	public boolean insertar(Medico med) {
		
		boolean estado = true;
		
		cn = new Conexion();
		cn.Open();
		
		String query = "INSERT INTO medicos (DNIMed, MatriculaMed, NombreMed, ApellidosMed, DireccionMed, IDLocalidad," + 
				" TelefonoMed, EstadoMed) VALUES ('"+med.getDni()+"', '"+med.getMatricula()+"'s, '"+med.getNombre()+"', '"+
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
