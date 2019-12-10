<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="Master_User.html" />
<title>Sedes | Hospital Frenz</title>
</head>

<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>
<%
	List<Provincia> listaProv= new ArrayList<Provincia>();
	if (request.getAttribute("provincias") != null) {
	listaProv = (List<Provincia>) request.getAttribute("provincias");
}
%>
<select name=comboProv onchange="cargarLocalidades()">
	<option value=0>Seleccione Provincia</option>
<%
	for (Provincia p : listaProv) {
%>
	<option value="<%=p.getId()%>"><%=p.getNombre()%></option>
<%
	}
%>

</select>

</body>
</html>