function ObtenerFiltro(IDTabla){
    ///Preparar consulta y obtener tabla
    var Filtro="SELECT ";
    var Tabla=document.getElementById(IDTabla);
    ///Seleccionar tipo de datos según tabla
    if(IDTabla=="tbFiltroUser"){
        Filtro+="* FROM Usuarios WHERE ";
    }
    ///Armar Consulta
    for(var i=0;i<Tabla.lenght;i++){
        ///Diferenciar por tabla
        if(IDTabla=="tbFiltroUser"){
            ///Obtener valores
            var Filtro1=document.getElementById("ddlFiltro1["+i+"]").value;
            var Tipo=document.getElementById("ddlTipo["+i+"]").value;
            var Filtro2=document.getElementById("ddlFiltro2["+i+"]").value;
            var Dinamico=document.getElementById("dinamico["+i+"]").value;
            ///Verificar que no sean vacíos
            if(Filtro1!=="-"||Tipo!="-"||Filtro2!="-"||Dinamico!="-"||Dinamico!="")
            {
            switch(Filtro1){
                case "Y":
                    Filtro+="AND ";
                break;
                case "Y NO":
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
                        Filtro+="LIKE '%"+Dinamico+"%'";
                        break;
                        case "4":
                        case "5":
                        Filtro+="="+Dinamico;
                        break;
                    }
                break;
                    case "2":
                    switch(Tipo){
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            Filtro+="NOT LIKE '%"+Dinamico+"%'";
                        break;
                        case "5":
                            Filtro+="!="+Dinamico;
                        break;
                    }
                    break;
                    }
            }
            else{
                alert("Complete los datos.");
                return;
            }
        }
    }
    ///Agregar a input type hidden
    document.getElementById("Consulta").value=Filtro;
}