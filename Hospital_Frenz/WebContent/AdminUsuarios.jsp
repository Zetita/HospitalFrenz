<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, entidad.*"  %>
    <%@ page import="java.util.*, entidad.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/EstiloAdmin.css">
<jsp:include page="Master_Admin.html" />

<title>Administrar Usuarios</title>

</head>

<body>
<script src="javascript/FiltroDinamico.js"></script>
<script src="javascript/Modificar.js"></script>

<div class="mitad1" style="width:56%">

	<br>	
	<br>
	<br>

	<b><label class=lbl2>LISTAR USUARIOS</label><br></b>
	<br>
	
	<table id="tbFiltro" style="width:100%">
			<tr>
				<td style="border:none">
					<input class=boton type="submit" id="btnAgregar" value="+" onclick="agregarFila('tbFiltro')" >
				</td>
				<td style="border:none">
					<select class=bonito id="ddlFiltro1[0]">
						<option value="-">-<option>
					</select>
				</td >
				<td style="border:none">
					<select class=bonito id="ddlTipo[0]" onchange="diferenciar(this)">
						<option value="-">-</option>
						<option value="1">Nombre de Usuario</option>
						<option value="2">Email</option>
						<option value="3">DNI</option>
						<option value="4">Tipo de Usuario</option>
						<option value="5">Estado</option>
					</select>
				</td>
				<td style="border:none">
					<select class=bonito id="ddlFiltro2[0]" onchange="columna(this)">
					</select>
				</td>
				<td style="text-align:center;border:none"> <label id="dinamico[0]">Completar datos</label>
				</td>
			</tr>
		</table>
		
		<br>
		<br>

		<input type="button" id="btnFiltrar" class="boton" style="width:94%" value="Filtrar">
	
	<br>	
	<br>
	<br>

		<table id="tbUsers" style="width:100%">
			<tr>
				<th colspan="2"></th>
				<th>Nombre de Usuario</th>
				<th>Contraseña</th>
				<th>Email</th>
				<th>DNI Asociado</th>
				<th>Tipo de Usuario</th>
				<th>Estado</th>
			</tr>
			<%List<Usuario> lst=null;
			int Comienzo=0;
			int Final=5;
			  if(request.getAttribute("ListaUsers")!=null)
			  {
				  lst=(ArrayList<Usuario>)request.getAttribute("ListaUsers");
			  }
			  if(session.getAttribute("NumPag")!=null)
			  {
				  
			 	  Final=5*Integer.parseInt(session.getAttribute("NumPag").toString());
			 	Comienzo=Final-5;
			  }
			  int indice=1;
			  for(int i=Comienzo;i<Final;i++){
				  try{
				  %>
				  <form method=post action="ServletUsuarios?Param=<%=lst.get(i).getDNI()%>">
				  	<tr>
				  		<td><input type="button" class="boton" id="btnModificar[<%=indice %>]" style="font-size:10px" onclick="modificar(this,'tbUsers')" value="Modificar"></td>
				  		<td><input type="submit" class="boton" id="btnEliminar[<%=indice %>]" style="font-size:10px" value="Eliminar"></td>
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
			  
			  int cant=lst.size()/5;
			  if(lst.size()%5!=0)
			  {
				  session.setAttribute("Resto",lst.size()%5);
			  }
			  else{
				  session.setAttribute("Resto",null);
			  }
			  %>
			  
			  <tr>
			  <td colspan="8">
			  
			  <% 
			   System.out.println(session.getAttribute("NumPag"));
			  for(int i=0;i<=cant;i++){
				   %>
				   <a href="ServletUsuarios?Param=admin&Origen=1&Num=<%=i+1%>" id="btnPag<%=i+1 %>" class="boton"><%=i+1 %></a>
				   <%
			  }
			%>
			
			</td>
			</tr>
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
	<input type="text" class=bonito style="position:relative;left:11%" name="txtNombre">
	
	<br>
	<br>
	
	<label class=lbl2>CONTRASEÑA DEL USUARIOS:</label>
	&nbsp;
	<input type="password" class=bonito name="txtContrasenia">
	
	<br>
	<br>
	

	<label class=lbl2>DNI DEL USUARIO:</label>
	&nbsp;
	<input type="number" class=bonito style="position:relative;left:22%" name="txtDNI">
	
	<br>
	<br>
	

	<label class=lbl2>EMAIL DEL USUARIO:</label>
	&nbsp;
	<input type="text" class=bonito style="position:relative;left:17%" name="txtEmail">
	
	<br>
	<br>

	<table style="border:none;width:112%">
		<tr>
			<td style="border:none;text-align:left">
			</td>
			<td style="border:none;text-align:left">
				<input name="Tipo" type="radio" class=bonito value="med" >
				<label class=lbl2>Medico</label>
			</td>
		</tr>
		<tr>
			<td style="border:none;text-align:left">
				<label class=lbl2>TIPO DE USUARIO:</label>

			</td>
			<td style="border:none;text-align:left">
				<input name="Tipo" type="radio" class=bonito value="pac">
				<label class=lbl2>Paciente</label>
			</td>
		</tr>
		<tr>
			<td style="border:none;text-align:left">
			</td>
			<td style="border:none;text-align:left">
				<input name="Tipo" type="radio" class=bonito value="adm" >
				<label class=lbl2>Administrador</label>
			</td>
		</tr>
	</table>
	<br>
	
	<input class=boton type="submit" name="btnAceptar" style="width:95%" value="Agregar Usuario">
	</form>
</div>
</html>