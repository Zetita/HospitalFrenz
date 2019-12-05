<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/slider.css">
<jsp:include page="Master_Inicio.html" />
<script type="text/javascript" src="css/slider.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body> 
<div class="container-fluid main">


  <div id="myCarousel" class="carousel carousel-fade slide" data-ride="carousel" data-interval="3000">
    <div class="carousel-inner" role="listbox">
      <div class="item active background a"></div>
    </div>
  </div>
  
  <div class="covertext">
    <div class="col-lg-10" style="float:none; margin:0 auto;">
      <h1 class="title">HOSPITAL FRENZ</h1>
      <h3 class="subtitle">Proteccion integral a tu salud.</h3>
    </div>
    <div class="col-xs-12 explore">
      <a href="Login.jsp"><button type="button" class="btn btn-lg explorebtn">INGRESA</button></a>
       <a href="SignUp.jsp"><button type="button" class="btn btn-lg explorebtn">REGISTRATE</button></a>
    </div>
  </div>
</div>

</body>
</html>