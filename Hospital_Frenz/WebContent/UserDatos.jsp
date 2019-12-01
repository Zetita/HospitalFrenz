<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="Master_User.html" />
<title>Mis datos | Hospital Frenz</title>
</head>
<body>

<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div>${usuario}</div></button>

<div class="container">
<h5>Datos Personales</h5><br>
<label>Numero de Documento:</label><br>
<label>Nombre:</label><br>
<label>Apellido:</label><br>
<label>Fecha De Nacimiento:</label><br>
</div>
<br><br>

<div class="container" >
<h5>Datos de contacto</h5><br>
<label>Celular:</label> <input type=tel name=txtCel placeholder="11-1111-1111"><br>
<label>Correo-Electronico:</label><input type=email name=txtEmail placeholder="Grupo6@gmail.com"><br>


<br><br>
</div>

<div class="container" >
<h5>Datos de residencia</h5><br>
<label>Provincia:</label><input name=txtProvincia placeholder="Buenos Aires" type="text"><br>
<label>Localidad:</label><input	name=txtLocalidad placeholder="Escobar" type="text"	><br>
<label>Direccion:</label><input name=txtDireccion placeholder="F.Diaz 3500" type="text"><br>
<br><br>
</div>

<div  class="container">
<h5>Tipo de cobertura</h5><br>
<label>Nombre de cobertura:</label><br>
<label>Tipo de cobertura:</label><br>
<div  class=boton><input type=button name=BtnActualizar class="btn btn-primary" value="Actualizar"></div>
</div>

</body>
</html>