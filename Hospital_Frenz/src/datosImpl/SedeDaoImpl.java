package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.SedeDao;
import entidad.Localidad;
import entidad.Provincia;
import entidad.Sede;

public class SedeDaoImpl implements SedeDao {

	private Conexion cn;
	
	@Override
	public List<Sede> obtenerTodas() {
		cn = new Conexion();
		cn.Open();
		List<Sede> list = new ArrayList<Sede>();
		try
		{
			ResultSet rs= cn.query("Select * from sedes INNER JOIN localidades ON sedes.IDLocalidad=localidades.id"
					+ "INNER JOIN provincias ON localidad.provincia_id=provincias.id");
			while(rs.next())
			{
				Sede sede = new Sede();
				Provincia prov = new Provincia();
				Localidad loc = new Localidad();
				 
				sede.setId(rs.getInt("sedes.IDSede"));
				sede.setNombre(rs.getString("sedes.NombreSede"));
				sede.setDireccion(rs.getString("sedes.DireccionSede"));
				
				prov.setId(rs.getInt("provincias.id"));
				prov.setNombre(rs.getString("provincias.nombre"));
				prov.setCodigo31662(rs.getString("provincias.codigo31662"));
				 
				loc.setId(rs.getInt("localidades.id"));
				loc.setNombre(rs.getString("localidades.nombre"));
				loc.setCp(rs.getInt("localidades.codigopostal"));
				loc.setProvincia(prov);
				
				sede.setProvincia(prov);
				sede.setLocalidad(loc);
				sede.setEstado(rs.getInt("sedes.Estado"));
				 
				list.add(sede);
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
	public Sede obtenerUna(int id) {
		cn = new Conexion();
		cn.Open();
		Sede sede = new Sede();
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		try
		{
			ResultSet rs= cn.query("Select * from sedes INNER JOIN localidades ON sedes.IDLocalidad=localidades.id"
					+ "INNER JOIN provincias ON localidad.provincia_id=provincias.id WHERE IDSede="+id);
			 
			sede.setId(rs.getInt("sedes.IDSede"));
			sede.setNombre(rs.getString("sedes.NombreSede"));
			sede.setDireccion(rs.getString("sedes.DireccionSede"));
			
			prov.setId(rs.getInt("provincias.id"));
			prov.setNombre(rs.getString("provincias.nombre"));
			prov.setCodigo31662(rs.getString("provincias.codigo31662"));
			 
			loc.setId(rs.getInt("localidades.id"));
			loc.setNombre(rs.getString("localidades.nombre"));
			loc.setCp(rs.getInt("localidades.codigopostal"));
			loc.setProvincia(prov);
			
			sede.setProvincia(prov);
			sede.setLocalidad(loc);
			sede.setEstado(rs.getInt("sedes.Estado"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return sede;
	}

	@Override
	public boolean insertar(Sede sede) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO sedes (IDSede, NombreSede, DireccionSede, IDLocalidad, Estado)" + " VALUES ("
		+sede.getId()+", '"+sede.getNombre()+"', '"+sede.getDireccion()+"', "+sede.getLocalidad().getId()+", "+sede.getEstado()+")";
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
	public boolean editar(Sede sede) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE sedes SET NombreSede='"+sede.getNombre()+"', DireccionSede='"+sede.getDireccion()
				+ "', IDLocalidad="+sede.getLocalidad().getId() + " WHERE IDSede="+sede.getId();
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
	public boolean borrar(int id) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE sedes SET Estado=0 WHERE IDSede="+id;
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
