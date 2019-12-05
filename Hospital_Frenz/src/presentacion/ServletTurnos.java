package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
import negocio.EspecialidadNeg;
import negocio.TurnoNeg;
import negocioImpl.EspecialidadNegImpl;
import negocioImpl.TurnoNegImpl;

/**
 * Servlet implementation class ServletTurnos
 */
@WebServlet("/ServletTurnos")
public class ServletTurnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Usuario user;
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
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedTurnos.jsp");
				Usuario u= (Usuario) request.getAttribute("usuarioiniciado");
				
				dispatcher.forward(request, response);
				break;
			}
			case "userTurnos":
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserTurnos.jsp");
				dispatcher.forward(request, response);
			}
				break;
			}
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("BtnTurno")!=null)
		{
			request.setAttribute("listaEsp", espNeg.listarEspecialidades());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSolicitud.jsp");
			dispatcher.forward(request, response);
		}
	}

}
