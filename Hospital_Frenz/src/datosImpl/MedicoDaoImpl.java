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
			ResultSet rs= cn.query("Select * from medicos INNER JOIN provincias ON medicos.IDProvinciaMed=provincias.id "
				 		+ "INNER JOIN localidades ON medicos.IDLocalidadMed=localidades.id");
			while(rs.next())
			 {
				Medico med = new Medico();
				Provincia prov = new Provincia();
				Localidad loc = new Localidad();
				 
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
	public Medico obtenerUnoDni(int dni) {
		cn = new Conexion();
		cn.Open();
		Medico med = new Medico();
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		
		try
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN provincias ON medicos.IDProvinciaMed=provincias.id "
				 		+ "INNER JOIN localidades ON medicos.IDLocalidadMed=localidades.id WHERE medicos.DNIMed="+dni);
		
			med.setDni(rs.getInt("medicos.DNIMed"));
			med.setMatricula(rs.getInt("medicos.MatriculaMed"));
			med.setNombre(rs.getString("medicos.NombreMed"));
			med.setApellido(rs.getString("medicos.ApellidosMed"));
			med.setTelefono(rs.getInt("medicos.TelefonoMed"));
			med.setDireccion(rs.getString("medicos.DireccionMed"));
			 
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

	@Override
	public Medico obtenerUnoMat(int mat) {
		cn = new Conexion();
		cn.Open();
		Medico med = new Medico();
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		
		try
		{
			ResultSet rs= cn.query("Select * from medicos INNER JOIN provincias ON medicos.IDProvinciaMed=provincias.id "
				 		+ "INNER JOIN localidades ON medicos.IDLocalidadMed=localidades.id WHERE medicos.MatriculaMed="+mat);
		
			med.setDni(rs.getInt("medicos.DNIMed"));
			med.setMatricula(rs.getInt("medicos.MatriculaMed"));
			med.setNombre(rs.getString("medicos.NombreMed"));
			med.setApellido(rs.getString("medicos.ApellidosMed"));
			med.setTelefono(rs.getInt("medicos.TelefonoMed"));
			med.setDireccion(rs.getString("medicos.DireccionMed"));
			 
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

	@Override
	public boolean insertar(Medico med) {
		
		boolean estado = true;
		
		cn = new Conexion();
		cn.Open();
		
		String query = "INSERT INTO medicos (DNIMed, MatriculaMed, NombreMed, ApellidosMed, DireccionMed, IDLocalidadMed," + 
				" IDProvinciaMed, TelefonoMed, EstadoMed) VALUES ("+med.getDni()+", "+med.getMatricula()+", '"+med.getNombre()+"', '"+
				med.getApellido()+"', '"+med.getDireccion()+"', "+med.getLocalidad().getId()+", "+med.getProvincia().getId()+", "+
				med.getTelefono()+", "+med.getEstado()+")";
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
				med.getDireccion()+"', IDLocalidad="+ med.getLocalidad().getId()+", IDProvincia="+ med.getProvincia().getId()+
				", TelefonoMed="+med.getTelefono()+", EstadoMed="+med.getEstado()+" WHERE DNIMed="+med.getDni();
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
		String query = "UPDATE medicos SET EstadoMed=0 WHERE DNIMed="+dni;
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
