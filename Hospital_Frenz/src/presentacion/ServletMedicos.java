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

import entidad.Especialidad;
import entidad.EspxMed;
import entidad.Localidad;
import entidad.Medico;
import entidad.Provincia;
import entidad.Usuario;
import negocio.EspecialidadNeg;
import negocio.EspxMedNeg;
import negocio.LocalidadNeg;
import negocio.MedicoNeg;
import negocio.ProvinciaNeg;
import negocioImpl.EspecialidadNegImpl;
import negocioImpl.EspxMedNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.MedicoNegImpl;
import negocioImpl.ProvinciaNegImpl;

/**
 * Servlet implementation class ServletMedicos
 */
@WebServlet("/ServletMedicos")
public class ServletMedicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MedicoNeg negMed = new MedicoNegImpl();
	
    public ServletMedicos() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "AdminMed":
			{
				CargarDDL(request,response);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminMedicos.jsp");	
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(request.getParameter("btnAgregarMed")!=null) {
			Medico med=LlenarMed(request,response);
			MedicoNeg medNeg=new MedicoNegImpl();
			
			
			
			medNeg.insertar(med);
			
			List<Medico> lst=new ArrayList<Medico>();
			
			lst=medNeg.listarMedicos();
			
			request.setAttribute("ListaMed", lst);
			
			CargarDDL(request,response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminMedicos.jsp");	
			dispatcher.forward(request, response);
		}
		else if(request.getParameter("btnAgregarEsp")!=null) {
			EspxMed espxmed=LlenarEspxMed(request,response);
			EspxMedNeg espxmedNeg=new EspxMedNegImpl();
			
			espxmedNeg.insertar(espxmed);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminMedicos.jsp");	
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("ddlProvincia")!="") {
			
			CargarDDL(request,response);
			
			CargarAnteriores(request,response);
			
			LocalidadNeg locNeg=new LocalidadNegImpl();
			
			
			List<Localidad> lst=new ArrayList<Localidad>();
			
			//comento porque se rompe
			//lst=locNeg.listarLocalidades(Integer.parseInt(request.getParameter("ddlProvincia")));
			
			request.setAttribute("ListaLocalidades", lst);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminMedicos.jsp");	
			dispatcher.forward(request, response);
		}
	}
	
	public Medico LlenarMed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Medico med=new Medico();
		Localidad loc=LlenarLocalidad(request,response);
		
		med.setDni(request.getParameter("txtDNI"));
		med.setMatricula(request.getParameter("txtNumeroMatricula"));
		med.setNombre(request.getParameter("txtNombre"));
		med.setApellido(request.getParameter("txtApellido"));
		med.setDireccion(request.getParameter("txtDireccion"));
		med.setTelefono(request.getParameter("txtTelefono"));
		med.setLocalidad(loc);
		
		return med;
	}
	
	public EspxMed LlenarEspxMed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EspxMed espxmed=new EspxMed();
		espxmed.setEstado(1);
		espxmed.setIDEsp(Integer.parseInt(request.getParameter("ddlEspecialidad")));
		espxmed.setMatriculaMed(request.getParameter("ddlMedico"));
		return espxmed;
	}

	public Localidad LlenarLocalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LocalidadNeg locNeg=new LocalidadNegImpl();
		
		return locNeg.obtenerUna(Integer.parseInt(request.getParameter("ddlLocalidad")));
		
	}
	
	public void CargarDDL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		MedicoNeg medNeg=new MedicoNegImpl();
		
		List<Medico> lst=new ArrayList<Medico>();
		
		lst=medNeg.listarMedicos();
		
		request.setAttribute("ListaMed", lst);
		
		List<EspxMed> lst2=new ArrayList<EspxMed>();
		
		EspxMedNeg espxmedNeg=new EspxMedNegImpl();
		
		lst2=espxmedNeg.listarEspxMed();
		
		request.setAttribute("ListaEspxMed", lst2);
		
		ProvinciaNeg provNeg=new ProvinciaNegImpl();
		
		List<Provincia> lst3=new ArrayList<Provincia>();
		
		lst3=provNeg.listarProvincias();
		
		request.setAttribute("ListaProvincias", lst3);
		
		EspecialidadNeg espNeg=new EspecialidadNegImpl();
		
		List<Especialidad> lst4=new ArrayList<Especialidad>();
		
		lst4=espNeg.listarEspecialidades(1);
		
		request.setAttribute("ListaEspecialidades", lst4);
	}
	
	public void CargarAnteriores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("DNI",(request.getParameter("txtDNI")));
		request.setAttribute("NMat",(request.getParameter("txtNumeroMatricula")));
		request.setAttribute("Nombre",(request.getParameter("txtNombre")));
		request.setAttribute("Apellido",(request.getParameter("txtApellido")));
		request.setAttribute("Direccion",(request.getParameter("txtDireccion")));
		request.setAttribute("Telefono",(request.getParameter("txtTelefono")));
		request.setAttribute("Provincia", request.getParameter("ddlProvincia"));
	}
}
