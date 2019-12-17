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
<title>Administrar Especialidades</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>


<div class="mitad1" style="width:56%">

<table id="tbEspecialidad" style="width:100%">
			<thead>
			<tr>
				<th colspan="2"></th>
				<th>ID</th>
				<th>Descripción</th>
				<th>Estado</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			List<Especialidad> lst=new ArrayList<Especialidad>();

			  if(request.getAttribute("ListaEspecialidades")!=null)
			  {
				  lst=(ArrayList<Especialidad>)request.getAttribute("ListaEspecialidades");
			  }
			  
			  int indice=1;
			  for(int i=0;i<lst.size();i++){
				  try{
				  %>
				  <form method="post" action="ServletEspecialidad?Indice=<%=indice%>">
				  	<tr>
				  		<td>
				  		<input type="button" id="btnModificar[<%=indice %>]" name="btnModificar[<%=indice %>]" value="Modificar">
				  		</td>
				  		<td><input type="submit" name="btnEliminar[<%=indice %>]" id="btnEliminar[<%=indice %>]" style="font-size:10px"  value="Eliminar"></td>
				  		<td><label id="lblID[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getId()%></label></td>
				  		<td><label id="lblDesc[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getDescripcion() %></label></td>
				  		<td><label id="lblEstado[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getEstado()%></label></td>
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

<br>

<div class="mitad2">
		
	<form method="post" action="ServletEspecialidades">
		
	<b><label>AGREGAR ESPECIALIDAD</label></b><br>
	<br>
	
		<% 
			
			int cant=0;

			  if(request.getAttribute("CantEspecialidades")!=null)
			  {
				  cant=Integer.parseInt(request.getAttribute("CantEspecialidades").toString());
			  }
			  
		%>
		
	<label>ID DE LA ESPECIALIDAD: <%=cant+1%> </label>

	<input type="hidden" value="<%=cant+1%>" name="txtIDEsp">
	
	<br>
	<br>
	
	<label>DESCRIPCIÓN DE LA ESPECIALIDAD:</label>

	<input type="text" name="txtDescEsp">
	
	<br>
	<br>
	
	<input type="Submit" name="btnAgregarEsp" style="width:100%" value="Agregar Especialidad" >
	
	</form>
</div>


</body>
</html>
