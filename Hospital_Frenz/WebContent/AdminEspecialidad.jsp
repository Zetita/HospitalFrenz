<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/DataGrid.css">
<jsp:include page="Master_Admin.html" />
<title>Administrar Especialidades</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>

<hr style="width:1px;height:490px;position:absolute;left:700px">

<div style="position:relative;left:215px;top:10px">

	<b><label class=lbl2>LISTAR ESPECIALIDADES</label><br></b>
	<br>
	<input class=bonito type="Button" name="btnAgregar" value="+" >
	
	<select class=bonito name="ddlFiltro1">
		<option value="NO ES">NO ES<option>
	</select>
	
	&nbsp;
	
	<label class=lbl2>Estado:</label>
	
	&nbsp;
	
	<select class=bonito name="ddlFiltro">
		<option value="Inhabilitado">Inhabilitado<option>
	</select>

		
</div>

<br>

<div style="position:relative;left:215px;top:10px">
		
		<table>
			<tr>
				<th colspan="2"></th>
				<th>Numero de la Especialidad</th>
				<th>Descripción de la Especialidad</th>
				<th>Estado</th>
			</tr>
			<tr>
				<td><a href="#" name="llbModificar">Modificar</a></td>
				<td><a href="#" name="llbEliminar">Eliminar</a></td>
				<td>4</td>
				<td>Dermatología</td>
				<td>Habilitado</td>
			</tr>
		</table>
	
</div>

<div style="position:relative;left:715px;bottom:110px">
	<b><label class=lbl2>AGREGAR ESPECIALIDAD</label></b><br>
	<br>
	
	<label class=lbl2>DESCRIPCIÓN DE LA ESPECIALIDAD:</label>
	&nbsp;
	<input class=bonito type="text" name="txtEspecialidad">
	
	<br>
	<br>
	
	<input class=bonito type="Button" name="btnAceptar" value="Agregar Especialidad" >
	
</div>

</body>
</html>