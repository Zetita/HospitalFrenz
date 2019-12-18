function modificar(boton,tablaID)
{
	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	
	
	
	if(tablaID=="tbUsers")
	{
		var btnModificar=document.getElementById("btnModificar["+indice+"]");
		//y[0].removeChild(btnModificar);
				
		//btnModificar=document.createElement("input");
		btnModificar.setAttribute("name","btnModificar["+indice+"]");
		btnModificar.setAttribute("id","btnModificar["+indice+"]");
		btnModificar.setAttribute("onclick","ObtenerModificacion(this,'tbUsers')");
		btnModificar.setAttribute("value","Aceptar");
		btnModificar.setAttribute("style","font-size:10px");
		//y[0].appendChild(btnModificar);
		
		
		var lblContrasenia=document.getElementById("lblContrasenia["+indice+"]");
		var Contrasenia=lblContrasenia.innerText;
		y[3].removeChild(lblContrasenia);
		
		lblContrasenia=document.createElement("input");
		lblContrasenia.setAttribute("id","txtContrasenia["+indice+"]");
		lblContrasenia.setAttribute("type","text");
		lblContrasenia.setAttribute("style","font-size:10px");
		lblContrasenia.value=Contrasenia;
		y[3].appendChild(lblContrasenia);
		
		var lblEmail=document.getElementById("lblEmail["+indice+"]");
		var Email=lblEmail.innerText;
		y[4].removeChild(lblEmail);
		
		lblEmail=document.createElement("input");
		lblEmail.setAttribute("id","txtEmail["+indice+"]");
		lblEmail.setAttribute("type","email");
		lblEmail.setAttribute("style","font-size:10px");
		lblEmail.value=Email;
		y[4].appendChild(lblEmail);
		
		var lblTipo=document.getElementById("lblTipo["+indice+"]");
		var Tipo=lblTipo.innerText;
		y[6].removeChild(lblTipo);
		
		lblTipo=document.createElement("select");
		lblTipo.setAttribute("id","ddlTipo["+indice+"]");
		lblTipo.setAttribute("style","font-size:10px");
		
		/*var opcion1=document.createElement("option");
   		var opcion2=document.createElement("option");
   		var opcion3=document.createElement("option");
   		opcion1.text="Medico";
   		opcion2.text="Paciente";
   		opcion3.text="Administrador";
   		opcion1.value="med";
   		opcion2.value="pac";
   		opcion3.value="adm";
   		
		switch(Tipo){
			case "Medico":
				opcion1.setAttribute("selected","selected");
			break;
			case "Paciente":
				opcion2.setAttribute("selected","selected");
			break;
			case "Administrador":
				opcion3.setAttribute("selected","selected");
			break;
		}
		
   		lblTipo.add(opcion1);
   		lblTipo.add(opcion2);
   		lblTipo.add(opcion3);
   		
   		y[6].appendChild(lblTipo);
   		*/
	}
	
	if(tablaID=="tbPacientes")
	{
		var btnModificar=document.getElementById("btnModificar["+indice+"]");
		//y[0].removeChild(btnModificar);
				
		//btnModificar=document.createElement("input");
		btnModificar.setAttribute("name","btnModificar["+indice+"]");
		btnModificar.setAttribute("id","btnModificar["+indice+"]");
		btnModificar.setAttribute("onclick","ObtenerModificacion(this,'tbPacientes')");
		btnModificar.setAttribute("value","Aceptar");
		btnModificar.setAttribute("style","font-size:10px");
		//y[0].appendChild(btnModificar);
		
		
		var lblNombre=document.getElementById("lblNombre["+indice+"]");
		var Nombre=lblNombre.innerText;
		y[3].removeChild(lblNombre);
		
		lblNombre=document.createElement("input");
		lblNombre.setAttribute("id","txtNombre["+indice+"]");
		lblNombre.setAttribute("type","text");
		lblNombre.setAttribute("style","font-size:10px");
		lblNombre.value=Nombre;
		y[3].appendChild(lblNombre);
		
		var lblApellido=document.getElementById("lblApellido["+indice+"]");
		var Apellido=lblApellido.innerText;
		y[4].removeChild(lblApellido);
		
		lblApellido=document.createElement("input");
		lblApellido.setAttribute("id","txtApellido["+indice+"]");
		lblApellido.setAttribute("type","text");
		lblApellido.setAttribute("style","font-size:10px");
		lblApellido.value=Apellido;
		y[4].appendChild(lblApellido);
		
		var lblDireccion=document.getElementById("lblDireccion["+indice+"]");
		var Direccion=lblDireccion.innerText;
		y[5].removeChild(lblDireccion);
		
		lblDireccion=document.createElement("input");
		lblDireccion.setAttribute("id","txtDireccion["+indice+"]");
		lblDireccion.setAttribute("type","text");
		lblDireccion.setAttribute("style","font-size:10px");
		lblDireccion.value=Direccion;
		y[4].appendChild(lblDireccion);
		
		
		
		
		var lblTipo=document.getElementById("lblTipo["+indice+"]");
		var Tipo=lblTipo.innerText;
		y[6].removeChild(lblTipo);
		
		lblTipo=document.createElement("select");
		lblTipo.setAttribute("id","ddlTipo["+indice+"]");
		lblTipo.setAttribute("style","font-size:10px");
		
		/*var opcion1=document.createElement("option");
   		var opcion2=document.createElement("option");
   		var opcion3=document.createElement("option");
   		opcion1.text="Medico";
   		opcion2.text="Paciente";
   		opcion3.text="Administrador";
   		opcion1.value="med";
   		opcion2.value="pac";
   		opcion3.value="adm";
   		
		switch(Tipo){
			case "Medico":
				opcion1.setAttribute("selected","selected");
			break;
			case "Paciente":
				opcion2.setAttribute("selected","selected");
			break;
			case "Administrador":
				opcion3.setAttribute("selected","selected");
			break;
		}
		
   		lblTipo.add(opcion1);
   		lblTipo.add(opcion2);
   		lblTipo.add(opcion3);
   		
   		y[6].appendChild(lblTipo);*/
		
	}

}
