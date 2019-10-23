<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<hr class="divisor">

<div class="mitad1" >

	<b><label class=lbl2>LISTAR USUARIOS</label><br></b>
	<br>
	
	<table id="tbFiltro">
			<tr>
				<td style="border:none">
					<input class=bonito type="submit" id="btnAgregar" value="+" onclick="agregarFila('tbFiltro')" >
				</td>
				<td style="border:none">
					<select class=bonito id="ddlFiltro1[0]">
						<option value="-">-<option>
					</select>
				</td >
				<td style="border:none">
					<select class=bonito id="ddlTipo[0]" onchange="diferenciar()">
						<option value="-">-</option>
						<option value="1">Nombre de Usuario</option>
						<option value="2">Email</option>
						<option value="3">DNI</option>
						<option value="4">Tipo de Usuario</option>
					</select>
				</td>
				<td style="border:none">
					<select class=bonito id="ddlFiltro2[0]" onchange="columna()">
					</select>
				</td>
				<td style="text-align:center;border:none"> <label id="dinamico[0]">Completar datos</label>
				</td>
			</tr>
		</table>
		
<br>
<br>

		<table id="tabla">
			<tr>
				<th colspan="2"></th>
				<th>Nombre de Usuario</th>
				<th>Contraseña</th>
				<th>Email</th>
				<th>DNI Asociado</th>
				<th>Administrador</th>
				<th>Tipo de Usuario</th>
			</tr>
		</table>
	
</div>

<div class="mitad2">
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