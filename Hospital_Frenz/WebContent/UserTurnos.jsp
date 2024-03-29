<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="Master_User.html" />
<link rel="stylesheet" href="css/Medico.css" type="text/css"><link>

<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
<script type="text/javascript" src="javascript/FiltroDinamico.js"></script>
<script type="text/javascript" src="javascript/jquery-3.4.1.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
<script type="text/javascript" src="javascript/IniciarTablas.js"></script>
<title>Turnos | Hospital Frenz</title>

</head>
<body>
<form method="post" action="ServletUsuarios">
<button class="btnUser" type="submit" name="btnLogOff" data-hover="Cerrar sesion"><div>${usuario}</div></button>
</form>
<%	
		int indice=0;
		List<Turno> listaTurPen = new ArrayList<Turno>();
		if (request.getAttribute("listaTurPendientes") != null) {
			listaTurPen = (List<Turno>) request.getAttribute("listaTurPendientes");
			
		}
		List<Turno> listaTurPas = new ArrayList<Turno>();
		if (request.getAttribute("listaTurPasados") != null) {
			listaTurPas = (List<Turno>) request.getAttribute("listaTurPasados");
		}

 %>
  <%-- 
	<table id="tbFiltroTurnosUser" style="width:100%;border:2px solid black">

			<tr>
				<td style="border:none">
					<input type="submit" id="btnAgregar" value="+" onclick="agregarFila('tbFiltroTurnosUser')" >
				</td>
				<td style="border:none">
					<select id="ddlFiltro1[0]">
						<option value="-">-<option>
					</select>
				</td >
				<td style="border:none">
					<select id="ddlTipo[0]">
						<option value="-">-</option>
						<option value="1">Nombre</option>
						<option value="2">Apellido</option>
						<option value="3">Especialidad</option>
						<option value="4">Sede</option>
					</select>
				</td>
				<td style="border:none">
					<select id="ddlFiltro2[0]">
						<option value="-">-</option>
						<option value="1">Contiene</option>
						<option value="2">No contiene</option>
					</select>
				</td>
				<td style="text-align:center;border:none"> <input type="text" id="dinamico[0]"></input>
				</td>
			</tr>
		</table>
		
		<form method="post" action="ServletTurnos">
		<input type="Hidden" id="hdnConsulta" name="hdnConsulta"/>
		<input type="submit" id="btnFiltrar" name="btnFiltrar" style="width:94%" value="Filtrar" onclick="ObtenerFiltro('tbFiltroTurnosUser')">
	</form>
  --%>
  <% if(request.getAttribute("Mensaje")!=null){
	%>
	<script type="text/javascript">
		alert("<%=request.getAttribute("Mensaje")%>")
	</script>
	<%
	request.setAttribute("Mensaje",null);
	}
	%>
<form method="post" action="ServletTurnos">
 <br>
 <input type="text" id="txtBuscarTur1" name="txtbuscartur1" style="padding: .10rem .70rem;margin-left:360px; border-radius:10px;"/>
 <input type="submit" name="BtnBuscarTur1" class="btn btn-primary" style="margin-left:20px;"value="Buscar">
 <input type="submit" name="BtnMostrarTodosTur" class="btn btn-primary" style="margin-left:20px;"value="Mostrar todos">
</form>

<table id="tbTurnosPac1" style="margin-left: 360px;">
 <form method="post" action="ServletTurnos?Indice=<%=indice%>">

<div class="container1">
  <div class="items">
    <div class="items-head">
   
     <p>Turnos recientes <input type="submit" name="BtnTurno" value="Solicitar Turno" class="btn btn-primary" style="margin-left:20px;"> </p>
      <hr>
     
    </div>
    <%
    if(listaTurPen == null || listaTurPen.size() == 0){ 
     %>


     <tr>
	<h2 style="margin-left: 360px; background-color:white; width:800px;">No hay informacion para mostrar. </h2>
	<% }  else{
	
%>	
<%	 
for (Turno t1 : listaTurPen) {%>
	
	<td>
        <span style="font-weight:bold;">Dr/a. <%= t1.getMedico().getApellido()%>, <%= t1.getMedico().getNombre() %> - 
        <%= t1.getFecha() %> <%=t1.getHora().toString().substring(0,5) %> - PENDIENTE</span> 
        <br>
        <span>Especialidad: <%= t1.getEspecialidad().getDescripcion() %></span>
        <br>
        <span>Sede: <%=t1.getSede().getNombre()%></span>
        <br>
        <input type="hidden" name="idTurCancelar" value="<%=t1.getId()%>">
        <input type="hidden" name="idSedeCancelar" value="<%=t1.getSede().getId()%>">
        <input type="submit" class="buttonT" name="BtnCancelarxUser" value="Cancelar">
     </td>
     
     <td>
     	<input type="hidden" name="lblMedico" value="<%=t1.getMedico().getMatricula()%>">
        <input type="hidden" name="lblFecha" value="<%=t1.getFecha()%>">
        <input type="hidden" name="lblEspecialidad" value="<%=t1.getEspecialidad().getId() %>">
        <input type="hidden" name="lblSede" value="<%= t1.getSede().getId()%>">
     </td>
        <i class="fa fa-angle-right"></i>
      </tr>
      
	
<tr class="trNone"></tr>
	<% }%>
 
<% }%>

           
    </div>
  </div>
</form>
</table>
<br>

<div class="container2">
  <div class="items">
    <div class="items-head">
      <p>Historial de turnos</p>
      <hr>
    </div>
    <%
    if(listaTurPas == null || listaTurPas.size() == 0){ 
     %>
    <br>
	<h2 style="margin-left:30px;">No hay informacion para mostrar. </h2>
	<br>
	<% }  else{
	
	%>	<div class="items-body">
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
        <span style="font-weight:bold;">Dr/a.<%= t2.getMedico().getApellido()%>, <%= t2.getMedico().getNombre() %> - <%= t2.getFecha() %> 
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
