function ObtenerModificacion(boton,tablaID){

	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var consulta;	

	if(tablaID=="tbUsers")
	{
		var DNI=document.getElementById("lblDNI["+indice+"]").value;
		var Contrasenia=document.getElementById("lblContrasenia["+indice+"]").value;		
		var Email=document.getElementById("lblEmail["+indice+"]").value;
		var Tipo=document.getElementById("lblTipo["+indice+"]").value;
		
		consulta="UPDATE USUARIOS SET ContraseniaUser = '"+Contrasenia+"', EmailUser ='"+Email+"', TipoUser ='"+Tipo+"' WHERE DNI LIKE '"+DNI+"'";	
		
	}

	document.getElementById("hdnConsulta").value=consulta;
	return consulta;
}
