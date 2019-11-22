package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.CoberturaDao;
import entidad.Cobertura;

public class CoberturaDaoImpl implements CoberturaDao {
	
	private Conexion cn;
	
	@Override
	public List<Cobertura> obtenerTodas() {
		cn = new Conexion();
		cn.Open();
		 List<Cobertura> list = new ArrayList<Cobertura>();
		 try
		 {
			 ResultSet rs= cn.query("Select * from coberturas");
			 while(rs.next())
			 {
				 Cobertura cob = new Cobertura();
				 cob.setIdCobertura(rs.getInt("coberturas.IDCobertura"));
				 cob.setNombre(rs.getString("coberturas.NombreCobertura"));
				 cob.setTipo(rs.getString("coberturas.TipoCobertura"));
				 cob.setCosto(rs.getDouble("coberturas.CostoCobertura"));
				 list.add(cob);
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
	public Cobertura obtenerUna(int id) {
		cn = new Conexion();
		cn.Open();
		Cobertura cob = new Cobertura();
		 try
		 {
			 ResultSet rs= cn.query("Select * from coberturas where IDCobertura="+id);
			 rs.next();
			 
			 cob.setIdCobertura(rs.getInt("coberturas.IDCobertura"));
			 cob.setNombre(rs.getString("coberturas.NombreCobertura"));
			 cob.setTipo(rs.getString("coberturas.TipoCobertura"));
			 cob.setCosto(rs.getDouble("coberturas.CostoCobertura"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return cob;
	}
	@Override
	public boolean insertar(Cobertura cob) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO coberturas (IDCobertura, NombreCobertura, TipoCobertura, CostoCobertura) VALUES ("
				+cob.getIdCobertura()+", '"+cob.getNombre()+"', '"+cob.getTipo()+"', "+ cob.getCosto()+")";
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
	public boolean editar(Cobertura cob) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE coberturas SET NombreCobertura='"+cob.getNombre()+"', TipoCobertura='"+cob.getTipo()+
				"', CostoCobertura="+cob.getCosto()+" WHERE IDCobertura="+cob.getIdCobertura();
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
