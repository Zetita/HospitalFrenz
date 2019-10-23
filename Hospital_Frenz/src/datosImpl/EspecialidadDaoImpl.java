package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.EspecialidadDao;
import entidad.Cobertura;
import entidad.Especialidad;

public class EspecialidadDaoImpl implements EspecialidadDao {

private Conexion cn;
	
	@Override
	public List<Especialidad> obtenerTodas(){
		cn = new Conexion();
		cn.Open();
		List<Especialidad> list = new ArrayList<Especialidad>();
		try
		{
			ResultSet rs = cn.query("Select * from especialidades");
			while(rs.next())
			{
				Especialidad esp = new Especialidad();
				esp.setId(rs.getInt("especialidades.IDEspecialidad"));
				esp.setDescripcion(rs.getString("especialidades.DescripcionEspecialidad"));
				esp.setEstado(rs.getInt("especialidades.EstadoEspecialidad"));
				
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
	@Override
	public Especialidad obtenerUna(int id) {
		cn = new Conexion();
		cn.Open();
		Especialidad esp = new Especialidad();
		try 
		{
			ResultSet rs= cn.query("Select * from especialidades WHERE IDEspecialidad="+id);
			
			esp.setId(rs.getInt("especialidades.IDEspecialidad"));
			esp.setDescripcion(rs.getString("especialidades.DescripcionEspecialidad"));
			esp.setEstado(rs.getInt("especialidades.EstadoEspecialidad"));
			
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
	public boolean insertar(Especialidad esp) {
		
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		
		String query="INSERT INTO especialidades(IDEspecialidad, DescripcionEspecialidad, EstadoEspecialidad) VALUES ("
				+esp.getId()+", '"+esp.getDescripcion()+"', "+esp.getEstado()+")";
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
	public boolean editar(Especialidad esp) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE especialidades SET DescripcionEspecialidad='"+esp.getDescripcion()+"', EstadoEspecialidad="+esp.getEstado()+" WHERE IDCobertura="+esp.getId();
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
		String query = "UPDATE especialidades SET EstadoEspecialidad=0 WHERE IDEspecialidad="+id;
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
