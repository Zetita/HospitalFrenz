package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.TurnoDao;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Sede;
import entidad.Turno;
import negocio.EspecialidadNeg;
import negocio.MedicoNeg;
import negocio.PacienteNeg;
import negocio.SedeNeg;
import negocioImpl.EspecialidadNegImpl;
import negocioImpl.MedicoNegImpl;
import negocioImpl.PacienteNegImpl;
import negocioImpl.SedeNegImpl;

public class TurnoDaoImpl implements TurnoDao {
	private Conexion cn;
	
	@Override
	public List<Turno> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		List<Turno> list = new ArrayList<Turno>();
		 //chequear esto
		String sql="Select * from turnos";
		 
		try
		{
			ResultSet rs= cn.query(sql);
			while(rs.next())
			{
				Turno tur = new Turno();
		
				tur.setId(rs.getInt("turnos.IDTurno"));
				tur.setFecha(rs.getString("turnos.Fecha"));
				tur.setHora(rs.getTime("turnos.Hora"));
				tur.setEstado(rs.getInt("turnos.Estado"));
				tur.setAsistencia(rs.getInt("turnos.Asistencia"));
				
				//guardo sede
				Sede sede = new Sede();
				SedeNeg sedeNeg= new SedeNegImpl();
				sede= sedeNeg.obtenerUna(rs.getInt("turnos.IDSede"));
				tur.setSede(sede);
				
				//guardo medico
				Medico med= new Medico();
				MedicoNeg medNeg= new MedicoNegImpl();
				med= medNeg.obtenerUnoMat(rs.getString("turnos.IDMatriculaMed"));
				tur.setMedico(med);
				
				//guardo paciente
				Paciente pac= new Paciente();
				PacienteNeg pacNeg= new PacienteNegImpl();
				pac= pacNeg.obtenerUno(rs.getString("tunos.DNIPaciente"));
				tur.setPaciente(pac);
				
				//guardo especialidad
				Especialidad esp= new Especialidad();
				EspecialidadNeg espNeg= new EspecialidadNegImpl();
				esp= espNeg.obtenerUna(rs.getInt("tunos.IDEspecialidad"));
				tur.setEspecialidad(esp);
				
				list.add(tur);
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
	public List<Turno> obtenerPendientes(String OP, String id) {
		cn = new Conexion();
		cn.Open();
		List<Turno> list = new ArrayList<Turno>();
		String sql="Select * from turnos where Estado=0 AND ";
		if(OP.equals("med"))
		{
			sql+="IDMatriculaMed='"+id+"'";
		}
		else
		{
			sql+="DNIPaciente='"+id+"'";
		}
		try
		{
			ResultSet rs= cn.query(sql);
			while(rs.next())
			{
				Turno tur = new Turno();
		
				tur.setId(rs.getInt("turnos.IDTurno"));
				tur.setFecha(rs.getString("turnos.Fecha"));
				tur.setHora(rs.getTime("turnos.Hora"));
				tur.setEstado(rs.getInt("turnos.Estado"));
				tur.setAsistencia(rs.getInt("turnos.Asistencia"));
				
				//guardo sede
				Sede sede = new Sede();
				SedeNeg sedeNeg= new SedeNegImpl();
				sede= sedeNeg.obtenerUna(rs.getInt("turnos.IDSede"));
				tur.setSede(sede);
				
				//guardo medico
				Medico med= new Medico();
				MedicoNeg medNeg= new MedicoNegImpl();
				med= medNeg.obtenerUnoMat(rs.getString("turnos.IDMatriculaMed"));
				tur.setMedico(med);
				
				//guardo paciente
				Paciente pac= new Paciente();
				PacienteNeg pacNeg= new PacienteNegImpl();
				pac= pacNeg.obtenerUno(rs.getString("tunos.DNIPaciente"));
				tur.setPaciente(pac);
				
				//guardo especialidad
				Especialidad esp= new Especialidad();
				EspecialidadNeg espNeg= new EspecialidadNegImpl();
				esp= espNeg.obtenerUna(rs.getInt("tunos.IDEspecialidad"));
				tur.setEspecialidad(esp);
				
				list.add(tur);
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
	public List<Turno> obtenerPasados(String OP, String id) {
		cn = new Conexion();
		cn.Open();
		List<Turno> list = new ArrayList<Turno>();
		
		String sql="Select * from turnos where Estado=-1 AND ";
		if(OP.equals("med"))
		{
			sql+="IDMatriculaMed='"+id+"'";
		}
		else
		{
			sql+="DNIPaciente='"+id+"'";
		}
			
			//chequear esto
			sql+=" ORDER BY IDTurno DESC";
		try
		{
			ResultSet rs= cn.query(sql);
			while(rs.next())
			{
				Turno tur = new Turno();
		
				tur.setId(rs.getInt("turnos.IDTurno"));
				tur.setFecha(rs.getString("turnos.Fecha"));
				tur.setHora(rs.getTime("turnos.Hora"));
				tur.setEstado(rs.getInt("turnos.Estado"));
				tur.setAsistencia(rs.getInt("turnos.Asistencia"));
				
				//guardo sede
				Sede sede = new Sede();
				SedeNeg sedeNeg= new SedeNegImpl();
				sede= sedeNeg.obtenerUna(rs.getInt("turnos.IDSede"));
				tur.setSede(sede);
				
				//guardo medico
				Medico med= new Medico();
				MedicoNeg medNeg= new MedicoNegImpl();
				med= medNeg.obtenerUnoMat(rs.getString("turnos.IDMatriculaMed"));
				tur.setMedico(med);
				
				//guardo paciente
				Paciente pac= new Paciente();
				PacienteNeg pacNeg= new PacienteNegImpl();
				pac= pacNeg.obtenerUno(rs.getString("tunos.DNIPaciente"));
				tur.setPaciente(pac);
				
				//guardo especialidad
				Especialidad esp= new Especialidad();
				EspecialidadNeg espNeg= new EspecialidadNegImpl();
				esp= espNeg.obtenerUna(rs.getInt("tunos.IDEspecialidad"));
				tur.setEspecialidad(esp);
				
				list.add(tur);
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
	public Turno obtenerUno(int idturno, int idsede) {
		cn = new Conexion();
		cn.Open();
		Turno tur= new Turno();
		try
		{
			ResultSet rs= cn.query("select * from turnos WHERE IDTurno"+idturno+" AND IDSede="+idsede);
			rs.next();
			
			tur.setId(rs.getInt("turnos.IDTurno"));
			tur.setFecha(rs.getString("turnos.Fecha"));
			tur.setHora(rs.getTime("turnos.Hora"));
			tur.setEstado(rs.getInt("turnos.Estado"));
			tur.setAsistencia(rs.getInt("turnos.Asistencia"));
			
			//guardo sede
			Sede sede = new Sede();
			SedeNeg sedeNeg= new SedeNegImpl();
			sede= sedeNeg.obtenerUna(rs.getInt("turnos.IDSede"));
			tur.setSede(sede);
			
			//guardo medico
			Medico med= new Medico();
			MedicoNeg medNeg= new MedicoNegImpl();
			med= medNeg.obtenerUnoMat(rs.getString("turnos.IDMatriculaMed"));
			tur.setMedico(med);
			
			//guardo paciente
			Paciente pac= new Paciente();
			PacienteNeg pacNeg= new PacienteNegImpl();
			pac= pacNeg.obtenerUno(rs.getString("tunos.DNIPaciente"));
			tur.setPaciente(pac);
			
			//guardo especialidad
			Especialidad esp= new Especialidad();
			EspecialidadNeg espNeg= new EspecialidadNegImpl();
			esp= espNeg.obtenerUna(rs.getInt("tunos.IDEspecialidad"));
			tur.setEspecialidad(esp);
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return tur;
	}

	@Override
	public boolean insertar(Turno tur) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO turnos (IDTurno, IDSede, IDMatriculaMed, DNIPaciente, Fecha, Hora, IDEspecialidad, Estado,"
				+ " Asistencia) VALUES (" +tur.getId()+", "+tur.getSede().getId()+", '"+tur.getMedico().getMatricula()+"', '"
				+ tur.getPaciente().getDni()+"', '"+ tur.getFecha()+"', "+tur.getHora()+", "+ tur.getEspecialidad().getId()+
				", "+ tur.getEstado() + ", "+tur.getAsistencia()+")";
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
	public boolean editar(Turno tur) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query="UPDATE turnos SET IDMatriculaMed='"+ tur.getMedico().getMatricula()+"', DNIPaciente='"+
				tur.getPaciente().getDni()+"', Fecha WWWW, Hora="+ tur.getHora()+", IDEspecialidad="+
				tur.getEspecialidad().getId() +", Estado="+ tur.getEstado()+", Asistencia="+tur.getAsistencia()+ 
				" WHERE IDTurno="+ tur.getId()+" AND IDSede="+ tur.getSede().getId();
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
	public boolean borrar(int idturno, int idsede) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE turnos SET Estado=0 WHERE IDTurno="+idturno+" AND IDSede="+idsede;
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
