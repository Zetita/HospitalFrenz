<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estilo.css" type="text/css"><link>
</head>
<header>
<div class="container">
    <div class="logo-box">
      <a href="Inicio.jsp">
        <img src="Recursos/logo8.png">
      </a>
    </div>
   </div>
</header>
<body>

<script type="text/javascript" >

function Asignar()
{
	sessionStorage.setItem("NombreUser", document.getElementById("txtUserLI").value);
}
</script> 

	<div class="login-box">
            <h1>Ingresa</h1>
            <form method="post" action="ServletUsuarios">
            <div class="textbox">
                <i class="fa fa-user" aria-hidden="true"></i>
                <input type="text" placeholder="Usuario" id="txtUserLI" name="txtUserLI" value="">
            </div>

            <div class="textbox">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <input type="password" placeholder="Contrase�a" name="txtPassLI" value="">
            </div>
			<span style="color:red"><%=(request.getAttribute("errorMessage") == null) ? ""
 : request.getAttribute("errorMessage")%></span>
            <input type="submit" class="btn" name="btnAceptarLI" value="Entrar" onclick="Asignar()">
            </form>
            �A�n no ten�s usuario? <a href="ServletUsuarios?Param=signup">Hac� click ac� para Registrarte</a>
      </div>
</body>
</html>