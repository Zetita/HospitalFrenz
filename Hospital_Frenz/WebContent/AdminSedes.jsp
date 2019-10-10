<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/DataGrid.css">
<jsp:include page="Master_Admin.html" />
<title>Administrar Sedes</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>

<hr style="width:1px;height:490px;position:absolute;left:725px">

<div>

	<b><label class=lbl2>LISTAR SEDES</label><br></b>
	<br>
	
	<input class=bonito type="Button" name="btnAgregar" value="+" >
	
	<select class=bonito name="ddlFiltro1">
		<option value="Y">Y<option>
	</select>
	
	<select class=bonito name="ddlTipoFiltro">
		<option value="Provincia">Provincia<option>
	</select>
	
	<select class=bonito name="ddlFiltro2">
		<option value="NO ES">No es<option>
	</select>
	
	<select class=bonito name="ddlFiltro">
		<option value="Buenos Aires">Buenos Aires<option>
	</select>

		
</div>

<br>

<div>
		
		<table>
			<tr>
				<th colspan="2"></th>
				<th>ID de la Sede</th>
				<th>Provincia de la Sede</th>
				<th>Localidad de la Sede</th>
				<th>Nombre de la Sede</th>
				<th>Dirección de la Sede</th>
				<th>Estado</th>
			</tr>
			<tr>
				<td><a href="#" name="llbModificar">Modificar</a></td>
				<td><a href="#" name="llbEliminar">Eliminar</a></td>
				<td>1</td>
				<td>Entre Rios</td>
				<td>Colón</td>
				<td>Frenz Colón</td>
				<td>Av. Pres. Juan Domingo Perón 213</td>
				<td>Inhabilitado</td>
			</tr>
		</table>
	
</div>

<div style="position:relative;left:740px;bottom:110px">
	<b><label class=lbl2>AGREGAR SEDE</label></b><br>
	<br>
	
	<label class=lbl2>NOMBRE DE SEDE:</label>
	&nbsp;
	<input type="text" class=bonito name="txtNombre">
	
	<br>
	<br>
	
	<label class=lbl2>DIRECCIÓN DE LA SEDE:</label>
	&nbsp;
	<input type="text" class=bonito name="txtDireccion">
	
	<br>
	<br>
	
	<label class=lbl2>PROVINCIA DE LA SEDE:</label>
	&nbsp;
	<select class=bonito name="ddlProvincia" >
		<option value="Mendoza">Mendoza</option>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>LOCALIDAD DE LA SEDE:</label>
	&nbsp;
	<select class=bonito name="ddlLocalidad" >
		<option value="San Rafael">San Rafael</option>
	</select>
	
	<br>
	<br>
	
	<input class=bonito type="Button" name="btnAceptar" value="Agregar Sede" >
	
</div>
</html>