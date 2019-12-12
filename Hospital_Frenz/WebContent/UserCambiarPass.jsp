<%@page import="entidad.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="Master_User.html" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cambiar Contraseña | Hospital Frenz</title>
</head>
<body>

<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>

<%
		Usuario u;
		u= (Usuario) request.getAttribute("userDat");
	%>


<form method="post" action="ServletUsuarios">
<div class="containerDat" >
<h5>Datos de contacto</h5><br>
<label style="width:160px">Contraseña actual:</label><input type="password" name=txtCel value="" required><br>
<label style="width:160px">Nueva contraseña:</label><input type="password" name=txtEmail value="" required><br>
<label style="width:160px">Repita nueva contraseña:</label><input type="password" name=txtEmail value="" required><br>

<input type="submit" class="btn btn-primary" name="btnActualizarDatPac-1" value="Actualizar">
</div>
</form>


</body>
</html>