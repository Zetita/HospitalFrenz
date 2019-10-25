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
            <h1>Ingresa</h1>
            <form method="post" action="ServletUsuarios">
            <div class="textbox">
                <i class="fa fa-user" aria-hidden="true"></i>
                <input type="text" placeholder="Usuario" name="txtUserLI" value="">
            </div>

            <div class="textbox">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <input type="password" placeholder="Contraseña" name="txtPassLI" value="">
            </div>

            <input type="submit" class="btn" name="btnAceptarLI" value="Entrar">
            </form>
            ¿Aún no tenés usuario? <a href="ServletUsuarios?Param=signup">Hacé click acá para Registrarte</a>
      </div>
</body>
</html>