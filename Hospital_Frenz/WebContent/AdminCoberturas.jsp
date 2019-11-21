<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/Medico.css" type="text/css"><link>

<jsp:include page="Master_Admin.html" />

<title>Administrar coberturas medicas</title>

</head>

<body>



<br>

<br>

<br>

<br>

<br>

<hr style="width:1px;height:490px;position:absolute;left:680px">





<br>



<div style="position:relative;left:215px;top:10px">

<b><label class=lbl2>COBERTURAS MEDICAS</label><br></b>

<br>


<b><label class=lbl2>AGREGAR COBERTURAS</label><br></b>

<br>


<label class=lbl2> ID DE COBERTURA:  </label> 

&nbsp;

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



<div class="container1" style="position:absolute;left:720px;margin-top:-280px;">

  <div class="items">

    <div class="items-head">

      <p>Listado de coberturas</p>

      <hr>

    </div>

    

    <div class="items-body">

      <div class="items-body-content">

        <span style="color: black">ID de cobertura: 1</span> 

        <br>

        <span style="color: black">Nombre: Basica</span>

        <br>



        <span style="color: black">No cubre odontologia</span>



        <br>

		<input style="width:80px" class="bonito" type ="button" name="btnModificar1" value="Modificar">

		<br>

		<input style="width:80px" class="bonito" type="button" name ="btnEliminar1" value="Eliminar" >

		<br>

		

      </div>

      <div class="items-body-content">

		<span style="color: black">ID de cobertura: 2</span> 

        <br>

        <span style="color: black">Nombre: Intermedia</span>

        <br>

        <span style="color: black">Cubre odontologia hasta 18 años</span>

        <br>

		<input style="width:80px" class="bonito" type ="button" name="btnModificar2" value="Modificar">

		<br>

		<input style="width:80px" class="bonito" type="button" name ="btnEliminar2" value="Eliminar" >

		<br>

      </div>

      <div class="items-body-content">

        <span style="color: black">ID de cobertura: 3</span> 

        <br>

        <span style="color: black">Nombre: Completa</span>

        <br>

		<input style="width:80px" class="bonito" type ="button" name="btnModificar3" value="Modificar">

		<br>

		<input style="width:80px" class="bonito" type="button" name ="btnEliminar3" value="Eliminar" >

        <br>

        

        <br>

      </div>

      </div>

    </div>

  </div>


</body>

</html>
