<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/estiloThomy.css">
<link rel="stylesheet" href="css/Medico.css" type="text/css"><link>
<jsp:include page="Master_Admin.html" />

<title>Administrar medicos</title>

</head>

<body>

<br><br><br><br><br><br><br><br><br>

<hr style="width:1px;height:490px;position:absolute;left:600px">

<br>

<div style="position:relative;left:215px;top:10px">

<b><label class=lbl2>MEDICOS</label><br></b>

<b><label class=lbl2>AGREGAR MEDICO</label><br></b>

<br>


<label class=lbl2> DNI:  </label> 

&nbsp;

<input class=bonito name="txtDNI" type="number"  placeholder="11.111.111" style="position:relative;left:95px">

<br>
<br>

<label class=lbl2> Nº MATRICULA:  </label> 

&nbsp;

<input class=bonito name="txtNumeroMatricula" type="number" placeholder="Numero de matricula" style="position:relative;left:20px">

<br>
<br>

<label class=lbl2> NOMBRE:  </label> 

&nbsp;

<input class=bonito name="txtNombre" type="text" placeholder="Nombre" style="position:relative;left:60px">

<br>
<br>

<label class=lbl2> APELLIDO:  </label> 

&nbsp;

<input class=bonito name="txtApellido" type="text" placeholder="Apellido" style="position:relative;left:58px">

<br>
<br>

<label class=lbl2> DIRECCION:  </label> 

&nbsp;

<input class=bonito name="txtDireccion" type="text" placeholder="Calle y numero" style="position:relative;left:50px">

<br>
<br>

<label class=lbl2> PROVINCIA:  </label> 

&nbsp;

<select class=bonito name="ddlProvincia" style="position:relative;left:50px">
		<option value="01">Buenos Aires<option>
	</select>

<br>
<br>

<label class=lbl2> LOCALIDAD:  </label> 

&nbsp;

<select class=bonito name="ddlProvincia" style="position:relative;left:50px">
		<option value="01">Tigre<option>
	</select>
<br>
<br>

<label class=lbl2> TELEFONO:  </label> 

&nbsp;

<input class=bonito name="txtTelefono" type="phone" placeholder="Numero: 441112312" style="position:relative;left:50px">

<br>
<br>

<input class=bonito type="Button" name="btnAgregar" value="Agregar" >

</div>

<div style="position:relative;left:215px;top:60px;">

<b><label class=lbl2>AGREGAR ESPECIALIDAD</label></b>

<br>

<label class=lbl2>Medico</label>

<select name="ddlMedico">
	<option value="10000">Torres, Oscar Mauricio</option>
 </select>
<br>
<label class=lbl2>Especialidad</label>

<select name="ddlEspecialidad">
	<option value="1">Odontologia</option>
 </select>

 <br><br>
 
 <input class=bonito type="Button" name="btnAgregarEsp" value="Cargar Especialidad" >
</div>



<div class="container1" style="position:relative;left:320px;margin-top:-570px;">

  <div class="items">

    <div class="items-head">

      <p>Listado de medicos</p>

      <hr>

    </div>

    <div class="items-body">

      <div class="items-body-content">

        <span style="color: black">DNI: 11.111.111</span> 

        <br>

        <span style="color: black">Nº matricula: 1151</span>

        <br>



        <span style="color: black">Nombre: Pablo Sebastian</span>



        <br>
        <span style="color: black">Apellido: Bongiolatti</span>

        <br>
        <span style="color: black">Direccion: Don Bosco 934</span>

        <br>

		<span style="color: black">Localidad: Escobar</span>


        <br>
        <span style="color: black">Provincia: Buenos Aires</span>



        <br>
        <span style="color: black">Telefono: 3484671119</span>


        <br>
		<input style="width:80px" class="bonito" type ="button" name="btnModificar1" value="Modificar">

		&nbsp;

		<input style="width:80px" class="bonito" type="button" name ="btnEliminar1" value="Eliminar" >

		<br>

		

      </div>

	

      <div class="items-body-content">

        <span style="color: black">DNI: 22.222.222</span> 

        <br>

        <span style="color: black">Nº matricula: 2223</span>

        <br>



        <span style="color: black">Nombre: Lucas</span>



        <br>
        <span style="color: black">Apellido: Franco Feldman</span>

        <br>
        <span style="color: black">Direccion: Benvenutti 321</span>

        <br>

		<span style="color: black">Localidad: Gral. Paz</span>


        <br>
        <span style="color: black">Provincia: Buenos Aires</span>



        <br>
        <span style="color: black">Telefono: 3552224412</span>


        <br>
		<input style="width:80px" class="bonito" type ="button" name="btnModificar2" value="Modificar">

		&nbsp;

		<input style="width:80px" class="bonito" type="button" name ="btnEliminar2" value="Eliminar" >

		<br>

		

      </div>

      </div>

    </div>

  </div>

 






</body>

</html>

