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
      <a href="/">
        <img src="Recursos/logo8.png">
      </a>
    </div>
   </div>
</header>
<body>
	<div class="login-box">
            <h1>Registrate</h1>
<form method="post" action="ServletUsuarios">
            <div class="textbox">
                <i class="fa fa-id-card" aria-hidden="true"></i>
                <input type="text" placeholder="12345678" name="txtDNISU" value="" required>
            </div>
            <span style="color:red"><%=(request.getAttribute("errorMessage2") == null) ? ""
 : request.getAttribute("errorMessage2")%></span>
            <div class="textbox">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <input type="email" placeholder="email@email.com" name="txtEmailSU" value=""  required>
            </div>
            <div class="textbox">
                <i class="fa fa-user" aria-hidden="true"></i>
                <input type="text" placeholder="usuario" name="txtUserSU" value="" required>
            </div>

            <div class="textbox">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <input type="password" placeholder="contraseña" name="txtPassSU" value="" required>
            </div>

            <input type="submit" class="btn" name="btnAceptarSU" value="Aceptar">
            </form>
            <span style="color:green"><%=(request.getAttribute("bienMessage") == null) ? ""
 : request.getAttribute("bienMessage")%></span>
 <span style="color:red"><%=(request.getAttribute("errorMessage3") == null) ? ""
 : request.getAttribute("errorMessage3")%></span>
      </div>
</body>
</html>