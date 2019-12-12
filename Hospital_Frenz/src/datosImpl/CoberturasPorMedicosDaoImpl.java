package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.CoberturasPorMedicoDAO;
import entidad.Cobertura;
import entidad.CoberturasPorMedicos;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.PacientesPorSede;
import entidad.Sede;
import datosImpl.Conexion;

public class CoberturasPorMedicosDaoImpl implements CoberturasPorMedicoDAO {
	
	Conexion cn;
	
	
	@Override
	public List<CoberturasPorMedicos> obtenerTodasLasCoberturasPorMedico() {
		cn= new Conexion();
		cn.Open();
		List<CoberturasPorMedicos> list = new ArrayList<CoberturasPorMedicos>();
		try
		{
			String query = "Select * from cobxmed";
			ResultSet rs = cn.query(query);
			//System.out.println(query);
			while(rs.next())
			{
				Medico med = new Medico();
				Cobertura cob = new Cobertura();
				CoberturasPorMedicos cobxmed = new CoberturasPorMedicos();
				cobxmed.setMed(med);
				
				med.setMatricula(rs.getString("IDMatriculaMed"));
				cob.setIdCobertura(rs.getInt("IDCobertura"));
				cobxmed.setEstado(rs.getInt("EstadoCobxMed"));
				cobxmed.setMed(med);
				cobxmed.setCob(cob);
				list.add(cobxmed);
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
	public CoberturasPorMedicos obtenerUna(CoberturasPorMedicos cob) {
		
		cn = new Conexion();
		cn.Open(); 
		CoberturasPorMedicos cob1 = new CoberturasPorMedicos();
		try
		 {
			String query = "Select * from cobxmed WHERE IDMatriculaMed = '" + cob.getMed().getMatricula() + "' AND IDCobertura =" + cob.getCob().getIdCobertura()+"";
			//System.out.println(query);
			ResultSet rs= cn.query(query);
			
			 while(rs.next())
			 {
				 Cobertura cobertura = new Cobertura();
				 Medico medico = new Medico();
				 cobertura.setIdCobertura(rs.getInt("IDCobertura"));
				 medico.setMatricula(rs.getString("IDMatriculaMed"));
				 cob1.setCob(cobertura);
				 cob1.setMed(medico);
				 
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
		 return cob1;
	}

	@Override
	public boolean insertar(CoberturasPorMedicos cob) {
		boolean estado=true;
		
		cn = new Conexion();
		cn.Open();
		
		String query="INSERT INTO cobxmed (IDMatriculaMed, IDCobertura, EstadoCobxMed) VALUES ('" + cob.getMed().getMatricula() +"', "+ cob.getCob().getIdCobertura() +", "+cob.getEstado()+")";
		System.out.println(query);
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
	public boolean modificar(CoberturasPorMedicos cob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(CoberturasPorMedicos cob) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE cobxmed SET EstadoCobxMed=0 WHERE IDMatriculaMed='"+ cob.getMed().getMatricula() +"' AND IDCobertura = " + cob.getCob().getIdCobertura() + "";
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
