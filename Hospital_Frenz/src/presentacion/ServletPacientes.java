package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Localidad;
import entidad.Paciente;
import negocio.LocalidadNeg;
import negocio.PacienteNeg;
import negocio.ProvinciaNeg;
import negocio.UsuarioNeg;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PacienteNegImpl;
import negocioImpl.ProvinciaNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletPacientes
 */
@WebServlet("/ServletPacientes")
public class ServletPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PacienteNeg negPac = new PacienteNegImpl();
    ProvinciaNeg provNeg= new ProvinciaNegImpl();
    LocalidadNeg locNeg = new LocalidadNegImpl();
    public ServletPacientes() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionIniciada=request.getSession();
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "admin":
			{
				request.setAttribute("listaPacientes", negPac.listarPacientes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "obtenerLoc":
			{
				UsuarioNeg userNeg = new UsuarioNegImpl();
				Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
				String idprov=request.getParameter("comboProv");
				
				
				request.setAttribute("userDat", userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario")));
				request.setAttribute("paciente", pac);
				request.setAttribute("selectedProvincia", idprov );
				request.setAttribute("provincias", provNeg.listarProvinciasConSedes());

				request.setAttribute("localidades", locNeg.listarLocalidadesxProv(Integer.parseInt(idprov)));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatos.jsp");
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
		UsuarioNeg userNeg = new UsuarioNegImpl();
		
		//Para actualizar datos de residencia de paciente
		if(request.getParameter("btnActualizarDatPac-2")!=null) {
			String idL=request.getParameter("comboLoc");
			Localidad loc;
			Paciente pac= userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
			loc=locNeg.obtenerUna(Integer.parseInt(idL));
			pac.setLocalidad(loc);
			pac.setDireccion(request.getParameter("txtDireccion"));
			if(negPac.editar(pac)) {
				request.setAttribute("userDat", userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario")));
				request.setAttribute("paciente", pac);
				request.setAttribute("provincias", provNeg.listarProvincias());
				request.setAttribute("idprov", pac.getLocalidad().getProvincia().getId());
				request.setAttribute("localidades", locNeg.listarLocalidadesxProv(pac.getLocalidad().getProvincia().getId()));
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatos.jsp");
				dispatcher.forward(request, response);
				
			}

		}
	}

}
