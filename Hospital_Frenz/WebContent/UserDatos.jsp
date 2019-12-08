<%@page import="entidad.*"%>
<%@page import="negocio.*"%>
<%@page import="negocioImpl.*"%>
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
		HttpSession sesionIniciada=request.getSession();
		Paciente pac= new Paciente();
		Usuario u= new Usuario();
		UsuarioNeg userNeg = new UsuarioNegImpl();
		
		if(request.getAttribute("paciente")!=null)
		{
			pac= (Paciente) request.getAttribute("paciente");
		}
			
		u= userNeg.obtenerUsuarioUser((String)sesionIniciada.getAttribute("usuario"));
	%>
<div class="containerDat">
<h5>Datos Personales</h5><br>
<label style="width:190px">Numero de Documento:</label><%= pac.getDni() %><br>
<label style="width:190px">Nombre:</label><%= pac.getNombre() %><br>
<label style="width:190px">Apellido:</label><%= pac.getApellido() %><br>
<label style="width:190px">Fecha De Nacimiento: </label><%= pac.getFecha() %><br>
</div>

<div class="containerDat" >
<h5>Datos de contacto</h5><br>
<label style="width:160px">Celular:</label><input type=tel name=txtCel placeholder="11-1234-5678" value=<%= pac.getTelefono() %> required><br>
<label style="width:160px">Correo-Electronico:</label><input type=email name=txtEmail placeholder="Email@email.com" value=<%= u.getEmail() %> required><br>
</div>

<div class="containerDat">
<h5>Datos de residencia</h5><br>
<label style="width:90px">Provincia:</label><input name=txtProvincia value="<%=pac.getLocalidad().getProvincia().getNombre()%>" type="text"><br>
<label style="width:90px">Localidad:</label><input	name=txtLocalidad value="<%=pac.getLocalidad().getNombre()%>" type="text"><br>
<label style="width:90px">Direccion:</label><input name=txtDireccion value="<%=pac.getDireccion()%>" type="text"><br>
</div>

<div  class="containerDat">
<h5>Tipo de cobertura</h5><br>
<label style="width:170px">Nombre de cobertura:</label><%= pac.getCobertura().getNombre() %><br>
<label style="width:170px">Tipo de cobertura:</label><%= pac.getCobertura().getTipo() %><br>
<div  class=boton><input type=button name=BtnActualizar class="btn btn-primary" value="Actualizar"></div>
</div>

</body>
</html>