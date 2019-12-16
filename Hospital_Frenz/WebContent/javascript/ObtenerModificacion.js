function ObtenerModificacion(boton,tablaID){

	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var consulta;	

	if(tablaID=="tbUsers")
	{
		document.getElementById("btnModificar["+indice+"]").setAttribute("type","submit");
		var DNI=document.getElementById("lblDNI["+indice+"]").innerText;
		var Contrasenia=document.getElementById("txtContrasenia["+indice+"]").value;		
		var Email=document.getElementById("txtEmail["+indice+"]").value;
		var Tipo=document.getElementById("ddlTipo["+indice+"]").text;
		
		if(Contrasenia.trim()!=""){	
			if(Email.trim()!=""){
			consulta="UPDATE USUARIOS SET ContraseniaUser = '"+Contrasenia+"', EmailUser ='"+Email+"', TipoUser ='"+Tipo+"' WHERE DNIUser LIKE '"+DNI+"'";	
			}
			else{
				alert("Email incorrecto.");
				return;
			}
		}
		else
		{
			alert("Contraseña incorrecta.");
			return;
		}
	}

	document.getElementById("hdnConsulta["+indice+"]").value=consulta;
}
