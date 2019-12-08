<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="Master_Admin.html" />

<title>Administrar coberturas medicas</title>

</head>

<body>
<br><br><br><br><br>

<hr style="width:1px;height:490px;position:absolute;left:680px">
<br>

<div style="position:relative;left:215px;top:10px">

<b><label class=lbl2>COBERTURAS MEDICAS</label></b><br>
<br>
<b><label class=lbl2>AGREGAR COBERTURAS</label><br></b>
<br>
<label class=lbl2> ID DE COBERTURA:  </label> 



<input class=bonito name="txtIdCobertura" type="number"  placeholder="ID" style="position:relative;left:70px">

<br>

<br>

<label class=lbl2> NOMBRE DE COBERTURA:  </label> 

&nbsp;

<input class=bonito name="txtNombreCobertura" type="text" placeholder="Nombre de la cobertura" style="position:relative;left:20px">

<br>

<br>

<label class=lbl2> TIPO DE COBERTURA:  </label> 

&nbsp;

<input class=bonito name="txtTipoCobertura" type="text" placeholder="Tipo de cobertura" style="position:relative;left:50px">

<br>

<br>

<br>

<input class=bonito type="Button" name="btnAgregar" value="Agregar cobertura" >

</div>






</body>
</html>
