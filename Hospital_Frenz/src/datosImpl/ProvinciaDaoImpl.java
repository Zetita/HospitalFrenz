package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

private Conexion cn;
	
	public List<Provincia> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Provincia> list = new ArrayList<Provincia>();
		 try
		 {
			 ResultSet rs= cn.query("Select * from Provincias");
			 while(rs.next())
			 {
				 Provincia prov = new Provincia();
				 prov.setId(rs.getInt("Provincias.id"));
				 prov.setNombre(rs.getString("Provincias.nombre"));
				 prov.setCodigo31662(rs.getString("Provincias.codigo31662"));
				 
				 list.add(prov);
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
	public Provincia obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		Provincia prov = new Provincia();
		 try
		 {
			 ResultSet rs= cn.query("Select * from Provincias where id="+id);
			 prov.setId(rs.getInt("Provincias.id"));
			 prov.setNombre(rs.getString("Provincias.nombre"));
			 prov.setCodigo31662(rs.getString("Provincias.codigo31662"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return prov;
	}
	public boolean insertar(Provincia prov) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO Provincias (id, nombre, codigo31662) VALUES ('"
				+prov.getId()+"', '"+prov.getNombre()+"', '"+prov.getCodigo31662()+"')";
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
