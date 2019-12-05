<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estiloThomy.css">
<jsp:include page="Master_User.html" />
<meta charset="ISO-8859-1">
<title>Solicitar Turno | Hospital Frenz</title>
</head>
<body>

	<%
		List<Especialidad> listaE = new ArrayList<Especialidad>();
		if (request.getAttribute("listaEsp") != null) {
			listaE = (List<Especialidad>) request.getAttribute("listaEsp");
		}
	%>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div>${usuario}</div></button>
</form>
<form method="post" action="ServletTurnos">

<div style="text-aling:center; margin-left:40%; margin-right:30%;">

<label class=lbl2>Especialidad</label><br><br>
<select name=comboEsp>
	<option value=0>Seleccione Especialidad</option>
<%
	for (Especialidad e : listaE) {
%>
	<option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
<%
	}
%>

</select><br><br> 
<label class=lbl2>Sede</label><br><input type=checkbox><label class=lbl2>Seleccionar todas las sedes</label> <br><select><option value=0>Seleccione Sede</option></select><br><br>
<label class=lbl2>Doctor</label><br><br><select><option value=0>Seleccione Doctor/a</option></select><br><br>
<label class=lbl2>Horario</label><br><br><select><option value=0>Seleccione Horario</option></select><br><br>

<input type=button name=BtnTurno value="Pedir Turno" class="btn btn-primary"><br>

</div>
</form>
</body>
</html>