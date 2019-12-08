<%@page import="entidad.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="Master_User.html" />
<title>Mis datos | Hospital Frenz</title>
</head>
<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>
<br>
<%
		Paciente pac= new Paciente();
		if(request.getAttribute("paciente")!=null)
		{
			pac= (Paciente) request.getAttribute("paciente");
		}
		Usuario u= new Usuario();
		u= (Usuario)request.getAttribute("usuarioiniciado");
		request.setAttribute("usuario_", u.getUsuario());
	%>
<div class="container">
<h5>Datos Personales</h5><br>
<label>Numero de Documento:</label><%= pac.getDni() %><br>
<label>Nombre:</label><%= pac.getNombre() %><br>
<label>Apellido:</label><%= pac.getApellido() %><br>
<label>Fecha De Nacimiento:</label><%= pac.getFecha() %><br>
</div>
<br><br>

<div class="container" >
<h5>Datos de contacto</h5><br>
<label>Celular:</label> <input type=tel name=txtCel placeholder="11-1234-5678" value=<%= pac.getTelefono() %> required><br>
<label>Correo-Electronico:</label><input type=email name=txtEmail placeholder="Email@email.com" value=<%= u.getEmail() %> required><br>

<br><br>
</div>

<div class="container">
<h5>Datos de residencia</h5><br>
<label>Provincia:</label><input name=txtProvincia value="<%=pac.getLocalidad().getProvincia().getNombre()%>" type="text"><br>
<label>Localidad:</label><input	name=txtLocalidad value="<%=pac.getLocalidad().getNombre()%>" type="text"><br>
<label>Direccion:</label><input name=txtDireccion value="<%=pac.getDireccion()%>" type="text"><br>
<br><br>
</div>

<div  class="container">
<h5>Tipo de cobertura</h5><br>
<label>Nombre de cobertura:</label><%= pac.getCobertura().getNombre() %><br>
<label>Tipo de cobertura:</label><%= pac.getCobertura().getTipo() %><br>
<div  class=boton><input type=button name=BtnActualizar class="btn btn-primary" value="Actualizar"></div>
</div>

</body>
</html>