package presentacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Especialidad;
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
			case "AdminEsp":
			{
				CargarListas(request,response);
				
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
		if(request.getParameter("btnAgregarEsp")!=null) {
			Especialidad esp=LlenarEspecialidad(request,response);
			EspecialidadNeg espNeg=new EspecialidadNegImpl();
			
			espNeg.insertar(esp);
			
			CargarListas(request,response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminEspecialidad.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public Especialidad LlenarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Especialidad esp=new Especialidad();
		esp.setId(Integer.parseInt(request.getParameter("txtIDEsp")));
		esp.setDescripcion(request.getParameter("txtDescEsp"));
		esp.setEstado(1);
		return esp;
	}
	
	public void CargarListas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EspecialidadNeg espNeg=new EspecialidadNegImpl();
		ArrayList<Especialidad> lst=new ArrayList<Especialidad>();
		
		lst=espNeg.listarEspecialidades(0);
		
		request.setAttribute("ListaEspecialidades", lst);
	}

}
