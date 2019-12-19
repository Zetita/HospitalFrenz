<%@ page import="java.util.*, entidad.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="Master_Admin.html" />
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

<title>Administrar Turnos</title>
</head>
<body>

<script type="text/javascript">
	document.getElementById("btnLogOff").innerHTML="<div style='height:100%;width:100%'>"+sessionStorage.getItem("NombreUser")+"</div>"; 
</script>




<div class="mitad1" style="width:56%">

	<b><label class=lbl2>LISTAR TURNOS</label><br></b>
	<br>
	<input class=bonito type="Button" name="btnAgregar" value="+" >
	
	<select class=bonito name="ddlFiltro1">
		<option value="Y">Y<option>
	</select>
	
	<select class=bonito name="ddlTipoFiltro">
		<option value="Medico">Medico<option>
	</select>
	
	<select class=bonito name="ddlFiltro2">
		<option value="Es">Contiene<option>
	</select>
	
	<select class=bonito name="ddlFiltro">
		<option value="Mariano Acosta">Mariano Acosta<option>
	</select>

		
<br>
<br>


		
		<table id="TbTurnos">
			<tr>
				<th colspan="2"></th>
				<th>ID del Turno</th>
				<th>Sede</th>
				<th>Matricula del Medico</th>
				<th>DNI Del Paciente</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th>Especialidad</th>
				<th>Estado</th>
			</tr>
			<tr>
				<td><a href="#" name="llbModificar">Modificar</a></td>
				<td><a href="#" name="llbEliminar">Eliminar</a></td>
				<td>1</td>
				<td>Tortuguitas</td>
				<td>321</td>
				<td>42321422</td>
				<td>23/04/2019</td>
				<td>13:30</td>
				<td>Dermatologia</td>
				<td>Cancelado</td>
			</tr>
		</table>
	
</div>

<div class="mitad2">
	<b><label class=lbl2>AGREGAR TURNO</label></b><br>
	<br>
	
	<label class=lbl2>SEDE:</label>
	&nbsp;
	<select class=bonito name="ddlSede">
		<option value=" "> </option>
		<% 
			
			List<Sede> lst3=new ArrayList<Sede>();

			  if(request.getAttribute("ListaSedes")!=null)
			  {
				  lst3=(ArrayList<Sede>)request.getAttribute("ListaSedes");
			  }
			  
			  for(int i=0;i<lst3.size();i++){
				  try{
				  %>
				  	<option value="<%=lst3.get(i).getId()%>">(<%=lst3.get(i).getId()%>) <%=lst3.get(i).getNombre() %></option>
				  <%
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>ESPECIALIDAD:</label>
	&nbsp;
	<select class=bonito name="ddlEspecialidad">
		<option value=" "> </option>
		<% 
			
			List<Especialidad> lst4=new ArrayList<Especialidad>();

			  if(request.getAttribute("ListaEspecialidades")!=null)
			  {
				  lst4=(ArrayList<Especialidad>)request.getAttribute("ListaEspecialidades");
			  }
			  
			  for(int i=0;i<lst4.size();i++){
				  try{
				  %>
				  	<option value="<%=lst4.get(i).getId()%>">(<%=lst4.get(i).getId()%>) <%=lst4.get(i).getDescripcion() %></option>
				  <%
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
    
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>MEDICO:</label>
	&nbsp;
	<select class=bonito name="ddlMedico" >
		<option value=" "> </option>
		 <% 
			
			List<Medico> lst=new ArrayList<Medico>();

			  if(request.getAttribute("ListaMedicos")!=null)
			  {
				  lst=(ArrayList<Medico>)request.getAttribute("ListaMedicos");
			  }
			  
			  for(int i=0;i<lst.size();i++){
				  try{

				  	%><option value="<%=lst.get(i).getMatricula()%>">(<%=lst.get(i).getMatricula()%>) <%=lst.get(i).getNombre()%>, <%=lst.get(i).getApellido()%></option>
				
					<%  }
				  
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>PACIENTE:</label>
	&nbsp;
	<select class=bonito name="ddlDNIPaciente" >
		<option value=" "> </option>
		<% 
			
			List<Paciente> lst2=new ArrayList<Paciente>();

			  if(request.getAttribute("ListaPacientes")!=null)
			  {
				  lst2=(ArrayList<Paciente>)request.getAttribute("ListaPacientes");
			  }
			  
			  for(int i=0;i<lst2.size();i++){
				  try{

				  	%><option value="<%=lst2.get(i).getDni()%>">(<%=lst2.get(i).getDni()%>) <%=lst.get(i).getNombre()%>, <%=lst2.get(i).getApellido()%></option>
				
					<%  }
				  
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>FECHA:</label> 
	&nbsp;
	<input class=bonito type="date" name="txtFecha">
	
	<br>
	<br>
	
	<label class=lbl2>HORA:</label>
	&nbsp;	
	<input class=bonito type="time" name="txtHora">
	
	<br>
	<br>
	
	<input class=bonito type="Button" name="btnAceptar" value="Agregar Turno" >
</div>

</body>
</html>