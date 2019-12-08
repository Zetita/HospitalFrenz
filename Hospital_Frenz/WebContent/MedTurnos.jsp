<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="Master_Medico.html" />
<link rel="stylesheet" href="css/Medico.css" type="text/css"><link>
<title>Turnos | Hospital Frenz</title>
</head>
<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div>${usuario}</div></button>
</form>
<%	
		List<Turno> listaTurPen = new ArrayList<Turno>();
		if (request.getAttribute("listaTurPendientesM") != null) {
			listaTurPen = (List<Turno>) request.getAttribute("listaTurPendientesM");
		}
		List<Turno> listaTurPas = new ArrayList<Turno>();
		if (request.getAttribute("listaTurPasadosM") != null) {
			listaTurPas = (List<Turno>) request.getAttribute("listaTurPasadosM");
		}

 %>
<form method="post" action="ServletTurnos">
<div class="container1">
  <div class="items">
    <div class="items-head">
      <p>Turnos pendientes </p>
      <hr>
    </div>
    
    <%
    if(listaTurPen == null || listaTurPen.size() == 0){ 
     %>
    <br>
	<h2 style="margin-left:30px;">No hay informacion para mostrar. </h2>
	<br>
	<% }  else{
	
%><div class="items-body">
<% for (Turno t1 : listaTurPen) {%>

      <div class="items-body-content">
           <span style="font-weight:bold;"><%= t1.getPaciente().getApellido()%>, <%= t1.getPaciente().getNombre() %> - 
        <%= t1.getFecha() %> <%=t1.getHora().toString().substring(0,5) %> - PENDIENTE</span> 
        <br>
        <span>Especialidad: <%= t1.getEspecialidad().getDescripcion() %></span>
        <br>
        <span>Sede: <%=t1.getSede().getNombre()%></span>
        <br>
        <input type="hidden" name="idTurCancelarM" value=<%=t1.getId()%>>
        <input type="hidden" name="idSedeCancelarM" value=<%=t1.getSede().getId()%>>
        <input type="submit" class="buttonT" name="BtnCancelarxMed" value="Cancelar"><br>
       
        <input type="submit" class="buttonT2" name="BtnAsistio" value="Asistio"><br>
        <input type="submit" class="buttonT2" name="BtnAusente" value="Ausente">
        <i class="fa fa-angle-right"></i>
      </div>

	<% }%>
	</div>
 
<% }%>
           
    </div>
  </div>
</form>

<br>
<div class="container2">
  <div class="items">
    <div class="items-head">
      <p>Turnos pasados</p>
      <hr>
    </div>
    <%
    if(listaTurPas == null || listaTurPas.size() == 0){ 
     %>
     <br>
	<h2 style="margin-left:30px;">No hay informacion para mostrar. </h2>
	<br>
	<% }  else{
	
	%>	
     
    <div class="items-body">
    <% for (Turno t2 : listaTurPas) {
	
	String est;
	
	if(t2.getEstado()==-2 || t2.getEstado()==-1)
	{
		est="CANCELADO";
	}
	else if(t2.getAsistencia()==1){
		est="ASISTIO";
	}
	else{
		est="AUSENTE";	
    }
	
	%>
      <div class="items-body-content">
        <span style="font-weight:bold;"><%= t2.getPaciente().getApellido()%>, <%= t2.getPaciente().getNombre() %> - <%= t2.getFecha() %> 
        <%=t2.getHora().toString().substring(0,5)%> - <%= est %></span>
        <br>
        <span>Especialidad: <%= t2.getEspecialidad().getDescripcion() %></span>
        <br>
        <span>Sede: <%=t2.getSede().getNombre()%></span>
        <i class="fa fa-angle-right"></i>
      </div>
	<% }%>
	</div>

<% }%>
  </div>
</div>
<br>
</body>
</html>