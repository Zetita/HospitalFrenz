package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Sede;
import entidad.Turno;
import entidad.Usuario;
import negocio.EspecialidadNeg;
import negocio.MedicoNeg;
import negocio.PacienteNeg;
import negocio.SedeNeg;
import negocio.TurnoNeg;
import negocio.UsuarioNeg;
import negocioImpl.EspecialidadNegImpl;
import negocioImpl.MedicoNegImpl;
import negocioImpl.PacienteNegImpl;
import negocioImpl.SedeNegImpl;
import negocioImpl.TurnoNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletTurnos
 */
@WebServlet("/ServletTurnos")
public class ServletTurnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsuarioNeg userNeg= new UsuarioNegImpl();
	TurnoNeg turNeg= new TurnoNegImpl();
	EspecialidadNeg espNeg= new EspecialidadNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTurnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionIniciada = request.getSession();
	
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			switch (opcion) {
			/*case "cargarTurno":
			{
				request.setAttribute("listaEsp", espNeg.listarEspecialidades());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSolicitud.jsp");
				dispatcher.forward(request, response);
				break;
			}*/
			case "medTurnos":
			{
				Medico med= userNeg.buscarMedico((String)sesionIniciada.getAttribute("usuario"));
				
				request.setAttribute("listaTurPasadosM", turNeg.obtenerPasados("med", med.getMatricula() ));
				request.setAttribute("listaTurPendientesM", turNeg.obtenerPendientes("med", med.getMatricula()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedTurnos.jsp");			
				dispatcher.forward(request, response);
				break;
			}
			case "userTurnos":
			{
				Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
				
				request.setAttribute("listaTurPasados", turNeg.obtenerPasados("pac", pac.getDni() ));
				request.setAttribute("listaTurPendientes", turNeg.obtenerPendientes("pac", pac.getDni()));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "AdminTurnos":
					CargarListas(request,response);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminTurnos.jsp");
					dispatcher.forward(request, response);
				break;
			}
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionIniciada = request.getSession();
		
		
		if(request.getParameter("BtnTurno")!=null)
		{
			request.setAttribute("listaEsp", espNeg.listarEspecialidades(0));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSolicitud.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("BtnBuscarTur1")!=null) {
			String bus= request.getParameter("txtbuscartur1");
			
			if(bus.trim().isEmpty()) {
				
				Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
				
				request.setAttribute("listaTurPasados", turNeg.obtenerPasados("pac", pac.getDni() ));
				request.setAttribute("listaTurPendientes", turNeg.obtenerPendientes("pac", pac.getDni()));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");
				dispatcher.forward(request, response);
			}else {
			
			
			String consulta="(medicos.ApellidosMed LIKE '" + bus+"%' OR medicos.NombreMed LIKE '"+bus+"%' OR especialidades.DescripcionEspecialidad LIKE '"
			+bus+"%' OR turnos.Fecha LIKE '%"+bus+"%')";
			

			Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
			
			request.setAttribute("listaTurPasados", turNeg.obtenerPasados("pac", pac.getDni(), consulta));
			request.setAttribute("listaTurPendientes", turNeg.obtenerPendientes("pac", pac.getDni(),consulta));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");
			dispatcher.forward(request, response);
			}
		}
		if(request.getParameter("BtnMostrarTodosTur")!=null) {
			Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
			
			request.setAttribute("listaTurPasados", turNeg.obtenerPasados("pac", pac.getDni() ));
			request.setAttribute("listaTurPendientes", turNeg.obtenerPendientes("pac", pac.getDni()));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");
			dispatcher.forward(request, response);
		}
		//Para cuando un paciente le da de baja a un turno
		if(request.getParameter("BtnCancelarxUser")!=null) {
			int idT= Integer.parseInt(request.getParameter("idTurCancelar"));
			int idS= Integer.parseInt(request.getParameter("idSedeCancelar"));
			
			if(turNeg.baja(idT, idS, -2))
			{
				Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
				request.setAttribute("listaTurPasados", turNeg.obtenerPasados("pac", pac.getDni() ));
				request.setAttribute("listaTurPendientes", turNeg.obtenerPendientes("pac", pac.getDni()));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		//Para cuando un medico le da de baja a un turno
		if(request.getParameter("BtnCancelarxMed")!=null)
		{
			int idTM= Integer.parseInt(request.getParameter("idTurCancelarM"));
			int idSM= Integer.parseInt(request.getParameter("idSedeCancelarM"));
			if(turNeg.baja(idTM, idSM, -1))
			{
				Medico med= userNeg.buscarMedico((String)sesionIniciada.getAttribute("usuario"));
				
				request.setAttribute("listaTurPasadosM", turNeg.obtenerPasados("med", med.getMatricula() ));
				request.setAttribute("listaTurPendientesM", turNeg.obtenerPendientes("med", med.getMatricula()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedTurnos.jsp");
				dispatcher.forward(request, response);			
			}
			
		}
		//Para marcar que un paciente asistio al turno
		if(request.getParameter("BtnAsistio")!=null)
		{
			int idTM= Integer.parseInt(request.getParameter("idTurCancelarM"));
			int idSM= Integer.parseInt(request.getParameter("idSedeCancelarM"));
			if(turNeg.cargarAsistencia(idTM, idSM, 1))
			{
				Medico med= userNeg.buscarMedico((String)sesionIniciada.getAttribute("usuario"));
				
				request.setAttribute("listaTurPasadosM", turNeg.obtenerPasados("med", med.getMatricula() ));
				request.setAttribute("listaTurPendientesM", turNeg.obtenerPendientes("med", med.getMatricula()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedTurnos.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		//Para marcar que un paciente no asistio al turno
		if(request.getParameter("BtnAusente")!=null)
		{
			int idTM= Integer.parseInt(request.getParameter("idTurCancelarM"));
			int idSM= Integer.parseInt(request.getParameter("idSedeCancelarM"));
			if(turNeg.cargarAsistencia(idTM, idSM, -1))
			{
				Medico med= userNeg.buscarMedico((String)sesionIniciada.getAttribute("usuario"));
					
				request.setAttribute("listaTurPasadosM", turNeg.obtenerPasados("med", med.getMatricula() ));
				request.setAttribute("listaTurPendientesM", turNeg.obtenerPendientes("med", med.getMatricula()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedTurnos.jsp");
				dispatcher.forward(request, response);
			}
				
		}
		//Filtro
				if(request.getParameter("btnFiltrar")!=null) {
									
					RequestDispatcher dispatcher = null;
					List<Turno> lst= new ArrayList<Turno>();		
					String consulta=request.getParameter("hdnConsulta");
					Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
					System.out.println(consulta);
					//lst=turNeg.obtenerPendientes("pac", pac.getDni(), consulta);
					
					request.setAttribute("listaTurPendientes", lst);
					dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");	
					dispatcher.forward(request, response);
				}
	}
	
	public void CargarListas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EspecialidadNeg espNeg=new EspecialidadNegImpl();
		List<Especialidad> lst4=new ArrayList<Especialidad>();
		lst4=espNeg.listarEspecialidades(1);
		request.setAttribute("ListaEspecialidades", lst4);
		
		MedicoNeg medNeg=new MedicoNegImpl();
		List<Medico> lst=new ArrayList<Medico>();
		lst=medNeg.listarMedicos();
		request.setAttribute("ListaMedicos", lst);
		
		PacienteNeg pacNeg=new PacienteNegImpl();
		List<Paciente> lst2=new ArrayList<Paciente>();
		lst2=pacNeg.listarPacientes();
		request.setAttribute("ListaPacientes", lst2);
		
		SedeNeg sedNeg=new SedeNegImpl();
		List<Sede> lst3=new ArrayList<Sede>();
		lst3=sedNeg.obtenerTodas();
		request.setAttribute("ListaSedes", lst3);
	}

}
