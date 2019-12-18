function ObtenerEliminar(boton,tablaID){
	
	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var DNI,DNI2;	
	
	if(tablaID=="tbUsers")
	{
		
		DNI=y[5].childNodes[0].innerText;	
	}
	if(tablaID=="tbPacientes")
	{
		DNI2=y[2].childNodes[0].innerText;
		alert(DNI);
	}
	
	
	
	document.getElementById("hdnConsulta["+indice+"]").value=DNI;
	document.getElementById("hdnConsulta["+indice+"]").value=DNI2;
	
	
	
}
