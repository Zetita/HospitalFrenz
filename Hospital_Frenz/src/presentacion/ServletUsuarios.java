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
import javax.servlet.http.HttpSession;

import entidad.Medico;
import entidad.Paciente;
import entidad.Usuario;
import negocio.LocalidadNeg;
import negocio.MedicoNeg;
import negocio.PacienteNeg;
import negocio.ProvinciaNeg;
import negocio.UsuarioNeg;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.MedicoNegImpl;
import negocioImpl.PacienteNegImpl;
import negocioImpl.ProvinciaNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletUsuarios
 */
@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg userNeg=new UsuarioNegImpl();
	ProvinciaNeg provNeg= new ProvinciaNegImpl();
	LocalidadNeg locNeg= new LocalidadNegImpl();
    public ServletUsuarios() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionIniciada=request.getSession();
		Usuario u;
		
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			List<Usuario> lst=new ArrayList<Usuario>();
			switch (opcion) {
			case "signup":
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/SignUp.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "AdminUsuarios":
			{
				try {
					lst=userNeg.listarUsuarios();
					request.setAttribute("ListaUsers", lst);
					}
				catch(Exception e){
							
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminUsuarios.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "userDatos":
			{	
				Paciente pac=userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
				request.setAttribute("paciente", pac);
				request.setAttribute("userDat", userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario")));
				request.setAttribute("provincias", provNeg.listarProvincias());
				request.setAttribute("localidades", locNeg.listarLocalidadesxProv(pac.getLocalidad().getProvincia().getId()));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatos.jsp");
				dispatcher.forward(request, response);
				
				break;
			}
			case "medDatos":
			{
				request.setAttribute("medico", userNeg.buscarMedico((String)sesionIniciada.getAttribute("usuario")));
				request.setAttribute("userDat", userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario")));
				request.setAttribute("provincias", provNeg.listarProvinciasConSedes());

				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedDatos.jsp");
				dispatcher.forward(request, response);
				
				break;
			}
			
			default:
				break;
			}

		}
		
		//RequestDispatcher rd=request.getRequestDispatcher("/AdminUsuarios.jsp");
		//rd.forward(request, response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesionIniciada=request.getSession();
		
		if(request.getParameter("Indice")!=null){
			
			RequestDispatcher dispatcher = null;
			String Indice=request.getParameter("Indice");
			
			if(!request.getParameter("hdnConsulta["+Indice+"]").equals(null)){
				String Consulta=request.getParameter("hdnConsulta["+Indice+"]");
				

				if(request.getParameter("btnModificar["+Indice+"]")!=null){
					userNeg = new UsuarioNegImpl();

					List<Usuario> lst=new ArrayList<Usuario>();
					userNeg.editar(Consulta);
					lst=userNeg.listarUsuarios();
					request.setAttribute("ListaUsers", lst);

				}
				else if(request.getParameter("btnEliminar["+Indice+"]")!=null){
					userNeg = new UsuarioNegImpl();

					List<Usuario> lst=new ArrayList<Usuario>();
					userNeg.borrar(Consulta);
					lst=userNeg.listarUsuarios();
					request.setAttribute("ListaUsers", lst);

				}
			}
			dispatcher = request.getRequestDispatcher("/AdminUsuarios.jsp");	
			dispatcher.forward(request, response);
				
		}
		
		//Filtro
		if(request.getParameter("btnFiltrar")!=null) {
			userNeg = new UsuarioNegImpl();
			RequestDispatcher dispatcher = null;
			List<Usuario> lst=new ArrayList<Usuario>();
			lst=userNeg.listarUsuarios(request.getParameter("hdnConsulta"));
			request.setAttribute("ListaUsers", lst);
			dispatcher = request.getRequestDispatcher("/AdminUsuarios.jsp");	
			dispatcher.forward(request, response);
		}
		
		
		//admin
		if(request.getParameter("btnAceptar")!=null) {
			Usuario user=LlenarUsuario(request,response);
			List<Usuario> lst=new ArrayList<Usuario>();
			
			if(user!=null){
			
				userNeg.insertar(user);
			}
			
				try {
					lst=userNeg.listarUsuarios();
					request.setAttribute("ListaUsers", lst);
				}
				catch(Exception e){

				}
			
			RequestDispatcher rd=request.getRequestDispatcher("/AdminUsuarios.jsp");
			rd.forward(request,response);
		}
		
		//login
		if(request.getParameter("btnAceptarLI")!=null)
	    {
			RequestDispatcher rd;
			userNeg = new UsuarioNegImpl();
			String user = request.getParameter("txtUserLI").toString();
			String pass = request.getParameter("txtPassLI").toString();
			
			Usuario u = userNeg.ingresar(user, pass);
			if(u.getUsuario()!=null)	
			{
				
				request.setAttribute("userDat", u);			
				sesionIniciada.setAttribute("usuario",u.getUsuario());

				if(u.getTipo().equals("Administrador"))
				{
					rd=request.getRequestDispatcher("AdminTurnos.jsp");		
					rd.forward(request,response);
				}
				else if(u.getTipo().equals("Medico"))
				{			
					request.setAttribute("medico", userNeg.buscarMedico(u.getUsuario()));
					rd=request.getRequestDispatcher("MedDatos.jsp");
					rd.forward(request,response);
				}
				else
				{Paciente pac=userNeg.buscarPaciente(u.getUsuario());
				request.setAttribute("paciente", pac);
				request.setAttribute("provincias", provNeg.listarProvincias());
				request.setAttribute("idprov", pac.getLocalidad().getProvincia().getId());
				request.setAttribute("localidades", locNeg.listarLocalidadesxProv(pac.getLocalidad().getProvincia().getId()));
				
					rd=request.getRequestDispatcher("UserDatos.jsp");	
					rd.forward(request,response);
				}
					
			}
			else
			{
                request.setAttribute("errorMessage", "Usuario y/o contrase�a invalido.");
                rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response); 
			}
			
	    }
		if(request.getParameter("btnLogOff")!=null)
		{
			sesionIniciada.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
		}
		//Para registrarse
		if(request.getParameter("btnAceptarSU")!=null)
		{		
			RequestDispatcher rd;
			Paciente pac= new Paciente();
			Usuario nUser= new Usuario();
			
			PacienteNeg pacNeg= new PacienteNegImpl();
			pac= pacNeg.obtenerUno(request.getParameter("txtDNISU"));
			nUser= userNeg.obtenerUsuario(request.getParameter("txtDNISU"));
			
			if(request.getParameter("txtDNISU").trim().isEmpty() || request.getParameter("txtDNISU").trim().isEmpty()) {
				request.setAttribute("errorMessage2", "Complete los campos.");
                rd = request.getRequestDispatcher("SignUp.jsp");
                rd.forward(request, response); 
			}
			
			if(nUser.getUsuario()!=null) //si existe ya el usuario
			{
				request.setAttribute("errorMessage2", "Paciente ya registrado.");
                rd = request.getRequestDispatcher("SignUp.jsp");
                rd.forward(request, response); 
			}
			if(pacNeg.existe("where DNIPaciente='"+pac.getDni()+"'")) {
				
				nUser.setDNI(request.getParameter("txtDNISU"));
				nUser.setEmail(request.getParameter("txtEmailSU"));
				nUser.setUsuario(request.getParameter("txtUserSU"));
				nUser.setContrasenia(request.getParameter("txtPassSU"));
				nUser.setTipo("Paciente");
				nUser.setEstado(true);
				
				if(userNeg.insertar(nUser))
				{
					request.setAttribute("bienMessage", "Usuario registrado exitosamente.");
	                rd = request.getRequestDispatcher("SignUp.jsp");
	                rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMessage3", "Usuario no pudo registrarse, intentelo denuevo mas tarde.");
	                rd = request.getRequestDispatcher("SignUp.jsp");
	                rd.forward(request, response);
				}		
				
			}else{
				request.setAttribute("errorMessage1", "DNI no pertenece a un paciente.");
				
				rd = request.getRequestDispatcher("SignUp.jsp");
                rd.forward(request, response); 
			}
			
			
		}
		if(request.getParameter("btnActualizarDatPac-1")!=null) {
			Usuario user= new Usuario();
			Paciente pac= new Paciente();
			PacienteNeg pacNeg= new PacienteNegImpl();
			
			user=userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario"));
			pac=userNeg.buscarPaciente((String)sesionIniciada.getAttribute("usuario"));
			pac.setTelefono(request.getParameter("txtCel"));
			user.setEmail(request.getParameter("txtEmail"));
			
			if(userNeg.editar(user) && pacNeg.editar(pac)) {
				request.setAttribute("userDat", user);	
				request.setAttribute("paciente", pac);
				request.setAttribute("provincias", provNeg.listarProvincias());
				request.setAttribute("localidades", locNeg.listarLocalidadesxProv(pac.getLocalidad().getProvincia().getId()));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatos.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(request.getParameter("btnActualizarDatMed-1")!=null) {
			Usuario user= new Usuario();
			Medico med= new Medico();
			MedicoNeg medNeg= new MedicoNegImpl();
			
			user=userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario"));
			med=userNeg.buscarMedico((String)sesionIniciada.getAttribute("usuario"));
			med.setTelefono(request.getParameter("txtTelefono"));
			user.setEmail(request.getParameter("txtEmail"));
			
			if(userNeg.editar(user) && medNeg.editar(med)) {
				request.setAttribute("userDat", user);	
				request.setAttribute("medico", med);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedDatos.jsp");
				dispatcher.forward(request, response);
			}
		}
		//solo redireccionamiento
		if(request.getParameter("BtnActualizarPassword")!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCambiarPass.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("BtnActualizarPasswordM")!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MedCambiarPass.jsp");
			dispatcher.forward(request, response);
		}
		//cambiar contrasenia
		if(request.getParameter("btnActualizarPass")!=null) {
			String passVieja= request.getParameter("txtPassVieja");
			String passNueva1= request.getParameter("txtPassNueva1");
			String passNueva2= request.getParameter("txtPassNueva2");
			
			Usuario user= userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario"));
			String sql="UPDATE usuarios SET ContraseniaUser='"+passNueva1+"' WHERE NombreUser='"+user.getUsuario()+"'";
			
			
			if(passVieja.trim().isEmpty() || passNueva1.trim().isEmpty() || passNueva2.trim().isEmpty()) {
				request.setAttribute("errorMessage1", "Complete los campos.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
			
			if(user.getContrasenia().equals(passVieja)==false) {
				request.setAttribute("errorMessage1", "Contrase�a actual incorrecta");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
			else if(passNueva1.equals(passNueva2)==false) {
				request.setAttribute("errorMessage1", "Contraseñas nuevas no coinciden");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
			else if(passVieja.equals(passNueva1)) {
				request.setAttribute("errorMessage1", "Contraseña debe ser distinta a la actual.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCambiarPass.jsp");
				dispatcher.forward(request, response);
			}	
			else if(userNeg.editar(sql)) {
				request.setAttribute("bienMessage", "Contraseña actualizada correctamente.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(request.getParameter("btnActualizarPassM")!=null) {
			String passVieja= request.getParameter("txtPassVieja");
			String passNueva1= request.getParameter("txtPassNueva1");
			String passNueva2= request.getParameter("txtPassNueva2");
			
			Usuario user= userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario"));
			String sql="UPDATE usuarios SET ContraseniaUser='"+passNueva1+"' WHERE NombreUser='"+user.getUsuario()+"'";
			
			
			if(user.getContrasenia().equals(passVieja)==false) {
				request.setAttribute("errorMessage1", "Contraseña actual incorrecta");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
			else if(passNueva1.equals(passNueva2)==false) {
				request.setAttribute("errorMessage1", "Contraseñas nuevas no coinciden");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
			else if(passVieja.equals(passNueva1)) {
				request.setAttribute("errorMessage1", "Contraseña debe ser distinta a la actual.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedCambiarPass.jsp");
				dispatcher.forward(request, response);
			}	
			else if(userNeg.editar(sql)) {
				request.setAttribute("bienMessage", "Contraseña actualizada correctamente.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MedCambiarPass.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	
	public Usuario LlenarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Usuario user=new Usuario();
		user.setUsuario(request.getParameter("txtNombre"));
		user.setEmail(request.getParameter("txtEmail"));
		user.setContrasenia(request.getParameter("txtContrasenia"));
		user.setDNI(request.getParameter("txtDNI"));
		user.setEstado(true);
		
		if(Validar(user,request,response)) return null;
		
		if(request.getParameter("Tipo").equals("med")) user.setTipo("Medico");
		else if (request.getParameter("Tipo").equals("pac")) user.setTipo("Paciente");
		else if (request.getParameter("Tipo").equals("adm")) user.setTipo("Administrador");
		
		return user;
	}
	
	public boolean Validar(Usuario user,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(!user.getUsuario().trim().equals("")&&!user.getUsuario().contains("")){
			if(!user.getEmail().trim().equals("")&&!user.getEmail().contains("")){
				if(!user.getContrasenia().trim().equals("")&&!user.getContrasenia().contains("")){
					if(Integer.parseInt(user.getDNI())>0){
						return false;
					}
					else{
						request.setAttribute("Mensaje","DNI Incorrecto.");
						return true;
					}
				}
				else{
					request.setAttribute("Mensaje","Contrase�a Incorrecta.");
					return true;
				}
			}
			else
			{
				request.setAttribute("Mensaje","Email Incorrecto.");
				return true;
			}
		}
		else{
			request.setAttribute("Mensaje","Nombre de usuario Incorrecto.");
			return true;
		}
	}

}
