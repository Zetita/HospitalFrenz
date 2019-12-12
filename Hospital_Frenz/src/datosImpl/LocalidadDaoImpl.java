package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.LocalidadDao;
import entidad.Localidad;
import entidad.Provincia;
import negocio.ProvinciaNeg;
import negocioImpl.ProvinciaNegImpl;

public class LocalidadDaoImpl implements LocalidadDao {
	
	private Conexion cn;
	
	@Override
	public List<Localidad> obtenerTodas(){
		cn = new Conexion();
		cn.Open();
		List<Localidad> list = new ArrayList<Localidad>();
		try
		{
			ResultSet rs = cn.query("Select * from localidades INNER JOIN provincias ON localidades.provincia_id=provincias.id");
			while(rs.next())
			{
				Localidad loc = new Localidad();
				loc.setId(rs.getInt("localidades.id"));
				loc.setNombre(rs.getString("localidades.nombre"));
				loc.setCp(rs.getInt("localidades.codigopostal"));
				
				Provincia prov = new Provincia();
				prov.setId(rs.getInt("provincias.id"));
				prov.setNombre(rs.getString("provincias.nombre"));
				prov.setCodigo31662("provincias.codigo31662");
				loc.setProvincia(prov);
				list.add(loc);
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
	public List<Localidad> obtenerLocxProv(int idProv){
		cn = new Conexion();
		cn.Open();
		List<Localidad> list = new ArrayList<Localidad>();
		try
		{
			ResultSet rs = cn.query("Select * from localidades INNER JOIN provincias ON localidades.provincia_id=provincias.id WHERE localidades.provincia_id="+idProv
					+" AND localidades.nombre<>'' order by localidades.nombre");
			while(rs.next())
			{
				Localidad loc = new Localidad();
				loc.setId(rs.getInt("localidades.id"));
				loc.setNombre(rs.getString("localidades.nombre"));
				loc.setCp(rs.getInt("localidades.codigopostal"));
				
				Provincia prov = new Provincia();
				prov.setId(rs.getInt("provincias.id"));
				prov.setNombre(rs.getString("provincias.nombre"));
				prov.setCodigo31662("provincias.codigo31662");
				loc.setProvincia(prov);
				list.add(loc);
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
	public List<Localidad> obtenerLocxProvxSed(int idProv){
		cn = new Conexion();
		cn.Open();
		List<Localidad> list = new ArrayList<Localidad>();
		try
		{
			ResultSet rs = cn.query("SELECT distinct localidades.id, localidades.provincia_id,localidades.nombre, localidades.codigopostal from "
					+ "localidades INNER JOIN sedes on localidades.id=sedes.IDLocalidad INNER JOIN provincias ON "
					+ "localidades.provincia_id=provincias.id WHERE provincias.id="+idProv+" order by localidades.nombre");
			while(rs.next())
			{
				Localidad loc = new Localidad();
				loc.setId(rs.getInt("localidades.id"));
				loc.setNombre(rs.getString("localidades.nombre"));
				loc.setCp(rs.getInt("localidades.codigopostal"));
				
				Provincia prov = new Provincia();
				ProvinciaNeg provNeg= new ProvinciaNegImpl();
				prov=provNeg.obtenerUna(rs.getInt("localidades.provincia_id"));
				
				loc.setProvincia(prov);
				list.add(loc);
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
	public Localidad obtenerUna(int id) {
		cn = new Conexion();
		cn.Open();
		Localidad loc = new Localidad();
		try 
		{
			ResultSet rs= cn.query("Select * from localidades INNER JOIN provincias ON localidades.provincia_id=provincias.id"
					+ " WHERE localidades.id="+id);
			rs.next();
			
			loc.setId(rs.getInt("localidades.id"));
			loc.setNombre(rs.getString("localidades.nombre"));
			loc.setCp(rs.getInt("localidades.codigopostal"));
			
			Provincia prov = new Provincia();
			prov.setId(rs.getInt("provincias.id"));
			prov.setNombre(rs.getString("provincias.nombre"));
			prov.setCodigo31662("provincias.codigo31662");
			loc.setProvincia(prov);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return loc;
	}
	@Override
	public boolean insertar(Localidad loc) {
		
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		
		String query="INSERT INTO localidades(id, nombre, codigopostal, provincia_id) VALUES ("
				+loc.getId()+", '"+loc.getNombre()+"', "+loc.getCp()+", "+loc.getProvincia().getId()+")";
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
}
