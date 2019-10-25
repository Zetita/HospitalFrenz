package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Horarios;


public class HorariosDaoImpl {
	
	private Conexion cn; 
	
	public List<Horarios> obtenerTodas(){
		cn = new Conexion();
		cn.Open();
		List<Horarios> list = new ArrayList<Horarios>();
		try
		{
			ResultSet rs = cn.query("Select * from horarios");
			while(rs.next())
			{
				Horarios horarios = new Horarios();
				horarios.setIDMatriculaMed(rs.getInt("horarios.IDMatriculaMed"));
				horarios.setHora(rs.getDate("horarios.Hora"));
				horarios.setDia(rs.getString("horarios.Dia"));
				horarios.setIDSede(rs.getInt("horarios.IDSede"));
				horarios.setIDEspecialidad(rs.getInt("horarios.IDEspecialidad"));
				
				list.add(horarios);
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
	
	public List<Horarios> obtenerHorariosPorMedico(int idMatricula) {
		cn = new Conexion();
		cn.Open();
		List<Horarios> list = new ArrayList<Horarios>();
		try 
		{
			ResultSet rs= cn.query("Select * from horarios WHERE IDMatriculaMed=" + idMatricula);
			while(rs.next())
			{
				Horarios horarios= new Horarios();
				horarios.setIDMatriculaMed(rs.getInt("horarios.IDMatriculaMed"));
				horarios.setHora(rs.getDate("horarios.Hora"));
				horarios.setDia(rs.getString("horarios.Dia"));
				horarios.setIDSede(rs.getInt("horarios.IDSede"));
				horarios.setIDEspecialidad(rs.getInt("horarios.IDEspecialidad"));
				list.add(horarios);
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

	public boolean insertar(Horarios hor) {
		
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		
		String query="INSERT INTO horarios(IDMatriculaMed,IDSede,IDEspecialidad,Dia,Hora) VALUES ("
				+hor.getIDMatriculaMed() + ", '" +hor.getIDSede() + "', " + hor.getIDEspecialidad() +", " + hor.getDia() + ", " + hor.getHora() + ")";
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
	
	public boolean modificar (Horarios hor) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE horarios SET IDMatriculaMed=" + hor.getIDMatriculaMed() + " AND IDSede = " + hor.getIDSede() + " AND IDEspecialidad = " + hor.getIDEspecialidad() + " AND Dia = " + hor.getDia() + " AND  Hora = " + hor.getHora();
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
	
	public boolean borrar(int IDMatriculaMed, int IDSede, int IDEspecialidad) {
		
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		

		String query="UPDATE horarios SET horariosEstado=0 WHERE IDMatriculaMed =" + IDMatriculaMed + " AND IDSede=" + IDSede + " AND IDEspecialidad = " + IDEspecialidad;
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
