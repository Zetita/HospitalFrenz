package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cobertura;
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
			case "AdminCob":
			{
				CargarListas(request,response);
				
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
		
		if(request.getParameter("btnAgregarCob")!=null) {
			Cobertura cob=LlenarCobertura(request,response);
			CoberturaNeg cobNeg=new CoberturaNegImpl();
			
			if(cob!=null){
				
				cobNeg.insertar(cob);
			}
			CargarListas(request,response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminCoberturas.jsp");
			dispatcher.forward(request, response);
		}
		
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
	
	public Cobertura LlenarCobertura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cobertura cob=new Cobertura();
		try {
		cob.setIdCobertura(Integer.parseInt(request.getParameter("txtIdCobertura")));
		cob.setNombre(request.getParameter("txtNombreCobertura"));
		cob.setTipo(request.getParameter("txtTipoCobertura"));
		cob.setCosto(Double.parseDouble(request.getParameter("txtCostoCobertura")));
		cob.setDescripcion(request.getParameter("txtDescCobertura"));
		}
		catch(Exception e){
			request.setAttribute("Mensaje", "Costo de cobertura incorrecto.");
			return null;
		}
		if(Validar(cob,request,response)==true) return null;
		
		return cob;
	}
	
	public void CargarListas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoberturaNeg cobNeg=new CoberturaNegImpl();
		ArrayList<Cobertura> lst=new ArrayList<Cobertura>();
		lst=cobNeg.listarCoberturas();
		request.setAttribute("ListaCoberturas", lst);
		request.setAttribute("CantCoberturas", lst.size());
	}

	public boolean Validar(Cobertura cob,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(!cob.getNombre().trim().equals("")&&!Pattern.compile( "[0-9]" ).matcher( cob.getNombre() ).find()){
			if(!cob.getTipo().trim().equals("")&&!Pattern.compile( "[0-9]" ).matcher( cob.getTipo() ).find()){
				try {
					if(cob.getCosto()>0){
						if(!cob.getDescripcion().trim().equals("")){
							request.setAttribute("Mensaje","Cobertura creada correctamente.");
							return false;
						}
						else{
							request.setAttribute("Mensaje","Descripcion de cobertura incorrecto.");
							return true;
						}
					}
					else{
						request.setAttribute("Mensaje","Costo de cobertura incorrecto.");
						return true;
					}
				}
				catch(Exception e) {
					request.setAttribute("Mensaje","Costo de cobertura incorrecto.");
					return true;
				}
				
			}
			else{
				request.setAttribute("Mensaje","Tipo de cobertura incorrecto.");
				return true;
			}
		}
		else{
			request.setAttribute("Mensaje","Nombre de cobertura incorrecto.");
			return true;
		}
	}
}
