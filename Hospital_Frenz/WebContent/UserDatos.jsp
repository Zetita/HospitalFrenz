<%@page import="entidad.*"%>
<%@page import="negocio.*"%>
<%@page import="negocioImpl.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

<%
		Paciente pac;
		Usuario u;
		pac= (Paciente) request.getAttribute("paciente");
		u= (Usuario) request.getAttribute("userDat");
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


<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion" ><div>${usuario}</div></button>
</form>
<br>

<div class="containerDat">
<h5>Datos Personales</h5><br>
<label style="width:190px">Numero de Documento:</label><%= pac.getDni() %><br>
<label style="width:190px">Nombre:</label><%= pac.getNombre() %><br>
<label style="width:190px">Apellido:</label><%= pac.getApellido() %><br>
<label style="width:190px">Fecha De Nacimiento: </label><%= pac.getFecha() %><br>
</div>

<form method="post" action="ServletUsuarios">
<div class="containerDat" >
<h5>Datos de contacto</h5><br>
<label style="width:160px">Celular:</label><input type=tel name=txtCel placeholder="11-1234-5678" value=<%= pac.getTelefono() %> required><br>
<label style="width:160px">Correo-Electronico:</label><input type=email name=txtEmail placeholder="Email@email.com" value=<%= u.getEmail() %> required><br>

<input type="submit" class="btn btn-primary" name="btnActualizarDatPac-1" value="Actualizar">
</div>
</form>


<div class="containerDat">
<h5>Datos de residencia</h5><br>

<form name="form1" action="ServletPacientes" method="GET">
<br>
<input type=hidden name="Param" value="obtenerLoc">
<label style="width:90px">Provincia:</label>
<select style="margin-right:20px;" name=comboProv onchange="javascript:document.form1.submit();">
	<option value=0>Seleccione Provincia</option>
<%
	for (Provincia p : listaProv) {
%>
	<option 
	<% 	if(idProv.equals("")){ 
		if(p.getId()==pac.getLocalidad().getProvincia().getId()){
     %>
	selected <% }}else{
	String id=String.valueOf(p.getId());
	if(idProv.equals(id)){
%>
	selected <% }}	%>
	value="<%=p.getId()%>"><%=p.getNombre()%>

	</option>
<%
	}
%>
</select>
</form>
<br>
<form method="post" action="ServletPacientes">
<br>
<label style="width:90px;position: absolute; top: 715px; left: 264px;">Localidad:</label>
<select style="position:absolute; top: 715px; left: 358px;" name=comboLoc>
	<option value=0>Seleccione Localidad</option>
<%
	for (Localidad l : listaLoc) {
%>
	<option 
<% if(idProv.equals("")){

if(l.getId()==pac.getLocalidad().getId()){
%>
	selected <% }}	%> value="<%=l.getId()%>"><%=l.getNombre()%>
	</option>
<%
	}
%>
</select>
<br><br>
<label style="width:90px;position: absolute; top: 750px; left: 264px;">Direccion:</label>
<input style="position:absolute; top: 750px; left: 358px;" name=txtDireccion value="<%=pac.getDireccion()%>" type="text"><br><br><br><br>
<input style="position:absolute; top: 780px; left: 260px;" type="submit" class="btn btn-primary"  name="btnActualizarDatPac-2" value="Actualizar">
</form>
<br><br>
</div>

<form method="post" action="ServletCoberturas">
<div  class="containerDat" style="position: absolute;top: 180px;left: 700px;">
<h5>Tipo de cobertura</h5><br>
<label style="width:170px;">Nombre de cobertura:</label><%= pac.getCobertura().getNombre() %><br>
<label style="width:170px;">Tipo de cobertura:</label><%= pac.getCobertura().getTipo() %><br>
<input type=submit name=BtnActualizarCob class="btn btn-primary" value="Actualizar">
</div>
</form>

<form method="post" action="ServletUsuarios">
<div  class="containerDat" style="position: absolute;top: 380px;left: 700px;">
<h5>Actualizar contraseña</h5><br><br><br>

<input type=submit name=BtnActualizarPassword class="btn btn-primary" style="position:absolute; top: 60px; left: 190px;" value="Actualizar">
</div>
</form>

<br>
</body>
</html>