package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.LocalidadNeg;
import negocio.ProvinciaNeg;
import negocio.SedeNeg;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.ProvinciaNegImpl;
import negocioImpl.SedeNegImpl;

/**
 * Servlet implementation class ServletSedes
 */
@WebServlet("/ServletSedes")
public class ServletSedes extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	LocalidadNeg locNeg= new LocalidadNegImpl();
	SedeNeg sedeNeg= new SedeNegImpl();
	ProvinciaNeg provNeg = new ProvinciaNegImpl();

    public ServletSedes() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			switch(opcion) {
			case "userSedes":
			{
				request.setAttribute("provincias", provNeg.listarProvinciasConSedes());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSedes.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "obtenerLoc":
			{
				String idprov=request.getParameter("comboProv");
				request.setAttribute("selectedProvincia", idprov );
				request.setAttribute("provincias", provNeg.listarProvinciasConSedes());

				request.setAttribute("localidades", locNeg.listarLocalidadesxProv(Integer.parseInt(idprov)));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSedes.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:{
				break;
			}
			
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//para listar sedes
		if(request.getParameter("BtnBuscarSedes")!=null) {
			String id=request.getParameter("comboLoc");
			
			request.setAttribute("provincias", provNeg.listarProvinciasConSedes());
			
			request.setAttribute("sedes", sedeNeg.obtenerSedesxLoc(Integer.parseInt(id)));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSedes.jsp");
			dispatcher.forward(request, response);
		}
	}

}
