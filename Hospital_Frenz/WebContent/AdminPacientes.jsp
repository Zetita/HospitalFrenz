<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/DataGrid.css">
<jsp:include page="Master_Admin.html" />
<title>Administrar Pacientes</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>

<hr style="width:1px;height:490px;position:absolute;left:725px">

<div>

	<b><label class=lbl2>LISTAR PACIENTES</label><br></b>
	<br>
	
	<input class=bonito type="Button" name="btnAgregar" value="+" >
	
	<select class=bonito name="ddlFiltro1">
		<option value="Y">Y<option>
	</select>
	
	<select class=bonito name="ddlTipoFiltro">
		<option value="DNI">DNI<option>
	</select>
	
	<select class=bonito name="ddlFiltro2">
		<option value="MAYOR A">MAYOR A<option>
	</select>
	
	<select class=bonito name="ddlFiltro">
		<option value="32000000">32000000<option>
	</select>

		
</div>

<br>

<div>
		
		<table>
			<tr>
				<th colspan="2"></th>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Usuario Asociado</th>
				<th>Estado</th>
			</tr>
			<tr>
				<td><a href="#" name="llbModificar">Modificar</a></td>
				<td><a href="#" name="llbEliminar">Eliminar</a></td>
				<td>39432465</td>
				<td>José</td>
				<td>Lopez</td>
				<td>_jlopez_</td>
				<td>Activo</td>
			</tr>
		</table>
	
</div>

<div style="position:relative;left:740px;bottom:110px">
	<b><label class=lbl2>AGREGAR PACIENTE</label></b><br>
	<br>
	
	<label class=lbl2>DNI DEL PACIENTE:</label>
	&nbsp;
	<input type="number" class=bonito name="txtDNI">
	
	<br>
	<br>
	
	<label class=lbl2>NOMBRE DEL PACIENTE:</label>
	&nbsp;
	<input type="text" class=bonito name="txtNombre">
	
	<br>
	<br>
	
	<label class=lbl2>APELLIDO DEL PACIENTE:</label>
	&nbsp;
	<input type="text" class=bonito name="txtApellido">
	
	<br>
	<br>
	
	<label class=lbl2>FECHA DE NACIMIENTO DEL PACIENTE:</label>
	&nbsp;
	<input type="date" class=bonito name="txtFechaNac">
	
	<br>
	<br>
	
	<label class=lbl2>TELÉFONO DEL PACIENTE:</label>
	&nbsp;
	<input type="number" class=bonito name="txtFechaNac">
	
	<br>
	<br>
	
	<label class=lbl2>COBERTURA DEL PACIENTE:</label>
	&nbsp;
	<select class=bonito name="ddlCobertura" >
		<option value="Completa">Completa</option>
	</select>
	
	<br>
	<br>
	
	<input class=bonito type="Button" name="btnAceptar" value="Agregar Paciente" >
	
</div>
</html>