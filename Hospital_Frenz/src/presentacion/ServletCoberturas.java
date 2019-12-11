package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Paciente;
import negocio.CoberturaNeg;
import negocio.PacienteNeg;
import negocio.UsuarioNeg;
import negocioImpl.CoberturaNegImpl;
import negocioImpl.PacienteNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletCoberturas
 */
@WebServlet("/ServletCoberturas")
public class ServletCoberturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    CoberturaNeg cobNeg = new CoberturaNegImpl();
	UsuarioNeg userNeg = new UsuarioNegImpl();
	PacienteNeg pacNeg = new PacienteNegImpl();
	
    public ServletCoberturas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionIniciada=request.getSession();
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "admin":
			{
				request.setAttribute("listaCoberturas", cobNeg.listarCoberturas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminCoberturas.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "user":
			{
				request.setAttribute("listaCob", cobNeg.listarCoberturas());
				request.setAttribute("paciente", userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario")));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCoberturas.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionIniciada=request.getSession();
		if(request.getParameter("BtnContratarCob")!=null)
		{
			int idCob = Integer.parseInt(request.getParameter("idContratarCob"));
			Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
			
			pac.setCobertura(cobNeg.obtenerUna(idCob));
			
			if(pacNeg.editar(pac)) {
				request.setAttribute("listaCob", cobNeg.listarCoberturas());
				request.setAttribute("paciente", userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario")));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCoberturas.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		if(request.getParameter("BtnActualizarCob")!=null) {
			request.setAttribute("listaCob", cobNeg.listarCoberturas());
			request.setAttribute("paciente", userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCoberturas.jsp");
			dispatcher.forward(request, response);
		}
	}

}
