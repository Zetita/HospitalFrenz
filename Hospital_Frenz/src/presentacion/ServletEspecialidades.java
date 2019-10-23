package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EspecialidadNeg;
import negocioImpl.EspecialidadNegImpl;

/**
 * Servlet implementation class ServletEspecialidad
 */
@WebServlet("/ServletEspecialidades")
public class ServletEspecialidades extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EspecialidadNeg negEsp = new EspecialidadNegImpl();
	
    public ServletEspecialidades() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "admin":
			{
				//Se quiere insertar entonces cargo la lista de categorias
				request.setAttribute("listaEspecialidades", negEsp.listarEspecialidades());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminEspecialidad.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
