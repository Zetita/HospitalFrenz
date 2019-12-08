<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Master_User.html" />
<link rel="stylesheet" href="css/General.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coberturas | Hospital Frenz</title>
</head>

<body>

<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>

<%
		List<Cobertura> listaC = new ArrayList<Cobertura>();
		if (request.getAttribute("listaCob") != null) {
			listaC = (List<Cobertura>) request.getAttribute("listaCob");
		}
%>


</body>
</html>