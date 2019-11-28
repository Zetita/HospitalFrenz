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

import entidad.Paciente;
import entidad.Usuario;
import negocio.PacienteNeg;
import negocio.UsuarioNeg;
import negocioImpl.PacienteNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletUsuarios
 */
@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg userNeg=new UsuarioNegImpl();
	
	public static HttpSession sesionIniciada;
    public ServletUsuarios() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			case "admin":
				if(request.getParameter("Origen")!=null) {
					if(request.getParameter("Origen").equals("1")) 
					{
						if(request.getParameter("Num")!=null) 
						{
							HttpSession sesion=request.getSession();
							sesion.setAttribute("NumPag",request.getParameter("Num"));
							lst=userNeg.listarUsuarios();
							request.setAttribute("ListaUsers", lst);
						}
					}
				}
				else {
					try {
					lst=userNeg.listarUsuarios();
					request.setAttribute("ListaUsers", lst);
					}
					catch(Exception e){
						
					}
				}
			
			default:
				break;
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher("/AdminUsuarios.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//admin
		if(request.getParameter("btnAceptar")!=null) {
			Usuario user=LlenarUsuario(request,response);
			List<Usuario> lst=new ArrayList<Usuario>();
			try {
				lst=userNeg.listarUsuarios();
				request.setAttribute("ListaUsers", lst);
			}
			catch(Exception e){
					
			}
			userNeg.insertar(user);
			RequestDispatcher rd=request.getRequestDispatcher("/AdminUsuarios.jsp");
			rd.forward(request,response);
		}
		
		//login
		if(request.getParameter("btnAceptarLI")!=null)
	    {
			RequestDispatcher rd;
			sesionIniciada=request.getSession();
			userNeg = new UsuarioNegImpl();
			String user = request.getParameter("txtUserLI").toString();
			String pass = request.getParameter("txtPassLI").toString();
			
			Usuario u = userNeg.ingresar(user, pass);
			if(u.getUsuario()!=null)
				
			{
				request.setAttribute("usuario", u.getUsuario());
				request.setAttribute("usuarioiniciado", u);
				
				sesionIniciada.setAttribute("usuario",u.getUsuario());
				if(u.getTipo().equals("adm"))
				{
					rd=request.getRequestDispatcher("AdminTurnos.jsp");
						
				}
				else if(u.getTipo().equals("med"))
				{
					
					request.setAttribute("medico", userNeg.buscarMedico(u.getUsuario()));
					rd=request.getRequestDispatcher("MedDatos.jsp");
					
				}
				else
				{
					request.setAttribute("paciente", userNeg.buscarPaciente(u.getUsuario()));
					rd=request.getRequestDispatcher("UserDatos.jsp");
				}
				rd.forward(request,response);
				
			}
			else
			{
                request.setAttribute("errorMessage", "Usuario y/o contraseña invalido.");
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
		if(request.getParameter("btnAceptarSU")!=null)
		{
			
			
			RequestDispatcher rd;
			Paciente pac= new Paciente();
			Usuario nUser= new Usuario();
			
			PacienteNeg pacNeg= new PacienteNegImpl();
			pac= pacNeg.obtenerUno(request.getParameter("txtDNISU"));
			nUser= userNeg.obtenerUsuario(request.getParameter("txtDNISU"));
			
			if(nUser.getUsuario()!=null) //si existe ya el usuario
			{
				request.setAttribute("errorMessage2", "Paciente ya registrado.");
                rd = request.getRequestDispatcher("SignUp.jsp");
                rd.forward(request, response); 
			}
			if(pac.getDni()!=null) //si el paciente esta en los reg
			{
				nUser.setDNI(request.getParameter("txtDNISU"));
				nUser.setEmail(request.getParameter("txtEmailSU"));
				nUser.setUsuario(request.getParameter("txtUserSU"));
				nUser.setContrasenia(request.getParameter("txtPassSU"));
				nUser.setTipo("pac");
				nUser.setEstado(true);
				
				if(userNeg.insertar(nUser))
				{
					request.setAttribute("bienMessage", "Usuario registrado exitosamente.");
	                rd = request.getRequestDispatcher("SignUp.jsp");
	                rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMessage3", "Usuario no pudo registrarse, intentelo denuevo más tarde.");
	                rd = request.getRequestDispatcher("SignUp.jsp");
	                rd.forward(request, response);
				}
			}
			else
			{
				request.setAttribute("errorMessage2", "DNI no pertenece a un paciente.");
                rd = request.getRequestDispatcher("SignUp.jsp");
                rd.forward(request, response); 
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
		if(request.getParameter("Tipo").equals("med")) user.setTipo("Medico");
		else if (request.getParameter("Tipo").equals("pac")) user.setTipo("Paciente");
		else if (request.getParameter("Tipo").equals("adm")) user.setTipo("Administrador");
		
		return user;
	}

}
