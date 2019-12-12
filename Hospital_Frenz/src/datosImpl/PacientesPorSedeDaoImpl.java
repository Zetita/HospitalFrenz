package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.PacientesPorSedeDao;
import entidad.Cobertura;
import entidad.Localidad;
import entidad.Paciente;
import entidad.PacientesPorSede;
import entidad.Provincia;
import entidad.Sede;

public class PacientesPorSedeDaoImpl implements PacientesPorSedeDao {

	
	private Conexion cn;
	
	@Override
	public List<PacientesPorSede> obtenerTodosLosPacientesPorSede() {
		cn = new Conexion();
		cn.Open(); 
		List <PacientesPorSede> list = new ArrayList <PacientesPorSede>();
		try
		 {
			 ResultSet rs= cn.query("Select * from pacxsed");
			 while(rs.next())
			 {
				 
				PacientesPorSede pacxsede = new PacientesPorSede();
				Paciente pac = new Paciente();
				Sede sed = new Sede();
				
				pac.setDni(rs.getString("DNIPaciente"));
				sed.setId(rs.getInt("IDSede"));
				pacxsede.setPac(pac);
				pacxsede.setSede(sed);
				list.add(pacxsede); 		 
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
	public PacientesPorSede obtenerUno(PacientesPorSede pacxsede) {
		cn = new Conexion();
		cn.Open(); 
		PacientesPorSede pacxsede1 = new PacientesPorSede();
		try
		 {
			String query = "Select * from pacxsed WHERE DNIPaciente = '" + pacxsede.getPac().getDni() + "' AND IDSede =" + pacxsede.getSede().getId();
			// System.out.println(query);
			ResultSet rs= cn.query(query);
			
			 while(rs.next())
			 {
				 
				
				Paciente pac = new Paciente();
				Sede sed = new Sede();
				
				pac.setDni(rs.getString("DNIPaciente"));
				sed.setId(rs.getInt("IDSede"));
				pacxsede1.setPac(pac);
				pacxsede1.setSede(sed);
				 		 
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
		 return pacxsede1;
	}

	@Override
	public boolean insertar(PacientesPorSede pacxsede) {
		boolean estado = true;
		
		cn = new Conexion();
		cn.Open();
		
		String query = "INSERT INTO pacxsed (DNIPaciente, IDSede) VALUES ('"+ pacxsede.getPac().getDni() + "','"+ pacxsede.getSede().getId() + "')";
		
		
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
	public boolean modificar(PacientesPorSede pacxsede) {
		return false;	
	}

	@Override
	public boolean borrar(PacientesPorSede pacxsede) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "DELETE FROM pacxsed WHERE IDSede='"+pacxsede.getSede().getId()+"' AND DNIPaciente = '" + pacxsede.getPac().getDni() + "'";
		System.out.println(query);
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
