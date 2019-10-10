<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Medico.css" type="text/css"><link>
<jsp:include page="Master_Medico.html" />
<title>Turnos | Hospital Frenz</title>
</head>
<body>
<div class="container1">
  <div class="items">
    <div class="items-head">
      <p>Turnos pendientes</p>
      <hr>
    </div>
    
    <div class="items-body">
      <div class="items-body-content">
        <span>Claudia Cintia Morales - 14/10/2019 14:05 - PENDIENTE</span> 
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
      <p>Turnos pasados</p>
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