<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/DataGrid.css">
<jsp:include page="Master_Admin.html" />
<title>Administrar Turnos</title>
</head>
<body>

<script type="text/javascript">
	document.getElementById("btnLogOff").innerHTML="<div style='height:100%;width:100%'>"+sessionStorage.getItem("NombreUser")+"</div>"; 
</script>

<br>
<br>
<br>
<br>
<br>

<hr style="width:1px;height:490px;position:absolute;left:700px">

<div>

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

		
</div>

<br>

<div>
		
		<table>
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

<div style="position:relative;left:715px;bottom:110px">
	<b><label class=lbl2>AGREGAR TURNO</label></b><br>
	<br>
	
	<label class=lbl2>SEDE:</label>
	&nbsp;
	<select class=bonito name="ddlSede">
		<option value="Martinez">Martinez</option>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>ESPECIALIDAD:</label>
	&nbsp;
	<select class=bonito name="ddlEspecialidad">
		<option value="Dermatologia">Dermatologia</option>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>MATRICULA DEL MEDICO:</label>
	&nbsp;
	<select class=bonito name="ddlMedico" >
		<option value="321">321</option>
	</select>
	
	<br>
	<br>
	
	<label class=lbl2>DNI DEL PACIENTE:</label>
	&nbsp;
	<select class=bonito name="ddlDNIPaciente" >
		<option value="41324123">41324123</option>
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