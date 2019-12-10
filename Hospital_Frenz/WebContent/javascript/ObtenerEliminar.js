function ObtenerEliminar(boton,tablaID){

	var indice=boton.parentNode.parentNode.rowIndex;
	var x=document.getElementById(tablaID).rows;
	var y=x[indice].cells;
	var consulta;	

	if(tablaID=="tbUsers")
	{

		consulta="DELETE FROM USUARIOS WHERE DNI LIKE '"+DNI+"'";	
		
	}

	document.getElementById("hdnConsulta").value=consulta;
}