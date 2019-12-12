package datosImpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import datos.MedicosPorSedeDao;
import entidad.Localidad;
import entidad.Medico;
import entidad.MedicosPorSede;
import negocio.LocalidadNeg;
import negocioImpl.LocalidadNegImpl;
import entidad.Sede;

public class MedicosPorSedeDaoImpl implements MedicosPorSedeDao {
	
	Conexion cn;
	
	
	@Override
	public List<MedicosPorSede> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		List<MedicosPorSede> list = new ArrayList<MedicosPorSede>();
		try
		{
			ResultSet rs= cn.query("Select * from medxsed");
			while(rs.next())
			 {
				Medico med = new Medico();
				Sede sed = new Sede();
				MedicosPorSede medxsed = new MedicosPorSede();
				med.setMatricula(rs.getString("medxsed.IDMatriculaMed"));
				sed.setId(rs.getInt("medxsed.IDSede"));
				medxsed.setEstado(rs.getInt("medxsed.EstadoMedxSed"));
				
				medxsed.setMedico(med);
				medxsed.setSede(sed);
				
				
				list.add(medxsed); 	
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
	public MedicosPorSede obtenerUno(MedicosPorSede med) {
		
		cn = new Conexion();
		cn.Open();
		Medico med1 = new Medico();
		Sede sede1 = new Sede();
		MedicosPorSede medxsed = new MedicosPorSede();
		try
		{
			ResultSet rs= cn.query("Select * from medxsed WHERE medxsed.IDMatriculaMed = " + (String)med.getMedico().getMatricula() + " AND medxsed.IDSede = " + med.getSede().getId());
			while(rs.next())
			 {
				
				med1.setMatricula(rs.getString("medxsed.IDMatriculaMed"));
				sede1.setId(rs.getInt("medxsed.IDSede"));
				
				medxsed.setMedico(med1);
				medxsed.setSede(sede1);
				medxsed.setEstado(rs.getInt("medxsed.EstadoMedxSed"));
				 	
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
		return medxsed;
		
	}

	@Override
	public boolean insertar(MedicosPorSede med) {
		boolean estado = true;
		
		cn = new Conexion();
		cn.Open();
		
	
		
		String query = "INSERT INTO medxsed (IDSede, IDMatriculaMed, EstadoMedxSed)"
				+ " VALUES ('"+ med.getSede().getId() + "','"+med.getMedico().getMatricula() + "','"+med.getEstado() +"')";
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

	@Override
	public boolean editar(MedicosPorSede med) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE medxsed SET IDSede='"+med.getSede().getId()+ "', IDMatriculaMed='"+med.getMedico().getMatricula()+"', EstadoMedxSed='"+ med.getEstado() +"'";
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
	public boolean borrar(int IdSede, String matricula) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE medxsed SET EstadoMedxSed=0 WHERE IDSede='"+IdSede+"' AND IDMatriculaMed = '" + matricula + "'";
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
