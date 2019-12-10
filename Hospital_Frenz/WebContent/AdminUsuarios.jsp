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
<script type="text/javascript" src="DataTables/Spanish.json"></script>

<title>Administrar Usuarios</title>

</head>

<body>
		
		<script type="text/javascript">
		$(document).ready( function () {
		    $('#tbUsers').DataTable();
		} );</script>
		
		
		
<div class="mitad1" style="width:56%">
	<br>	
	<br>
	<br>

	<b><label class=lbl2>LISTAR USUARIOS</label><br></b>
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
		
	<form method=post action="ServletUsuarios">
		<input type="Hidden" id="hdnConsulta" name="hdnConsulta" value="xdd"/>
		<input type="submit" id="btnFiltrar" name="btnFiltrar" style="width:94%" value="Filtrar" onclick="ObtenerFiltro('tbFiltroUser')">
	</form>
	
	<br>	
	<br>
	<br>

		<table id="tbUsers" style="width:100%">
			<thead>
			<tr>
				<th colspan="2"></th>
				<th>Nombre de Usuario</th>
				<th>Contraseña</th>
				<th>Email</th>
				<th>DNI Asociado</th>
				<th>Tipo de Usuario</th>
				<th>Estado</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			List<Usuario> lst=new ArrayList<Usuario>();

			  if(request.getAttribute("ListaUsers")!=null)
			  {
				  lst=(ArrayList<Usuario>)request.getAttribute("ListaUsers");
			  }
			  
			  int indice=1;
			  for(int i=0;i<lst.size();i++){
				  try{
				  %>
				  <form method=post action="ServletUsuarios?Indice=<%indice%>">
				  	<tr>
				  		<td><input type="button" id="btnModificar[<%=indice %>]" style="font-size:10px" onclick="modificar(this,'tbUsers')" value="Modificar"></td>
				  		<td><input type="submit" name="btnEliminar[<%=indice %>]" id="btnEliminar[<%=indice %>]" style="font-size:10px" onclick="ObtenerEliminar(this,'tbUsers')" value="Eliminar"></td>
				  		<td><label id="lblUsuario[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getUsuario()%></label></td>
				  		<td><label id="lblContrasenia[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getContrasenia() %></label></td>
				  		<td><label id="lblEmail[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getEmail()%></label></td>
				  		<td><label id="lblDNI[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getDNI()%></label></td>
				  		<td><label id="lblTipo[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getTipo()%></label></td>
				  		<td><% if(lst.get(i).isEstado()==true){%><label id="lblEstado[<%=indice%>]" style="font-size:10px">Habilitado</label>
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

	<br>	
	<br>
	<br>
	
	<form method="post" action="ServletUsuarios" >

	<b><label class=lbl2>AGREGAR USUARIO</label></b><br>
	<br>
	
	<label class=lbl2>NOMBRE DEL USUARIO:</label>
	&nbsp;
	<input type="text"style="position:relative;left:11%" name="txtNombre">
	
	<br>
	<br>
	
	<label class=lbl2>CONTRASEÑA DEL USUARIOS:</label>
	&nbsp;
	<input type="password" style="position:relative;left:1.5%" name="txtContrasenia">
	
	<br>
	<br>
	

	<label class=lbl2>DNI DEL USUARIO:</label>
	&nbsp;
	<input type="number" style="position:relative;left:19%" name="txtDNI">
	
	<br>
	<br>
	

	<label class=lbl2>EMAIL DEL USUARIO:</label>
	&nbsp;
	<input type="text" style="position:relative;left:15%" name="txtEmail">
	
	<br>
	<br>

	<table style="border:none;width:112%">
		<tr>
			<td style="border:none;text-align:left">
			</td>
			<td style="border:none;text-align:left">
				<input name="Tipo" type="radio" value="med" >
				<label class=lbl2>Medico</label>
			</td>
		</tr>
		<tr>
			<td style="border:none;text-align:left">
				<label class=lbl2>TIPO DE USUARIO:</label>

			</td>
			<td style="border:none;text-align:left">
				<input name="Tipo" type="radio" value="pac">
				<label class=lbl2>Paciente</label>
			</td>
		</tr>
		<tr>
			<td style="border:none;text-align:left">
			</td>
			<td style="border:none;text-align:left">
				<input name="Tipo" type="radio" value="adm" >
				<label class=lbl2>Administrador</label>
			</td>
		</tr>
	</table>
	<br>
	
	<input type="submit" name="btnAceptar" style="width:95%" value="Agregar Usuario">
	</form>
</div>
</html>
