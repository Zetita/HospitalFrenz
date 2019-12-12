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
<style>
.blockquote {
    position: relative;
    font-family: 'Montserrat', sans-serif;
    font-weight: 800;
    color: #464866;
    padding: 30px 0;
    width: 100%;
    max-width: 500px;
    z-index: 1;
    margin: 20px auto;
    align-self: center;
    border-top: solid 1px;
    border-bottom: solid 1px;
}

.blockquote h1 {
    position: relative;
    color: #29648a;
    font-size: 40px;
    font-weight: 800;
    line-height: 1;
    margin: 0;
}
.blockquote h4 {
    position: relative;
    color: #292a2b;
    font-size: 1.4rem;
    font-weight: normal;
    line-height: 1;
    margin: 0;
    padding-top: 20px;
    z-index: 1;
}
</style>
<title>Sedes | Hospital Frenz</title>
</head>

<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>
<%
	List<Provincia> listaProv= new ArrayList<Provincia>();
	List<Localidad> listaLoc = new ArrayList<Localidad>();
	List<Sede> listaSedes= new ArrayList<Sede>();
	String idProv="";
	if (request.getAttribute("provincias") != null) {
		listaProv = (List<Provincia>) request.getAttribute("provincias");
	}
	if (request.getAttribute("localidades") != null) {
		listaLoc = (List<Localidad>) request.getAttribute("localidades");	
	}	
		
	if(request.getAttribute("selectedProvincia")!=null){
		idProv= (String) request.getAttribute("selectedProvincia");
	}
	if(request.getAttribute("sedes")!=null){
		listaSedes= (List<Sede>) request.getAttribute("sedes");
	}

%>
<div class="containerDat" style="max-width: 1000px;">
<form name="form1" action="http://localhost:8081/Hospital_Frenz/ServletSedes" method="GET">
<input type=hidden name="Param" value="obtenerLoc">
<select style="margin-right:20px;" name=comboProv onchange="javascript:document.form1.submit();">
	<option value=0>Seleccione Provincia</option>
<%
	for (Provincia p : listaProv) {
%>
	<option 
	<% 	if(listaLoc!=null || listaLoc.size()!=0){ 
	String id=String.valueOf(p.getId());
	
	if(idProv.equals(id)){ 
%>
	selected <% }}%>
	value="<%=p.getId()%>"><%=p.getNombre()%>

	</option>
<%
	}
%>
</select>
</form>
<form method="post" action="ServletSedes">
<%
    if(listaLoc != null || listaLoc.size() != 0){ 
     %>
<select name=comboLoc>
	<option value=0>Seleccione Localidad</option>
<%
	for (Localidad l : listaLoc) {
%>
	<option value="<%=l.getId()%>"><%=l.getNombre()%>
	</option>
<%
	} }
%>
</select>

<input type="submit" class="buttonContratar" style="margin-left: 75%;" name="BtnBuscarSedes" value="Buscar">
</form>
</div>
<br><br>
<div class="containerSedes">
<%if(listaSedes != null || listaSedes.size() != 0){ %>
<%
	for (Sede sede : listaSedes) {
%>
  <div class="blockquote">
    <h1><%=sede.getNombre()%></h1>
    <h4>&mdash;<%=sede.getDireccion()%></h4>
  </div>

<%} }%>

</div>

</body>
</html>