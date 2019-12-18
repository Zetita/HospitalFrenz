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
<title>Administrar Pacientes</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>

<div class="mitad1" style="width:56%">

<br>	
	<br>
	<br>

	<b><label class=lbl2>LISTAR PACIENTES</label><br></b>
	<br>
	
	<table id="tbFiltroUser" style="width:100%">

			<tr>
				<td style="border:none">
					<input type="submit" id="btnAgregar" value="+" onclick="agregarFila('tbFiltroUser')" >
				</td>
				<td style="border:none">
					<select id="ddlFiltro1[0]">
						<option value="-">-<option>
					</select>
				</td >
				<td style="border:none">
					<select id="ddlTipo[0]" onchange="diferenciar(this)">
						<option value="-">-</option>
						<option value="1">Nombre de Usuario</option>
						<option value="2">Email</option>
						<option value="3">DNI</option>
						<option value="4">Tipo de Usuario</option>
						<option value="5">Estado</option>
					</select>
				</td>
				<td style="border:none">
					<select id="ddlFiltro2[0]" onchange="columna(this)">
					</select>
				</td>
				<td style="text-align:center;border:none"> <label id="dinamico[0]">Completar datos</label>
				</td>
			</tr>
		</table>
		
		<br>
		<br>


		<table id="tbPacientes">
		<thead>
			<tr>
				<th colspan="2"></th>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Direccion</th>
				<th>Teléfono</th>
				<th>Fecha de Nacimiento</th>
				<th>Cobertura</th>
				<th>Localidad</th>
				<th>Estado</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			List<Paciente> lst4=new ArrayList<Paciente>();

			  if(request.getAttribute("ListaPacientes")!=null)
			  {
				  lst4=(ArrayList<Paciente>)request.getAttribute("ListaPacientes");
			  }
			  
			  int indice=1;
			  for(int i=0;i<lst4.size();i++){
				  try{
				  %>
				  <form method="post" action="ServletMedicos?Indice=<%=indice%>">
				  	<tr>
				  		<td>
				  		<input type="hidden" id="hdnConsulta[<%=indice %>]" name="hdnConsulta[<%=indice %>]">
				  		<input type="button" id="btnModificar[<%=indice %>]" name="btnModificar[<%=indice %>]" style="font-size:10px" value="Modificar">
				  		</td>
				  		<td><input type="submit" name="btnEliminar[<%=indice %>]" id="btnEliminar[<%=indice %>]" style="font-size:10px" value="Eliminar"></td>
				  		<td><label id="lblDNI[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getDni()%></label></td>
				  		<td><label id="lblNombre[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getNombre()%></label></td>
				  		<td><label id="lblApellido[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getApellido()%></label></td>
				  		<td><label id="lblDireccion[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getDireccion()%></label></td>
				  		<td><label id="lblTelefono[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getTelefono() %></label></td>
				  		<td><label id="lblFechaNac[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getFecha()%></label></td>
				  		<td><label id="lblCobertura[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getCobertura().getNombre()%></label></td>
				  		<td><label id="lblLocalidad[<%=indice%>]" style="font-size:10px"><%=lst4.get(i).getLocalidad().getNombre()%></label></td>
				  		<td><% if(lst4.get(i).getEstado()==1){%><label id="lblEstado[<%=indice%>]" style="font-size:10px">Habilitado</label>
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

<div class="mitad2" style="margin-left: 60%; width:30%;">

	<form name="frmAgregar" method="post" action="ServletPacientes">
	<b><label>AGREGAR PACIENTE</label></b>
	
	<br>
	<br>
	
    <label style="display:inline-block; width:160px;"> DNI: </label>

	<%if(request.getAttribute("DNI")!=null) 
	{%><input name="txtDNI" type="text" placeholder="11.111.111" value=<%=request.getAttribute("DNI") %> required>
		<%}
	else{
	%>
	<input name="txtDNI" type="text" placeholder="11.111.111" required>
	<%
	}%>
	
	<br>
	<br>
	
	<label style="display:inline-block; width:160px;"> NOMBRE: </label>

	<%if(request.getAttribute("Nombre")!=null) 
	{%>
    <input name="txtNombre" type="text" placeholder="Nombre" value="<%=request.getAttribute("Nombre")%>" required>
	<%}
	else{
	%>
	<input name="txtNombre" type="text" placeholder="Nombre" required>
	<%
	}%>
	
    <br>
    <br>

	
    <label style="display:inline-block; width:160px;"> APELLIDO: </label>


	<%if(request.getAttribute("Apellido")!=null) 
	{%>
    <input name="txtApellido" type="text" placeholder="Apellido"  value="<%=request.getAttribute("Apellido")%>" required>
	<%}
	else{
	%>
	<input name="txtApellido" type="text" placeholder="Apellido" required>
	<%
	}%>
	
    <br>
    <br>

    <label style="display:inline-block; width:160px;"> DIRECCION: </label>

	<%if(request.getAttribute("Direccion")!=null) 
	{%>
    <input name="txtDireccion" type="text" placeholder="Calle y numero"  value="<%=request.getAttribute("Direccion")%>" required>
	<%}
	else{
	%>
	<input name="txtDireccion" type="text" placeholder="Calle y numero" required>
	<%
	}%>
	
    <br>
    <br>

    <label style="display:inline-block; width:160px;"> PROVINCIA: </label>

    <select name="ddlProvincia" style="width:50%;" onchange="javascript:document.frmAgregar.submit();" required>
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

    <label  style="display:inline-block; width:160px;"> LOCALIDAD: </label>

    <select name="ddlLocalidad" style="width:50%" required>
    
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

    <label style="display:inline-block; width:160px;"> TELEFONO: </label>


	<%if(request.getAttribute("Telefono")!=null) 
	{%>
    <input name="txtTelefono" type="phone" placeholder="11-0000-0000" value="<%=request.getAttribute("Telefono")%>" required>
	<%}
	else{
	%>
	<input name="txtTelefono" type="phone" placeholder="11-0000-0000" required>
	<%
	}%>
	<br>
    <br>
	<label style="display:inline-block; width:160px;">FECHA DE NACIMIENTO DEL PACIENTE:</label>

	<%if(request.getAttribute("FechaNac")!=null) 
	{%>
    <input type="date" id="txtFechaNac" name="txtFechaNac" value="<%=request.getAttribute("FechaNac")%>" required>
	<%}
	else{
	%>
	<input type="date" id="txtFechaNac" name="txtFechaNac" required>
	<%
	}%>
	
	<br>
	<br>
	
	<label style="display:inline-block; width:160px;">COBERTURA DEL PACIENTE:</label>

	<select name="ddlCobertura" required>
	<%
		List<Cobertura> lst3=new ArrayList<Cobertura>();

			  if(request.getAttribute("ListaCoberturas")!=null)
			  {
				  lst3=(ArrayList<Cobertura>)request.getAttribute("ListaCoberturas");
			  
			  
			  for(int i=0;i<lst3.size();i++){
				  try{
					  if(request.getAttribute("Cobertura")!=null&&i==(Integer.parseInt(request.getAttribute("Cobertura").toString()))-1){

						  %>
						  	<option value="<%=lst3.get(i).getIdCobertura()%>" selected="selected"><%=lst3.get(i).getNombre() %></option>
						  <%
							  }
					  else{
				  %>
				  	<option value="<%=lst3.get(i).getIdCobertura()%>"><%=lst3.get(i).getNombre() %></option>
				  <%
					  }
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			}
				%>
	</select>
	
	<br>
	<br>
	<span style="color:red"><%=(request.getAttribute("errorMessage") == null) ? "": request.getAttribute("errorMessage")%></span>
	<br>
	<br>
	
	<input type="Submit" style="width:100%" name="btnAgregarPac" value="Agregar Paciente" >
	
	</form>
	
	<script type="text/javascript">

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1;
var yyyy = today.getFullYear();
 if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 

today = yyyy+'-'+mm+'-'+dd;
document.getElementById("txtFechaNac").setAttribute("max", today);
</script>

</div>
</html>