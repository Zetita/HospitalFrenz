package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.CoberturaNeg;
import negocioImpl.CoberturaNegImpl;

/**
 * Servlet implementation class ServletCoberturas
 */
@WebServlet("/ServletCoberturas")
public class ServletCoberturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    CoberturaNeg negCob = new CoberturaNegImpl();
    
    public ServletCoberturas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "admin":
			{
				//Se quiere insertar entonces cargo la lista de categorias
				request.setAttribute("listaCoberturas", negCob.listarCoberturas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminCoberturas.jsp");
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
