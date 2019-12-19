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

<title>Administrar medicos</title>

</head>

<body>

<% if(request.getAttribute("Mensaje")!=null){
	%>
	<script type="text/javascript">
		alert("<%=request.getAttribute("Mensaje")%>")
	</script>
	<%
	request.setAttribute("Mensaje",null);
	}
	%>

<div class="mitad1" style="width:56%">

<table id="tbMedicos" style="width:100%">
			<thead>
			<tr>
				<th colspan="2"></th>
				<th>DNI</th>
				<th>Matricula</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Direccion</th>
				<th>Localidad</th>
				<th>Telefono</th>
				<th>Estado</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			List<Medico> lst3=new ArrayList<Medico>();

			  if(request.getAttribute("ListaMed")!=null)
			  {
				  lst3=(ArrayList<Medico>)request.getAttribute("ListaMed");
			  }
			  
			  int indice=1;
			  for(int i=0;i<lst3.size();i++){
				  try{
				  %>
				  <form method="post" action="ServletMedicos?Indice=<%=indice%>">
				  	<tr>
				  		<td>
				  		<input type="hidden" id="hdnConsulta[<%=indice %>]" name="hdnConsulta[<%=indice %>]">
				  		<input type="button" id="btnModificar[<%=indice %>]" name="btnModificar[<%=indice %>]" style="font-size:10px" onclick="modificar(this,'tbUsers')" value="Modificar">
				  		</td>
				  		<td><input type="submit" name="btnEliminar[<%=indice %>]" id="btnEliminar[<%=indice %>]" style="font-size:10px" onclick="ObtenerEliminar(this,'tbUsers')" value="Eliminar"></td>
				  		<td><label id="lblDNI[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getDni()%></label></td>
				  		<td><label id="lblMatricula[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getMatricula() %></label></td>
				  		<td><label id="lblNombre[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getNombre()%></label></td>
				  		<td><label id="lblApellido[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getApellido()%></label></td>
				  		<td><label id="lblDireccion[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getDireccion()%></label></td>
				  		<td><label id="lblLocalidad[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getLocalidad().getNombre()%></label></td>
				  		<td><label id="lblTelefono[<%=indice%>]" style="font-size:10px"><%=lst3.get(i).getTelefono()%></label></td>
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

    <b><label class=lbl2>MEDICOS</label><br></b>
    
    <br>
    <br>
	
	<form name="frmAgregar" method="post" action="ServletMedicos">
	
    <b><label>AGREGAR MEDICO</label></b>

	<br>
    <br>

    <label> DNI: </label>

	<%if(request.getAttribute("DNI")!=null) 
	{%><input name="txtDNI" type="number" placeholder="11.111.111" style="position:relative;left:40%" value=<%=request.getAttribute("DNI") %>>
		<%}
	else{
	%>
	<input name="txtDNI" type="number" placeholder="11.111.111" style="position:relative;left:40%">
	<%
	}%>

    

    <br>
    <br>

    <label> Nº MATRICULA: </label>
	<%if(request.getAttribute("NMat")!=null) 
	{%>
    <input name="txtNumeroMatricula" type="number" placeholder="Numero de matricula" style="position:relative;left:19%" value="<%=request.getAttribute("NMat")%>">
	<%}
	else{
	%>
	<input name="txtNumeroMatricula" type="number" placeholder="Numero de matricula" style="position:relative;left:19%">
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

	
    <label> APELLIDO: </label>


	<%if(request.getAttribute("Apellido")!=null) 
	{%>
    <input name="txtApellido" type="text" placeholder="Apellido" style="position:relative;left:28%" value="<%=request.getAttribute("Apellido")%>">
	<%}
	else{
	%>
	<input name="txtApellido" type="text" placeholder="Apellido" style="position:relative;left:28%">
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

    <label> TELEFONO: </label>


	<%if(request.getAttribute("Telefono")!=null) 
	{%>
    <input name="txtTelefono" type="phone" placeholder="Numero: 441112312" style="position:relative;left:27%" value="<%=request.getAttribute("Telefono")%>">
	<%}
	else{
	%>
	<input name="txtTelefono" type="phone" placeholder="Numero: 441112312" style="position:relative;left:27%">
	<%
	}%>
	
    <br>
    <br>

    <input type="Submit" name="btnAgregarMed" value="Agregar" style="width:100%">
	
	<br>
	<br>
	
	<label><b>AGREGAR ESPECIALIDAD</b></label>

    <br>
    <br>

    <label>MEDICO: </label>

    <select name="ddlMedico" style="position:relative;width:66%;left:31%">
    <option selected="" value=""></option>
    <% 
			
			List<Medico> lst4=new ArrayList<Medico>();

			  if(request.getAttribute("ListaMed")!=null)
			  {
				  lst4=(ArrayList<Medico>)request.getAttribute("ListaMed");
			  }
			  
			  for(int i=0;i<lst4.size();i++){
				  try{

				  	%><option value="<%=lst4.get(i).getMatricula()%>">(<%=lst4.get(i).getMatricula()%>) <%=lst4.get(i).getNombre()%>, <%=lst4.get(i).getApellido()%></option>
				
					<%  }
				  
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
    </select>
	
	<br>
	<br>
	
    <label>ESPECIALIDAD: </label>

    <select name="ddlEspecialidad" style="position:relative;width:65%;left:19.5%" >
    	<option selected="" value=""></option>
        <% 
			
			List<Especialidad> lst1=new ArrayList<Especialidad>();

			  if(request.getAttribute("ListaEspecialidades")!=null)
			  {
				  lst1=(ArrayList<Especialidad>)request.getAttribute("ListaEspecialidades");
			  }
			  
			  for(int i=0;i<lst1.size();i++){
				  try{
				  %>
				  	<option value="<%=lst1.get(i).getId()%>">(<%=lst1.get(i).getId()%>) <%=lst1.get(i).getDescripcion() %></option>
				  <%
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
    
    </select>

    <br>
    <br>

    <input type="Submit" name="btnAgregarEsp" style="width:100%" value="Cargar Especialidad">
	
	</form>
</div>




</body>

</html>

