 	function agregarFila(tablaID) {

        var tabla = document.getElementById(tablaID);

        var cant = tabla.rows.length;
        
        if(cant <= 4){
        
	        var fila = tabla.insertRow(cant);
	        
	        ///CELDA 1
	        
	        var celda1 = fila.insertCell(0);
	        celda1.setAttribute("style","border:none");
	        
	        var elemento1 = document.createElement("input");
	        elemento1.type = "button";
	        elemento1.value="-"
	        elemento1.setAttribute("id","btn["+cant+"]");
	        elemento1.setAttribute("onclick","quitarFila('tbFiltro',this)");
	        elemento1.classList.add("bonito");
	        
	        celda1.appendChild(elemento1);
	
	        ///CELDA 2
	        
	        var celda2 = fila.insertCell(1);
	        celda2.setAttribute("style","border:none");
	        
	        var elemento2 = document.createElement("SELECT");
			elemento2.setAttribute("id","ddlFiltro1["+cant+"]");
	
			var opcion1=document.createElement("option");
	   		var opcion2=document.createElement("option");
	   		var opcion3=document.createElement("option");
	   		var opcion4=document.createElement("option");
	   		opcion1.text="Y";
	   		opcion2.text="Y NO";
	   		opcion3.text="O";
	   		opcion4.text="O NO";
	   		opcion1.value="Y";
	   		opcion2.value="Y NO";
	   		opcion3.value="O";
	   		opcion4.value="O NO";
	   		
	   		elemento2.add(opcion1);
	   		elemento2.add(opcion2);
	   		elemento2.add(opcion3);
	   		elemento2.add(opcion4);
	        elemento2.classList.add("bonito");
	
	        celda2.appendChild(elemento2);
	        
	        ///CELDA 3
	        
	        var celda3 = fila.insertCell(2);
	        celda3.setAttribute("style","border:none");
	        
	        var elemento3 = document.createElement("SELECT");
	        elemento3.setAttribute("id","ddlTipo["+cant+"]");
	        elemento3.setAttribute("onchange","diferenciar(this)");
	        
	        var opcion3=document.createElement("option");
	   		var opcion4=document.createElement("option");
	        var opcion5=document.createElement("option");
	   		var opcion6=document.createElement("option");
	   		var opcion7=document.createElement("option");
	        
	        opcion3.text="-";
	   		opcion4.text="Nombre de Usuario";
	   		opcion5.text="Email";
	   		opcion6.text="DNI";
	   		opcion7.text="Tipo de Usuario";
	   		opcion3.value="-";
	   		opcion4.value="1";
	   		opcion5.value="2";
	   		opcion6.value="3";
	   		opcion7.value="4";
	   		
	   		elemento3.add(opcion3);
	   		elemento3.add(opcion4);
	   		elemento3.add(opcion5);
	   		elemento3.add(opcion6);
	   		elemento3.add(opcion7);
	        elemento3.classList.add("bonito");
	   		
	        celda3.appendChild(elemento3);
	
	        ///CELDA 4
	        
	        var celda4 = fila.insertCell(3);
	        celda4.setAttribute("style","border:none");
	        
	        var elemento4 = document.createElement("SELECT");
	        
	        elemento4.setAttribute("id","ddlFiltro2["+cant+"]");
	        elemento4.setAttribute("onchange","columna(this)");
	        
	        elemento4.classList.add("bonito");
	        
	        celda4.appendChild(elemento4);
	        
	        ///CELDA 5
	        
	        var celda5 = fila.insertCell(4);
	        celda5.setAttribute("style","text-align:center;border:none");
	        var text=document.createTextNode("Completar datos");
	        var elemento5 = document.createElement("label");
	        
	        elemento5.setAttribute("id","dinamico["+cant+"]");
			elemento5.appendChild(text);
			
			celda5.appendChild(elemento5);
        }
    }

    function quitarFila(tablaID, boton) {
    	var indice=boton.parentNode.parentNode.rowIndex;
        var tabla = document.getElementById(tablaID);
        tabla.deleteRow(indice);
       
    }
    
    function diferenciar(ddl)
    {
    	 var indice = ddl.parentNode.parentNode.rowIndex;  	 
    	 var filtro2= document.getElementById("ddlFiltro2["+indice+"]");
    	 filtro2.length=0;
    	 var tipo= document.getElementById("ddlTipo["+indice+"]");
    	 var opcion1=document.createElement("option");
    	 var opcion2=document.createElement("option");
    	 var opcion3=document.createElement("option");
    	 
    	 if(tipo.value!="-"){
    	 switch(tipo.value)
    	 {
    		 case "1":
    		 case "2":
    		 case "3":
    			 opcion1.value="1";
    			 opcion1.text="Contiene";
    			 opcion2.value="2";
    			 opcion2.text="No contiene";
    			 break;
    		 case "4":
    			 opcion1.value="1";
    			 opcion1.text="Es";
    			 opcion2.value="2";
    			 opcion2.text="No es";
    			 break;
    		 } 
	    	 opcion3.value="-";
			 opcion3.text="-";
			 
			 filtro2.add(opcion3);
    		 filtro2.add(opcion1);
    		 filtro2.add(opcion2);
    	 }
    	 

    	 //Reinicio ultimo ddl
    	 
    	 var x=document.getElementById('tbFiltro').rows
		 var y=x[0].cells
		 
		 var text=document.createTextNode("Completar datos");
		 var elemento = document.getElementById("dinamico["+indice+"]");
		 y[4].removeChild(elemento);
			
		 elemento = document.createElement("label");
		 elemento.setAttribute("id","dinamico["+indice+"]");
		 elemento.appendChild(text);
			
		 y[4].appendChild(elemento);
    }
    
    function columna(ddl)
    {
    	var indice = ddl.parentNode.parentNode.rowIndex;
    	var filtro2= document.getElementById("ddlFiltro2["+indice+"]");
    	var texto=filtro2.options[filtro2.selectedIndex].innerHTML;
    	var x=document.getElementById('tbFiltro').rows
        var y=x[indice].cells
       
        
        if(texto=="Contiene"||texto=="No contiene")
    	{

    		var elemento = document.getElementById("dinamico["+indice+"]");
    		y[4].removeChild(elemento);
    		
    		elemento = document.createElement("input");
            elemento.type = "text";
            elemento.setAttribute("id","dinamico["+indice+"]");
            elemento.classList.add("bonito");
            y[4].appendChild(elemento);
    	}
    	else if(texto=="Es"||texto=="No es"){
    		var elemento = document.getElementById("dinamico["+indice+"]");
    		y[4].removeChild(elemento);
    		
    		elemento = document.createElement("SELECT");
    		elemento.setAttribute("id","dinamico["+indice+"]");
    		
    		var opcion1=document.createElement("option");
       		var opcion2=document.createElement("option");
       		opcion1.text="Medico";
       		opcion2.text="Paciente";
       		opcion1.value="Med";
       		opcion2.value="Pac";
       		
       		elemento.add(opcion1);
       		elemento.add(opcion2);
            elemento.classList.add("bonito");
            y[4].appendChild(elemento);
    	}
    	else{
    		var text=document.createTextNode("Completar datos");
    		var elemento = document.getElementById("dinamico["+indice+"]");
    		y[4].removeChild(elemento);
    		
    		elemento = document.createElement("label");
    		elemento.setAttribute("id","dinamico["+indice+"]");
    		elemento.appendChild(text);
    		
    		y[4].appendChild(elemento);
    	}
    	
    }
    
    
    