<%@ page import="java.util.*, entidad.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/EstiloAdmin.css">
<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>

<script type="text/javascript" src="javascript/jquery-3.4.1.js"></script>
<script type="text/javascript" src="javascript/FiltroDinamico.js"></script>
<script type="text/javascript" src="javascript/Modificar.js"></script>
<script type="text/javascript" src="javascript/ObtenerFiltro.js"></script>
<script type="text/javascript" src="javascript/ObtenerModificacion.js"></script>
<script type="text/javascript" src="javascript/ObtenerEliminar.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
<script type="text/javascript" src="javascript/IniciarTablas.js"></script>

<jsp:include page="Master_Admin.html" />

<title>Administrar Sedes</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>


<div class="mitad1" style="width:56%">

	<table id="tbSedes" style="width:100%">
			<thead>
			<tr>
				<th colspan="2"></th>
				<th>ID</th>
				<th>Nombre</th>>
				<th>Direccion</th>
				<th>Localidad</th>
				<th>Estado</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			List<Sede> lst3=new ArrayList<Sede>();

			  if(request.getAttribute("ListaSedes")!=null)
			  {
				  lst3=(ArrayList<Sede>)request.getAttribute("ListaSedes");
			  }
			  
			  int indice=1;
			  for(int i=0;i<lst3.size();i++){
				  try{
				  %>
				  <form method="post" action="ServletSedes?Indice=<%=indice%>">
				  	<tr>
				  		<td>
				  		<input type="button" id="btnModificar[<%=indice %>]" name="btnModificar[<%=indice %>]" style="font-size:10px" value="Modificar">
				  		</td>
				  		<td><input type="submit" name="btnEliminar[<%=indice %>]" id="btnEliminar[<%=indice %>]" style="font-size:10px" value="Eliminar"></td>
				  		<td><label id="lblID[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getId()%></label></td>
				  		<td><label id="lblNombre[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getNombre()%></label></td>				  		
				  		<td><label id="lblDireccion[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getDireccion()%></label></td>
				  		<td><label id="lblLocalidad[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getLocalidad().getNombre()%></label></td>
				  		
				  		<td><% if(lst3.get(i).getEstado()==1){%><label id="lblEstado[<%=indice%>]" style="font-size:10px">Habilitado</label>
				  		<%} else { %><label id="lblEstado[<%=indice%>]" style="font-size:10px">Inhabilitado</label><%} %> </td>
				  	</tr>
				  </form>
				  <%
				  indice++;
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
				</tbody>
		</table>
	
</div>

<div class="mitad2">

	<form name="frmAgregar" method="post" action="ServletSedes">
	<b><label>AGREGAR SEDE</label></b><br>
	<br>
	
	<label> ID: </label>

	<%if(request.getAttribute("ID")!=null) 
	{%>
    <input type="number" name="txtID" placeholder="ID" value="<%=request.getAttribute("ID")%>">
	<%}
	else{
	%>
	<input type="number" name="txtID" placeholder="ID">
	<%
	}%>
	
    <br>
    <br>
	
	
	<label> NOMBRE: </label>

	<%if(request.getAttribute("Nombre")!=null) 
	{%>
    <input name="txtNombre" type="text" placeholder="Nombre" style="position:relative;left:30%" value="<%=request.getAttribute("Nombre")%>">
	<%}
	else{
	%>
	<input name="txtNombre" type="text" placeholder="Nombre" style="position:relative;left:30%">
	<%
	}%>
	
    <br>
    <br>
	
	<label> DIRECCION: </label>

	<%if(request.getAttribute("Direccion")!=null) 
	{%>
    <input name="txtDireccion" type="text" placeholder="Calle y numero" style="position:relative;left:25%" value="<%=request.getAttribute("Direccion")%>">
	<%}
	else{
	%>
	<input name="txtDireccion" type="text" placeholder="Calle y numero" style="position:relative;left:25%">
	<%
	}%>
    <br>
    <br>
	
	<label> PROVINCIA: </label>

    <select name="ddlProvincia" style="position:relative;left:25%;width:65%" onchange="javascript:document.frmAgregar.submit();">
    	<option selected="" value=""></option>
    <% 
			
			List<Provincia> lst=new ArrayList<Provincia>();

			  if(request.getAttribute("ListaProvincias")!=null)
			  {
				  lst=(ArrayList<Provincia>)request.getAttribute("ListaProvincias");
			  }
			  
			  for(int i=0;i<lst.size();i++){
				  try{
					  if(request.getAttribute("Provincia")!=null&&i==(Integer.parseInt(request.getAttribute("Provincia").toString()))-1){

						  %>
						  	<option value="<%=lst.get(i).getId()%>" selected="selected"><%=lst.get(i).getNombre() %></option>
						  <%
							  }
					  else{
				  %>
				  	<option value="<%=lst.get(i).getId()%>"><%=lst.get(i).getNombre() %></option>
				  <%
					  }
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
    
    </select>
	
	<br>
	<br>
	
	<label> LOCALIDAD: </label>

    <select name="ddlLocalidad" style="position:relative;left:25%;width:65%">
    
     <% 
			
			List<Localidad> lst2=new ArrayList<Localidad>();

			  if(request.getAttribute("ListaLocalidades")!=null)
			  {
				  lst2=(ArrayList<Localidad>)request.getAttribute("ListaLocalidades");
			  
			  
			  for(int i=0;i<lst2.size();i++){
				  try{
%>
					  	<option value="<%=lst2.get(i).getId()%>"><%=lst2.get(i).getNombre() %></option>
<%
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  }
				%>
    
    </select>
	
	<br>
	<br>
	
	<input type="Submit" name="btnAgregarSede" value="Agregar Sede" >
	</form>
</div>
</html>