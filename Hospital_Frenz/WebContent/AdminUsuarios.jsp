<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/DataGrid.css">
<jsp:include page="Master_Admin.html" />
<title>Administrar Usuarios</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>

<hr style="width:1px;height:490px;position:absolute;left:725px">

<div>

	<b><label class=lbl2>LISTAR USUARIOS</label><br></b>
	<br>
	
	<input class=bonito type="Button" name="btnAgregar" value="+" >
	
	<select class=bonito name="ddlFiltro1">
		<option value="Y">Y<option>
	</select>
	
	<select class=bonito name="ddlTipoFiltro">
		<option value="TIPO DE USUARIO">Tipo de Usuario<option>
	</select>
	
	<select class=bonito name="ddlFiltro2">
		<option value="ES">Es<option>
	</select>
	
	<select class=bonito name="ddlFiltro">
		<option value="PACIENTE">Paciente<option>
	</select>

		
</div>

<br>

<div>
		
		<table>
			<tr>
				<th colspan="2"></th>
				<th>Nombre de Usuario</th>
				<th>Contraseña</th>
				<th>Email</th>
				<th>DNI Asociado</th>
				<th>Administrador</th>
				<th>Tipo de Usuario</th>
			</tr>
			<tr>
				<td><a href="#" name="llbModificar">Modificar</a></td>
				<td><a href="#" name="llbEliminar">Eliminar</a></td>
				<td>_jlopez_</td>
				<td>1234abcd</td>
				<td>jose.lopez@gmail.com</td>
				<td>39432465</td>
				<td>No</td>
				<td>Paciente</td>
			</tr>
		</table>
	
</div>

<div style="position:relative;left:740px;bottom:110px">
	<b><label class=lbl2>AGREGAR USUARIO</label></b><br>
	<br>
	
	<label class=lbl2>NOMBRE DEL USUARIO:</label>
	&nbsp;
	<input type="text" class=bonito name="txtNombre">
	
	<br>
	<br>
	
	<label class=lbl2>CONTRASEÑA DEL USUARIOS:</label>
	&nbsp;
	<input type="password" class=bonito name="txtContraseña">
	
	<br>
	<br>
	
	<label class=lbl2>DNI DEL USUARIO:</label>
	&nbsp;
	<input type="number" class=bonito name="txtDNI">
	
	<br>
	<br>
	
	<label class=lbl2>EMAIL DEL USUARIO:</label>
	&nbsp;
	<input type="text" class=bonito name="txtEmail">
	
	<br>
	<br>
	
	<label class=lbl2>ADMINISTRADOR:</label>
	&nbsp;
	<input type="checkbox" class=bonito name="chckAdministrador">
	
	<br>
	<br>
	
	<label class=lbl2>TIPO DE USUARIO:</label>
	&nbsp;
	<input name="Tipo" type="radio" class=bonito value="Medico" name="chckMedico">
	<label class=lbl2>Medico</label>
	&nbsp;
	<input name="Tipo" type="radio" class=bonito value="Paciente" name="chckPaciente">
	<label class=lbl2>Paciente</label>
	<br>
	<br>
	
	<input class=bonito type="Button" name="btnAceptar" value="Agregar Usuario" >
	
</div>
</html>