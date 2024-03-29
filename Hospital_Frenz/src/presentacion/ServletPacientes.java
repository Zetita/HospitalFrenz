package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cobertura;
import entidad.Localidad;
import entidad.Paciente;
import entidad.Provincia;
import entidad.Usuario;
import negocio.CoberturaNeg;
import negocio.LocalidadNeg;
import negocio.PacienteNeg;
import negocio.ProvinciaNeg;
import negocio.UsuarioNeg;
import negocioImpl.CoberturaNegImpl;
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
			case "AdminPac":
			{
				CargarListas(request,response);
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
		
		if(request.getParameter("Indice")!=null){
			
			RequestDispatcher dispatcher = null;
			String Indice=request.getParameter("Indice");
			
			if(!request.getParameter("hdnConsulta["+Indice+"]").equals(null)){
				String Consulta=request.getParameter("hdnConsulta["+Indice+"]");

				if(request.getParameter("btnModificar["+Indice+"]")!=null){
					
					negPac.editar(Consulta);
					
					CargarListas(request,response);
				}
				else if(request.getParameter("btnEliminar["+Indice+"]")!=null){
	
					negPac.borrar(Consulta);
					CargarListas(request, response);

				}else if(request.getParameter("btnAlta["+Indice+"]")!=null){
	
					negPac.editar("UPDATE pacientes SET EstadoPaciente=1 WHERE DNIPaciente='"+Consulta+"'");
					CargarListas(request, response);

				}
			}
			dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");	
			dispatcher.forward(request, response);
				
		}
		if(request.getParameter("btnAgregarPac")!=null) 
		{
			Paciente Pac=LlenarPac(request,response);
			Paciente pacExistente=new Paciente();
			PacienteNeg pacNeg=new PacienteNegImpl();
			
			
			if(Pac!=null){
				pacExistente=pacNeg.obtenerUno(Pac.getDni());
			if(Pac.getDni().trim().isEmpty()|| Pac.getNombre().trim().isEmpty() || Pac.getApellido().trim().isEmpty() || 
					Pac.getDireccion().trim().isEmpty() || Pac.getTelefono().trim().isEmpty()) {
				request.setAttribute("errorMessage", "Complete los campos solicitados.");
				
				CargarListas(request,response);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");	
				dispatcher.forward(request, response);
			}

			if(pacNeg.existe("where DNIPaciente='"+Pac.getDni().trim()+"'")) {
				request.setAttribute("errorMessage", "DNI ya esta registrado.");
				
				CargarListas(request,response);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");	
				dispatcher.forward(request, response);
			}
			/*if(pacNeg.existe("where Telefono='"+Pac.getDni().trim()+"'")) {
				request.setAttribute("errorMessage", "Telefono ya esta registrado.");
				
				CargarListas(request,response);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");	
				dispatcher.forward(request, response);
			}*/
			
			
			pacNeg.insertar(Pac);
			} else {	
				ValidarProvincia(request,response);
				CargarAnteriores(request,response);
			}
			CargarListas(request,response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");	
			dispatcher.forward(request, response);
		}
		
		ValidarProvincia(request,response);

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
	
	public Paciente LlenarPac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Paciente Pac=new Paciente();
		Localidad loc=LlenarLocalidad(request,response);
		Cobertura cob=LlenarCobertura(request,response);
		
		Pac.setDni(request.getParameter("txtDNI"));
		Pac.setNombre(request.getParameter("txtNombre"));
		Pac.setApellido(request.getParameter("txtApellido"));
		Pac.setDireccion(request.getParameter("txtDireccion"));
		Pac.setTelefono(request.getParameter("txtTelefono"));
		Pac.setFecha(request.getParameter("txtFechaNac"));
		Pac.setCobertura(cob);
		Pac.setLocalidad(loc);
		
		if(Validar(Pac,request,response)==true) return null;
		return Pac;
	}
	
	
	
	public Localidad LlenarLocalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
		LocalidadNeg locNeg=new LocalidadNegImpl();
		
		return locNeg.obtenerUna(Integer.parseInt(request.getParameter("ddlLocalidad")));
		}
		catch(Exception e) {
			request.setAttribute("Mensaje", "Provincia y/o Localidad incorrecta");
			return null;
		}
	}
	
	public Cobertura LlenarCobertura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CoberturaNeg cobNeg=new CoberturaNegImpl();
		
		return cobNeg.obtenerUna(Integer.parseInt(request.getParameter("ddlCobertura")));
		
	}
	
	public void CargarListas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PacienteNeg pacNeg=new PacienteNegImpl();
		List<Paciente> lst=new ArrayList<Paciente>();
		lst=pacNeg.listarPacientes();
		request.setAttribute("ListaPacientes", lst);
		
		ProvinciaNeg provNeg=new ProvinciaNegImpl();
		List<Provincia> lst2=new ArrayList<Provincia>();
		lst2=provNeg.listarProvincias();
		request.setAttribute("ListaProvincias", lst2);
		
		CoberturaNeg cobNeg=new CoberturaNegImpl();
		List<Cobertura> lst3=new ArrayList<Cobertura>();
		lst3=cobNeg.listarCoberturas();
		request.setAttribute("ListaCoberturas", lst3);
	}

	public void CargarAnteriores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("DNI",(request.getParameter("txtDNI")));
		request.setAttribute("Nombre",(request.getParameter("txtNombre")));
		request.setAttribute("Apellido",(request.getParameter("txtApellido")));
		request.setAttribute("Direccion",(request.getParameter("txtDireccion")));
		request.setAttribute("Telefono",(request.getParameter("txtTelefono")));
		request.setAttribute("Provincia", (request.getParameter("ddlProvincia")));
		request.setAttribute("FechaNac",(request.getParameter("txtFechaNac")));
		request.setAttribute("Cobertura",(request.getParameter("ddlCoberturas")));
		request.setAttribute("Localidad",(request.getParameter("ddlLocalidad")));
	}
	public boolean Validar(Paciente Pac,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Pac.setDni(request.getParameter("txtDNI"));
		Pac.setNombre(request.getParameter("txtNombre"));
		Pac.setApellido(request.getParameter("txtApellido"));
		Pac.setDireccion(request.getParameter("txtDireccion"));
		Pac.setTelefono(request.getParameter("txtTelefono"));
		Pac.setFecha(request.getParameter("txtFechaNac"));

		try {
			if(!Pac.getDni().trim().equals("")&&!Pac.getDni().contains(" ")&&Comprobar(Pac.getDni())){
				if(!Pac.getNombre().trim().equals("")&&!Pattern.compile( "[0-9]" ).matcher( Pac.getNombre() ).find()){
					if(!Pac.getApellido().trim().equals("")&&!Pattern.compile( "[0-9]" ).matcher( Pac.getApellido() ).find()){
						if(!Pac.getDireccion().trim().equals("")){
							if(!Pac.getTelefono().trim().equals("")&&!Pac.getTelefono().contains(" ")&&Comprobar(Pac.getTelefono())){
								if(!Pac.getFecha().trim().equals("")&&!Pac.getFecha().contains(" ")){
									if(request.getParameter("ddlLocalidad")!=null&&!request.getParameter("ddlLocalidad").equals("")){
										if(!request.getParameter("ddlCobertura").equals("")&&request.getParameter("ddlCobertura")!=null){
											request.setAttribute("Mensaje","Paciente agregado correctamente.");
											return false;
										}
										else{
											request.setAttribute("Mensaje","Cobertura del paciente incorrecta.");
											return true;
										}
									}
									else{
										request.setAttribute("Mensaje", "Provincia y/o Localidad incorrecta");
										return true;
									}
								}
								else{
									request.setAttribute("Mensaje","Fecha de Nacimiento del paciente incorrecta.");
									return true;
								}
							}
							else{
								request.setAttribute("Mensaje","Telefono del paciente incorrecto.");
								return true;
							}
						}
						else{
							request.setAttribute("Mensaje","Direccion del paciente incorrecta.");
							return true;
						}
					}
					else{
						request.setAttribute("Mensaje","Apellido del paciente incorrecto.");
						return true;
					}
				}
				else{
					request.setAttribute("Mensaje","Nombre del paciente incorrecto.");
					return true;
				}
			}
			else{
				request.setAttribute("Mensaje","DNI del paciente incorrecto.");
				return true;
			}
		}
		catch(Exception e) {
			request.setAttribute("Mensaje","DNI del paciente incorrecto.");
			return true;
		}
	}
	
	public boolean Comprobar(String Cadena)
	{
		for(int i=0;i<Cadena.length();i++){
			if (!Character.isDigit(Cadena.charAt(i)))
				return false;
			}
		
		return true;
	}
	
	public void ValidarProvincia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
if(request.getParameter("ddlProvincia")!=""&&request.getParameter("ddlProvincia")!=null) {
			
			CargarListas(request,response);
			
			CargarAnteriores(request,response);
			
			LocalidadNeg locNeg=new LocalidadNegImpl();
			
			List<Localidad> lst=new ArrayList<Localidad>();
			
			lst=locNeg.listarLocalidades(Integer.parseInt(request.getParameter("ddlProvincia")));
			
			request.setAttribute("ListaLocalidades", lst);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPacientes.jsp");	
			dispatcher.forward(request, response);
		}
	}
	
}
