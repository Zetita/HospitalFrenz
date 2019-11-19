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

import entidad.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletUsuarios
 */
@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg user=new UsuarioNegImpl();
	
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
							lst=user.listarUsuarios();
							request.setAttribute("ListaUsers", lst);
						}
					}
				}
				else {
					try {
					lst=user.listarUsuarios();
					request.setAttribute("ListaUsers", lst);
					}
					catch(Exception e){
						
					}
				}
			case "userPac":
			{
				
				UsuarioNeg userNeg = new UsuarioNegImpl();
				request.setAttribute("paciente", userNeg.buscarPaciente(request.getParameter("usuario")));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatos.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "userMed":
			{
				
				UsuarioNeg userNeg = new UsuarioNegImpl();
				request.setAttribute("medico", userNeg.buscarMedico(request.getParameter("usuario")));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatos.jsp");
				dispatcher.forward(request, response);
				break;
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
			UsuarioNeg userNeg = new UsuarioNegImpl();
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
			UsuarioNeg negUser = new UsuarioNegImpl();
			String user = request.getParameter("txtUserLI").toString();
			String pass = request.getParameter("txtPassLI").toString();
			
			Usuario u = (Usuario)negUser.ingresar(user, pass);
			System.out.println(u);
			if(u.getUsuario()!=null)
			{
				System.out.println("pruebita "+ user+"+"+pass);
				
				response.sendRedirect("UserDatos.jsp");
			}
			else
			{
				System.out.println("nopruebita");
                request.setAttribute("errorMessage", "Invalid user or password");
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
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
		user.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
		user.setEstado(true);
		if(request.getParameter("Tipo").equals("med")) user.setTipo("Medico");
		else if (request.getParameter("Tipo").equals("pac")) user.setTipo("Paciente");
		else if (request.getParameter("Tipo").equals("adm")) user.setTipo("Administrador");
		
		return user;
	}

}
