package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.EspxMedDao;
import entidad.EspxMed;

public class EspxMedDaoImpl implements EspxMedDao {
private Conexion cn;
	
	@Override
	public List<EspxMed> obtenerTodas(){
		cn = new Conexion();
		cn.Open();
		List<EspxMed> list = new ArrayList<EspxMed>();
		try
		{
			ResultSet rs = cn.query("Select * from espxmed");

			while(rs.next())
			{
				EspxMed esp = new EspxMed();
				esp.setMatriculaMed(rs.getString("espxmed.IDMatriculaMed"));
				esp.setIDEsp(rs.getInt("espxmed.IDEspecialidad"));
				esp.setEstado(rs.getInt("espxmed.EstadoEspxMed"));
				
				list.add(esp);
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
	
	
	
	public EspxMed obtenerUna(String MatMed,int IDEsp) {
		cn = new Conexion();
		cn.Open();
		EspxMed esp = new EspxMed();
		try 
		{
			ResultSet rs= cn.query("Select * from espxMed WHERE IDEspecialidad="+IDEsp+" AND IDMatriculaMed LIKE '"+MatMed+"'");
			rs.next();
			
			esp.setMatriculaMed(rs.getString("espxmed.IDMatriculaMed"));
			esp.setIDEsp(rs.getInt("espxmed.IDEspecialidad"));
			esp.setEstado(rs.getInt("espxmed.EstadoEspxMed"));
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return esp;
	}
	@Override
	public boolean insertar(EspxMed esp) {
		
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		
		String query="INSERT INTO espxMed(IDEspecialidad, IDMatriculaMed, EstadoEspxMed) VALUES ("
				+esp.getIDEsp()+", '"+esp.getMatriculaMed()+"', "+esp.isEstado()+")";
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
	@Override
	public boolean editar(EspxMed esp) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE espxmed SET EstadoEspxMed="+esp.isEstado()+" WHERE IDMatriculaMed LIKE ''"+esp.getMatriculaMed()+"' AND IDEspecialidad="+esp.getIDEsp();
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
	public boolean borrar(EspxMed esp) {
		
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query =  "UPDATE espxmed SET EstadoEspxMed=0 WHERE IDMatriculaMed LIKE ''"+esp.getMatriculaMed()+"' AND IDEspecialidad="+esp.getIDEsp();
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
