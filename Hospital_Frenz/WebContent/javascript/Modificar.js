function modificar(boton,tablaID)
{
	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	
	
	
	if(tablaID=="tbUsers")
	{
		var btnModificar=document.getElementById("btnModificar["+indice+"]");
		y[0].removeChild(btnModificar);
				
		btnModificar=document.createElement("input");
		btnModificar.setAttribute("id","btnModificar["+indice+"]");
		btnModificar.setAttribute("type","submit");
		btnModificar.setAttribute("onclick","location.href='ServletUsuarios?Param=admin'");
		btnModificar.setAttribute("value","Aceptar");
		btnModificar.setAttribute("style","font-size:10px");
		btnModificar.classList.add("boton");
		y[0].appendChild(btnModificar);
		
		var lblContrasenia=document.getElementById("lblContrasenia["+indice+"]");
		y[3].removeChild(lblContrasenia);
		
		lblContrasenia=document.createElement("input");
		lblContrasenia.setAttribute("id","txtContrasenia["+indice+"]");
		lblContrasenia.setAttribute("type","text");
		lblContrasenia.setAttribute("style","font-size:10px");
		lblContrasenia.classList.add("bonito");
		y[3].appendChild(lblContrasenia);
		
		var lblEmail=document.getElementById("lblEmail["+indice+"]");
		y[4].removeChild(lblEmail);
		
		lblEmail=document.createElement("input");
		lblEmail.setAttribute("id","txtEmail["+indice+"]");
		lblEmail.setAttribute("type","email");
		lblEmail.setAttribute("style","font-size:10px");
		lblEmail.classList.add("bonito");
		y[4].appendChild(lblEmail);
		
		var lblTipo=document.getElementById("lblTipo["+indice+"]");
		y[6].removeChild(lblTipo);
		
		lblTipo=document.createElement("select");
		lblTipo.setAttribute("id","ddlTipo["+indice+"]");
		lblTipo.setAttribute("style","font-size:10px");
		lblTipo.classList.add("bonito");
		
		var opcion1=document.createElement("option");
   		var opcion2=document.createElement("option");
   		var opcion3=document.createElement("option");
   		opcion1.text="Medico";
   		opcion2.text="Paciente";
   		opcion3.text="Administrador";
   		opcion1.value="med";
   		opcion2.value="pac";
   		opcion3.value="adm";
		
   		lblTipo.add(opcion1);
   		lblTipo.add(opcion2);
   		lblTipo.add(opcion3);
   		
   		y[6].appendChild(lblTipo);
	}
}