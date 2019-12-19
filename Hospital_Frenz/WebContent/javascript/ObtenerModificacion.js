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
		var DDL=document.getElementById("ddlTipo["+indice+"]");
		var Tipo=DDL.options[DDL.selectedIndex].text;
		
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
	if(tablaID=="tbPacientes")
	{
		document.getElementById("btnModificar["+indice+"]").setAttribute("type","submit");
		var DNI=document.getElementById("lblDNI["+indice+"]").innerText;
		var Nombre=document.getElementById("txtNombre["+indice+"]").value;
		var Apellido=document.getElementById("txtApellido["+indice+"]").value;
		var Direccion=document.getElementById("txtDireccion["+indice+"]").value;
		if(Nombre.trim()=="" || Apellido.trim()=="" || !!Direccion.trim()==""){
			
			alert("Complete los campos solicitados.");
			return;
		}else{
			
			consulta="UPDATE pacientes SET NombrePaciente='"+Nombre+"', ApellidoPaciente='"+Apellido+"', DireccionPaciente='"+Direccion+"' WHERE DNIPaciente='"+DNI+"'";
		}
		
		


	}
	
	

	document.getElementById("hdnConsulta["+indice+"]").value=consulta;
}
