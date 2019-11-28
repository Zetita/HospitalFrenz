<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="Master_User.html" />

<link rel="stylesheet" href="css/Medico.css" type="text/css"><link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Turnos | Hospital Frenz</title>
</head>
<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div><%=(request.getAttribute("usuario") == null) ? ""
 : request.getAttribute("usuario")%></div></button>
</form>


<div class="container1">
  <div class="items">
    <div class="items-head">
      <p>Turnos recientes 
      <input type="button" name="BtnTurno" value="Solicitar Turno" class="btn btn-primary" style="margin-left:20px;"> 
      </p>
      <hr>
    </div>
    
    <div class="items-body">
      <div class="items-body-content">
        <span>Dr. wawa - 14/10/2019 14:05 - PENDIENTE</span> 
        <br>
        <span>Especilidad: CARDIOLOGIA</span>
        <br>
        <span>Sede: San Isidro</span>
        <br>
        <button class="buttonT">Cancelar</button>
        <i class="fa fa-angle-right"></i>
      </div>
      <div class="items-body-content">
        <span>Celeste Gomez - 14/10/2019 18:00 - PENDIENTE</span>
        <br>
        <span>Especilidad: CARDIOLOGIA</span>
        <br>
        <span>Sede: San Isidro</span>
        <br>
        <button class="buttonT">Cancelar</button>
        <i class="fa fa-angle-right"></i>
      </div>
      <div class="items-body-content">
        <span>Juan Bosco - 15/10/2019 12:00 - PENDIENTE</span>
        <br>
		<span>Especilidad: CARDIOLOGIA</span>
		<br>
        <span>Sede: SEDE SAN ISIDRO</span>
        <br>
        <button class="buttonT">Cancelar</button>
        <i class="fa fa-angle-right"></i>
      </div>
      </div>
    </div>
  </div>
</div>
<br>
<br>
<div class="container2">
  <div class="items">
    <div class="items-head">
      <p>Historial de turnos</p>
      <hr>
    </div>
    
    <div class="items-body">
      <div class="items-body-content">
        <span>Maria Elena Diaz - 10/09/2019 18:00 - AUSENTE </span>
        <i class="fa fa-angle-right"></i>
      </div>
      <div class="items-body-content">
        <span>Silvia Flores - 10/10/2019 10:00 - PRESENTE</span>
        <i class="fa fa-angle-right"></i>
      </div>
      <div class="items-body-content">
        <span>Juan Bosco - 10/10/2019 08:00 - CANCELADA</span>
        <i class="fa fa-angle-right"></i>
      </div>
      <div class="items-body-content">
        <span>Mariano Carrozo - 09/10/2019 18:30 - PRESENTE</span>
        <i class="fa fa-angle-right"></i>
      </div>
    </div>
  </div>
</div>
</body>
</html>