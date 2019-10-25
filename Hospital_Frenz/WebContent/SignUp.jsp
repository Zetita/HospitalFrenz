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
            <div class="textbox">
                <i class="fa fa-id-card" aria-hidden="true"></i>
                <input type="text" placeholder="12.345.678" name="txtDNISU" value="">
            </div>
            <div class="textbox">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <input type="email" placeholder="email@email.com" name="txtEmailSU" value="">
            </div>
            <div class="textbox">
                <i class="fa fa-user" aria-hidden="true"></i>
                <input type="text" placeholder="usuario" name="txtUserSU" value="">
            </div>

            <div class="textbox">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <input type="password" placeholder="contraseña" name="txtPassSU" value="">
            </div>

            <input type="submit" class="btn" name="btnAceptarSI" value="Aceptar">
            
      </div>
</body>
</html>