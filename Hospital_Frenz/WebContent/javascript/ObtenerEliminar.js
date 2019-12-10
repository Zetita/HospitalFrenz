function ObtenerEliminar(boton,tablaID){

	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var DNI;	

	if(tablaID=="tbUsers")
	{

		DNI=y[5].find("lblDNI["+indice+"]").value;	
		
	}

	document.getElementById("hdnConsulta").value=DNI;
}
