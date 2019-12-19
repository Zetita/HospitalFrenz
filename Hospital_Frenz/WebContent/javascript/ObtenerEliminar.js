function ObtenerEliminar(boton,tablaID){
	
	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var DNI;	
	
	if(tablaID=="tbUsers")
	{
		
		DNI=y[5].childNodes[0].innerText;	
	}
	if(tablaID=="tbPacientes")
	{
		DNI=y[2].childNodes[0].innerText;
	}
	document.getElementById("hdnConsulta["+indice+"]").value=DNI;

}
function ObtenerAlta(boton,tablaID){
	
	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var DNI;

	if(tablaID=="tbPacientes")
	{
		DNI=y[2].childNodes[0].innerText;
	}
	document.getElementById("hdnConsulta["+indice+"]").value=DNI;

}