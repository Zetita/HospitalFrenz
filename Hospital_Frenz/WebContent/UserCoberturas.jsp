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
<div class="cardCob">

	<img src="https://c.pxhere.com/images/3d/2a/f63e6744866c8fa2ea7e935514c3-1434047.jpg!d">
	<div class="cardCob-data">
	<h5>Cobertura wawa</h5>
	<h3>Beneficios:</h3>
	<label>los b e n e f i c i o s .........................................................hfuhfhsfhf</label><br>
	</div>
</div>
<div class="cardCob">
	<img src="https://c.pxhere.com/images/3d/2a/f63e6744866c8fa2ea7e935514c3-1434047.jpg!d">
	<h5>Cobertura wawa</h5><br>
	<label>Beneficios:</label>los b e n e f i c i o s ....<br>
</div>

</body>
</html>