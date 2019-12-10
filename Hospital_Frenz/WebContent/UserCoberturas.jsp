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
		Paciente pac;
		if (request.getAttribute("listaCob") != null) {
			listaC = (List<Cobertura>) request.getAttribute("listaCob");
		}
		pac= (Paciente) request.getAttribute("paciente");
		
%>

<form method="post" action="ServletCoberturas">

<%
    if(listaC == null || listaC.size() == 0){ 
     %>
    <br>
	<h2 style="text-align:center;">No hay informacion para mostrar. </h2>
	<br>
	<% }  else{
		 for (Cobertura cob : listaC) {%>

<div class="cardCob">

	<img src="Recursos/Coberturas/<%=cob.getIdCobertura()%>.jpg">
	<div class="cardCob-data">
	<h5><%= cob.getNombre() %></h5>	<h4>$<%=cob.getCosto() %></h4>
	<h3>Tipo: <%=cob.getTipo() %></h3>
	<h3>Beneficios:</h3>
	<label><%=cob.getDescripcion() %></label>
	</div>
<%   if(cob.getIdCobertura() != pac.getCobertura().getIdCobertura()){%>
	<input type="hidden" name="idContratarCob" value="<%=cob.getIdCobertura()%>">
    <input type="submit" class="buttonContratar" name="BtnContratarCob" value="Contratar">

<%} %>
	<br>
	
</div>
	<% }
 }%>
 <br><br>
</form>
</body>
</html>