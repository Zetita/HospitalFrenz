<%@page import="entidad.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="Master_Medico.html" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cambiar Contraseña | Hospital Frenz</title>
</head>
<body>

<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>


<form method="post" action="ServletUsuarios">
<div class="containerDat" >
<h5>Cambiar contraseña</h5><br>
	<label style="width:190px;display: inline-block;">Contraseña actual:</label>
	<input style="border-radius: 10px;" type="password" name=txtPassVieja value="" required><br><br>

	<label style="width:190px;display: inline-block;">Nueva contraseña:</label>
	<input style="border-radius: 10px;" type="password" name=txtPassNueva1 value="" required><br><br>

	<label style="width:190px;display: inline-block;">Repita nueva contraseña:</label>
	<input style="border-radius: 10px;" type="password" name=txtPassNueva2 value="" required><br><br>
<span style="color:green"><%=(request.getAttribute("bienMessage") == null) ? ""
 : request.getAttribute("bienMessage")%></span>
 <span style="color:red"><%=(request.getAttribute("errorMessage1") == null) ? ""
 : request.getAttribute("errorMessage1")%></span><br>
<input type="submit" class="btn btn-primary" name="btnActualizarPassM" value="Actualizar">
</div>
</form>


</body>
</html>