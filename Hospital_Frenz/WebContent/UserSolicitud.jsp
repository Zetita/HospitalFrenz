<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estiloThomy.css">
<jsp:include page="Master_User.html" />
<meta charset="ISO-8859-1">
<title>Solicitar Turno</title>
</head>
<body>
<div style="text-aling:center; margin-left:40%; margin-right:30%;">

<label class=lbl2>Especialidad</label><br><br><select><option value=0>Seleccione Especialidad</option>
</select><br><br> 
<label class=lbl2>Sede</label><br><input type=checkbox><label class=lbl2>Seleccionar todas las sedes</label> <br><select><option value=0>Seleccione Sede</option></select><br><br>
<label class=lbl2>Doctor</label><br><br><select><option value=0>Seleccione Doctor/a</option></select><br><br>
<label class=lbl2>Horario</label><br><br><select><option value=0>Seleccione Horario</option></select><br><br>

<input type=button name=BtnTurno value="Pedir Turno" class="btn btn-primary"><br>

</div>
</body>
</html>