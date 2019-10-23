package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Cobertura;

public class CoberturaDaoImpl {
	
	private Conexion cn;
	
	public List<Cobertura> obtenerTodas() {
		cn = new Conexion();
		cn.Open();
		 List<Cobertura> list = new ArrayList<Cobertura>();
		 try
		 {
			 ResultSet rs= cn.query("Select * from Coberturas");
			 while(rs.next())
			 {
				 Cobertura cob = new Cobertura();
				 cob.setIdCobertura(rs.getInt("Coberturas.IDCobertura"));
				 cob.setNombre(rs.getString("Coberturas.NombreCobertura"));
				 cob.setTipo(rs.getString("Coberturas.TipoCobertura"));
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
	public Cobertura obtenerUna(int id) {
		cn = new Conexion();
		cn.Open();
		Cobertura cob = new Cobertura();
		 try
		 {
			 ResultSet rs= cn.query("Select * from Coberturas where IDCobertura="+id);
			 cob.setIdCobertura(rs.getInt("Coberturas.IDCobertura"));
			 cob.setNombre(rs.getString("Coberturas.NombreCobertura"));
			 cob.setTipo(rs.getString("Coberturas.TipoCobertura"));
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
	public boolean insertar(Cobertura cob) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO Coberturas (IDCobertura, NombreCobertura, TipoCobertura) VALUES ('"
				+cob.getIdCobertura()+"', '"+cob.getNombre()+"', '"+cob.getTipo()+"')";
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
