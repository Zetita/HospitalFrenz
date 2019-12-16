<%@ page import="java.util.*, entidad.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/EstiloAdmin.css">
<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>

<script type="text/javascript" src="javascript/jquery-3.4.1.js"></script>
<script type="text/javascript" src="javascript/FiltroDinamico.js"></script>
<script type="text/javascript" src="javascript/Modificar.js"></script>
<script type="text/javascript" src="javascript/ObtenerFiltro.js"></script>
<script type="text/javascript" src="javascript/ObtenerModificacion.js"></script>
<script type="text/javascript" src="javascript/ObtenerEliminar.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
<script type="text/javascript" src="javascript/IniciarTablas.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="Master_Admin.html" />

<title>Administrar coberturas medicas</title>

</head>

<body>
<br><br><br><br><br>

<br>

<div class="mitad1" style="width:56%">

<table id="tbCoberturas" style="width:100%">
			<thead>
			<tr>
				<th colspan="2"></th>
				<th>ID</th>
				<th>Nombre</th>
				<th>Tipo</th>
				<th>Costo</th>
				<th>Descripción</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			List<Cobertura> lst=new ArrayList<Cobertura>();

			  if(request.getAttribute("ListaCoberturas")!=null)
			  {
				  lst=(ArrayList<Cobertura>)request.getAttribute("ListaCoberturas");
			  }
			  
			  int indice=1;
			  for(int i=0;i<lst.size();i++){
				  try{
				  %>
				  <form method="post" action="ServletCoberturas?Indice=<%=indice%>">
				  	<tr>
				  		<td>
				  		<input type="button" id="btnModificar[<%=indice %>]" name="btnModificar[<%=indice %>]" style="font-size:10px"  value="Modificar">
				  		</td>
				  		<td><input type="submit" name="btnEliminar[<%=indice %>]" id="btnEliminar[<%=indice %>]" style="font-size:10px" value="Eliminar"></td>
				  		<td><label id="lblID[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getIdCobertura()%></label></td>
				  		<td><label id="lblNombre[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getNombre() %></label></td>
				  		<td><label id="lblTipo[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getTipo()%></label></td>
				  		<td><label id="lblCosto[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getCosto()%></label></td>
				  		<td><label id="lblDesc[<%=indice%>]" style="font-size:10px"><%=lst.get(i).getDescripcion()%></label></td>
				  		
				  	</tr>
				  </form>
				  <%
				  indice++;
				  }
				  catch(Exception e){
					  
				  }
				  
			  }
			  
				%>
				</tbody>
		</table>

</div>

<div class="mitad2">
	
<form method="post" action="ServletCoberturas">

<b><label>COBERTURAS MEDICAS</label></b><br>
<br>
<b><label>AGREGAR COBERTURAS</label><br></b>
<br>
	<% 
			
			int cant;

			  if(request.getAttribute("CantCoberturas")!=null)
			  {
				  cant=request.getAttribute("CantCoberturas");
			  }
			  
			  %>
	
<label> ID DE COBERTURA: <%=cant+1%> </label> 

<input name="txtIdCobertura" type="hidden" value="<%=cant+1%>"style="position:relative;left:70px">

<br>
<br>

<label> NOMBRE DE COBERTURA:  </label> 


<input name="txtNombreCobertura" type="text" placeholder="Nombre de la cobertura" style="position:relative;left:20px">

<br>
<br>

<label> TIPO DE COBERTURA:  </label> 


<input name="txtTipoCobertura" type="text" placeholder="Tipo de cobertura" style="position:relative;left:50px">

<br>
<br>

<label> COSTO DE COBERTURA:  </label> 


<input name="txtCostoCobertura" type="number" placeholder="Costo de cobertura" style="position:relative;left:50px">

<br>
<br>

<label> DESCRIPCIÓN DE COBERTURA:  </label> 


<textarea name="txtDescCobertura" placeholder="Descripción de cobertura" style="position:relative;left:50px">
</textarea>

<br>
<br>

<input type="Submit" style="width:100%" name="btnAgregarCob" value="Agregar cobertura" >

</form>

</div>

</body>
</html>
