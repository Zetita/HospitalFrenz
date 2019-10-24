package presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletUsuarios
 */
@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletUsuarios() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Llega");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Llega");
		/*if(request.getParameter("btnAceptar")!=null) {
			UsuarioNeg userNeg = new UsuarioNegImpl();
			Usuario user=LlenarUsuario(request,response);
			userNeg.insertar(user);
			RequestDispatcher rd=request.getRequestDispatcher("/AdminUsuarios.jsp");
			rd.forward(request,response);
		}*/
	}
	
	public Usuario LlenarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Usuario user=new Usuario();
		user.setUsuario(request.getParameter("txtNombre"));
		user.setEmail(request.getParameter("txtEmail"));
		user.setContrasenia(request.getParameter("txtContrasenia"));
		user.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
		if(request.getParameter("chckAdministrador")=="true") user.setAdmin(true);
		else user.setAdmin(false);
		
		String[] radio= request.getParameterValues("Tipo");
		if(radio[0]=="true") user.setTipo(true);
		else if (radio[1]=="false") user.setTipo(false);
		
		return user;
	}

}
