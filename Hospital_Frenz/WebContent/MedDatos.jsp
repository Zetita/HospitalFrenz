<%@page import="entidad.Medico"%>
<%@page import="entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estiloThomy.css">
<jsp:include page="Master_Medico.html" />
<title>Mis datos | Hospital Frenz</title>
</head>
<body>

<form method="post" action="ServletUsuarios">

<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div><%=(request.getAttribute("usuario") == null) ? ""
 : request.getAttribute("usuario")%></div></button>

</form>
<br>


<form method="post" action="ServletUsuarios">
	<%
		Medico med= new Medico();
		if(request.getAttribute("medico")!=null)
		{
			med= (Medico) request.getAttribute("medico");
		}
		Usuario u= new Usuario();
		u= (Usuario)request.getAttribute("usuarioiniciado");
	%>
</form>

<div class="container">
<h5>Datos Personales</h5><br>
 
<label>Numero de Documento:</label><%= med.getDni() %><br>

<label>Matricula:</label><%= med.getMatricula() %><br>

<label>Nombre:</label><%= med.getNombre() %><br>

<label>Apellido:</label><%= med.getApellido() %><br>
</div>
<br><br>


<div class="container" >
<h5>Datos de contacto</h5><br>
<label>Telefono:</label> <input type=tel name=txtTelefono value=<%= med.getTelefono() %>><br>
<label>Correo-Electronico:</label><input type=email name=txtEmail value=<%= u.getEmail() %>><br>

<br><br>
</div>

<div class="container" >
<h5>Datos de residencia</h5><br>
<label>Provincia:</label><input name=txtProvincia value=<%= med.getLocalidad().getProvincia().getNombre() %> type="text"><br>
<label>Localidad:</label><input	name=txtLocalidad value=<%= med.getLocalidad().getNombre() %> type="text"	><br>
<label>Direccion:</label><input name=txtDireccion value=<%= med.getDireccion() %> type="text"><br>
<br><br>
</div>

<div  class=boton><input type=button name=BtnActualizarMed class="btn btn-primary" value="Actualizar"></div>

</body>
</html>