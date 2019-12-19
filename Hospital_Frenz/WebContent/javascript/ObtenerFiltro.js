function ObtenerFiltro(tablaID){
    ///Preparar consulta y obtener tabla
    var Filtro="SELECT ";
    var Tabla=document.getElementById(tablaID);
    ///Seleccionar tipo de datos según tabla
    if(tablaID=="tbFiltroUser"){
        Filtro+="* FROM Usuarios WHERE ";
    }
    if(tablaID=="tbFiltroTurnosUser"){
        Filtro+="* FROM Turnos INNER JOIN medicos ON medicos.MatriculaMed=turnos.IDMatriculaMed INNER JOIN especialidades ON especialidades.IDEspecialidad=turnos.IDEspecialidad INNER JOIN sedes on sedes.IDSede=turnos.IDSede WHERE";
    }
    ///Armar Consulta
    for(var i=0;i<Tabla.rows.length;i++){
        ///Diferenciar por tabla
        if(tablaID=="tbFiltroUser"){;
            ///Obtener valores
        	if(i!=0){
            var Filtro1=document.getElementById("ddlFiltro1["+i+"]").value;
        	}
            var Tipo=document.getElementById("ddlTipo["+i+"]").value;
            var Filtro2=document.getElementById("ddlFiltro2["+i+"]").value;
            var Dinamico=document.getElementById("dinamico["+i+"]").value;
            ///Verificar que no sean vacíos
            if(Tipo!="-"&&Filtro2!="-"&&Dinamico!="-"&&Dinamico!="")
            {
	            switch(Filtro1){
	                case "Y":
	                    Filtro+="AND ";
	                break;
	                case "Y NO":
	                    Filtro+="NOT ";
	                break;
	                case "O":
	                    Filtro+="O ";
	                break;
	                case "O NO":
	                    Filtro+="NOT ";
	                break;
	            }	

	            switch(Tipo){
	                case "1":
	                    Filtro+="NombreUser ";
	                break;
	                case "2":
	                    Filtro+="EmailUser ";
	                break;
	                case "3":
	                    Filtro+="DNIUser ";
	                break;
	                case "4":
	                    Filtro+="TipoUser ";
	                break;
	                case "5":
	                    Filtro+="Estado ";
	                break;
                }
        
                switch(Filtro2){
                	case "1":
                		switch(Tipo){
	                        case "1":
	                        case "2":
	                        case "3":
	                        case "4":
	                        Filtro+="LIKE '%"+Dinamico+"%' ";
	                        break;
	                        case "5":
	                        Filtro+="="+Dinamico+" ";
	                        break;
                		}
                	break;
                    case "2":
                    switch(Tipo){
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            Filtro+="NOT LIKE '%"+Dinamico+"%' ";
                        break;
                        case "5":
                            Filtro+="!="+Dinamico+" ";
                        break;
                    }
                    break;
                    }
            }
            else{
                alert("Complete los datos.");
                Filtro="Select * from Usuarios"
            }
        }
        
        else if(tablaID=="tbFiltroTurnosUser"){;
        ///Obtener valores
    	if(i!=0){
        var Filtro1=document.getElementById("ddlFiltro1["+i+"]").value;
    	}
        var Tipo=document.getElementById("ddlTipo["+i+"]").value;
        var Filtro2=document.getElementById("ddlFiltro2["+i+"]").value;
        var Dinamico=document.getElementById("dinamico["+i+"]").value;
        ///Verificar que no sean vacíos
        if(Tipo!="-"&&Filtro2!="-"&&Dinamico!="-"&&Dinamico!="")
        {
            switch(Filtro1){
                case "Y":
                    Filtro+="AND ";
                break;
                case "Y NO":
                    Filtro+="NOT ";
                break;
                case "O":
                    Filtro+="O ";
                break;
                case "O NO":
                    Filtro+="NOT ";
                break;
            }	

            switch(Tipo){
                case "1":
                    Filtro+="Medicos.NombreMed ";
                break;
                case "2":
                    Filtro+="Medicos.ApellidosMed ";
                break;
                case "3":
                    Filtro+="Especialidades.DescripcionEspecialidad ";
                break;
                case "4":
                    Filtro+="Sedes.NombreSede ";
                break;
            }
    
            switch(Filtro2){
            	case "1":
                        Filtro+="LIKE '%"+Dinamico+"%' ";
            	break;
                case "2":

                        Filtro+="NOT LIKE '%"+Dinamico+"%' ";

                break;
                }
        }
        else{
            alert("Complete los datos.");
            Filtro="Select * from Turnos"
        }
    }
    }
    ///Agregar a input type hidden
    
    document.getElementById("hdnConsulta").value=Filtro;
}