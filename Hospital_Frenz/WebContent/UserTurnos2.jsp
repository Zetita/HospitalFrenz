<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estiloThomy.css">
<jsp:include page="Master_User.html" />
<meta charset="ISO-8859-1">
<title>Turnos</title>
</head>
<body>

<form method="post" action="ServletUsuarios">
<button type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div><%=(request.getAttribute("usuario") == null) ? ""
 : request.getAttribute("usuario")%></div></button>
</form>

<div class=container>
<h5 >Turnos</h5><br>
<label>SIN INFORMACION PARA MOSTRAR </label>
<input type=button name=BtnTurno value="Solicitar Turno" class="btn btn-primary" style="margin-left:15%;">
</div>
<div class=container>
<br>
<h5>Historial de turnos:</h5><br>
<label>Nombre del/la doctor/a:</label><br>
<label>Horario del turno:</label><br>
<label>Especialidad:</label><br>
<label>Sede:</label><br>
<label>Estado:</label><br>
</div>
</body>
</html>