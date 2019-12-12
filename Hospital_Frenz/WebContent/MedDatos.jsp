<%@page import="entidad.Medico"%>
<%@page import="entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="Master_Medico.html" />
<title>Mis datos | Hospital Frenz</title>
</head>
<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div>${usuario}</div></button>
</form>
<br>

	<%	
	Medico med= new Medico();
	Usuario u= new Usuario();

	med= (Medico) request.getAttribute("medico");
	u= (Usuario)request.getAttribute("userDat");
	%>


<div class="containerDat">
	<h5>Datos Personales</h5><br>
	<label style="width:190px">Numero de Documento:</label><%= med.getDni() %><br>
	<label style="width:190px">Matricula:</label><%= med.getMatricula() %><br>
	<label style="width:190px">Nombre:</label><%= med.getNombre() %><br>
	<label style="width:190px">Apellido:</label><%= med.getApellido() %><br>
</div>

<form method="post" action="ServletUsuarios">
<div class="containerDat" >
<h5>Datos de contacto</h5><br>
<label style="width:160px">Telefono:</label><input type=tel name=txtTelefono value=<%= med.getTelefono() %>><br>
<label style="width:160px">Correo-Electronico:</label><input type=email name=txtEmail value=<%= u.getEmail() %>><br>
<input type="submit" class="btn btn-primary" name="btnActualizarDatMed-1" value="Actualizar">
</div>
</form>

<div class="containerDat" >
	<h5>Datos de residencia</h5><br>
	<label style="width:90px">Provincia:</label><input name=txtProvincia value="<%= med.getLocalidad().getProvincia().getNombre() %>" type="text"><br>
	<label style="width:90px">Localidad:</label><input	name=txtLocalidad value="<%= med.getLocalidad().getNombre() %>" type="text"	><br>
	<label style="width:90px">Direccion:</label><input name=txtDireccion value="<%= med.getDireccion() %>" type="text"><br>
<input type=button name=BtnActualizarMed class="btn btn-primary" value="Actualizar">
</div>


<form method="post" action="ServletUsuarios">
<div  class="containerDat" style="position: absolute;top: 180px;left: 700px;">
<h5>Actualizar contraseña</h5><br><br><br>

<input type=submit name=BtnActualizarPasswordM class="btn btn-primary" style="position:absolute; top: 60px; left: 190px;" value="Actualizar">
</div>
</form>
</body>
</html>