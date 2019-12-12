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

import entidad.Localidad;
import entidad.Provincia;
import entidad.Sede;
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

				//request.setAttribute("localidades", locNeg.listarLocalidadesxProvxSed(Integer.parseInt(idprov)));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSedes.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "AdminSedes":
			{
				
				CargarListas(request,response);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminSedes.jsp");	
				dispatcher.forward(request, response);
			}
			default:{
				break;
			}
			
			}
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAgregarSede")!=null) {
			Sede sede=LlenarSede(request,response);
			SedeNeg sedNeg=new SedeNegImpl();
			
			sedNeg.insertar(sede);
			
			CargarListas(request,response);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminSedes.jsp");
			dispatcher.forward(request, response);
		}
		
if(request.getParameter("ddlProvincia")!=null&&request.getParameter("ddlProvincia")!="") {
			
			CargarListas(request,response);
			CargarAnteriores(request,response);
			LocalidadNeg locNeg=new LocalidadNegImpl();
			List<Localidad> lst=new ArrayList<Localidad>();
			lst=locNeg.listarLocalidades(Integer.parseInt(request.getParameter("ddlProvincia")));
			
			request.setAttribute("ListaLocalidades", lst);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminSedes.jsp");	
			dispatcher.forward(request, response);
		}
		
		//para listar sedes
		if(request.getParameter("BtnBuscarSedes")!=null) {
			String id=request.getParameter("comboLoc");
			
			request.setAttribute("provincias", provNeg.listarProvinciasConSedes());
			
			request.setAttribute("sedes", sedeNeg.obtenerSedesxLoc(Integer.parseInt(id)));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSedes.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public Sede LlenarSede(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sede sede=new Sede();
		System.out.println(request.getParameter("txtID"));
		sede.setId(Integer.parseInt(request.getParameter("txtID")));
		sede.setNombre(request.getParameter("txtNombre"));
		sede.setDireccion(request.getParameter("txtDireccion"));
		sede.setLocalidad(LlenarLocalidad(request,response));
		sede.setEstado(1);
		
		return sede;
	}
	
	public Localidad LlenarLocalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LocalidadNeg locNeg=new LocalidadNegImpl();
		
		return locNeg.obtenerUna(Integer.parseInt(request.getParameter("ddlLocalidad")));
		
	}
	
	public void CargarListas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SedeNeg sedNeg=new SedeNegImpl();
		List<Sede> lst=new ArrayList<Sede>();
		lst=sedNeg.obtenerTodas();
		request.setAttribute("ListaSedes", lst);
		
		ProvinciaNeg provNeg=new ProvinciaNegImpl();
		List<Provincia> lst1=new ArrayList<Provincia>();
		lst1=provNeg.listarProvincias();
		request.setAttribute("ListaProvincias", lst1);
	}
	
	public void CargarAnteriores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ID",(request.getParameter("txtID")));
		request.setAttribute("Nombre",(request.getParameter("txtNombre")));
		request.setAttribute("Direccion",(request.getParameter("txtDireccion")));
		request.setAttribute("Provincia", request.getParameter("ddlProvincia"));
	}
}
