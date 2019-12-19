 	function agregarFila(tablaID) {

        var tabla = document.getElementById(tablaID);

        var cant = tabla.rows.length;
        
        if(cant <= 4){
        	
	        var fila = tabla.insertRow(cant);
	        
	        if(tablaID=="tbFiltroUser"){
		        ///CELDA 1
	
		        var celda1 = fila.insertCell(0);
		        celda1.setAttribute("style","border:none");
	
		        var elemento1 = document.createElement("input");
		        elemento1.type = "button";
		        elemento1.value="-"
		        elemento1.setAttribute("id","btn["+cant+"]");
		        elemento1.setAttribute("onclick","quitarFila('tbFiltroUser',this)");
		        
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
		   		
				opcion1.setAttribute("selected","selected");
			
		   		elemento2.add(opcion1);
		   		elemento2.add(opcion2);
		   		elemento2.add(opcion3);
		   		elemento2.add(opcion4);
		
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
		   		var opcion8=document.createElement("option");
		        
		        opcion3.text="-";
		   		opcion4.text="Nombre de Usuario";
		   		opcion5.text="Email";
		   		opcion6.text="DNI";
		   		opcion7.text="Tipo de Usuario";
		   		opcion8.text="Estado";
		   		opcion3.value="-";
		   		opcion4.value="1";
		   		opcion5.value="2";
		   		opcion6.value="3";
		   		opcion7.value="4";
		   		opcion8.value="5";
		   		
				opcion3.setAttribute("selected","selected");
				
		   		elemento3.add(opcion3);
		   		elemento3.add(opcion4);
		   		elemento3.add(opcion5);
		   		elemento3.add(opcion6);
		   		elemento3.add(opcion7);
		   		elemento3.add(opcion8);
		   		
		        celda3.appendChild(elemento3);
		
		        ///CELDA 4
	
		        var celda4 = fila.insertCell(3);
		        celda4.setAttribute("style","border:none");
	
		        var elemento4 = document.createElement("SELECT");
		        
		        elemento4.setAttribute("id","ddlFiltro2["+cant+"]");
		        elemento4.setAttribute("onchange","columna(this)");
		        
		        
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
	        else if(tablaID=="tbFiltroTurnosUser"){
			        ///CELDA 1
		
			        var celda1 = fila.insertCell(0);
			        celda1.setAttribute("style","border:none");
		
			        var elemento1 = document.createElement("input");
			        elemento1.type = "button";
			        elemento1.value="-"
			        elemento1.setAttribute("id","btn["+cant+"]");
			        elemento1.setAttribute("onclick","quitarFila('tbFiltroTurnosUser',this)");
			        
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
			   		
					opcion1.setAttribute("selected","selected");
				
			   		elemento2.add(opcion1);
			   		elemento2.add(opcion2);
			   		elemento2.add(opcion3);
			   		elemento2.add(opcion4);
			
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
			   		opcion4.text="Nombre";
			   		opcion5.text="Especialidad";
			   		opcion6.text="Sede";
			   		opcion7.text="Apellido"
			   		opcion3.value="-";
			   		opcion4.value="1";
			   		opcion5.value="3";
			   		opcion6.value="4";
			   		opcion7.value="2";
			   		
					opcion3.setAttribute("selected","selected");
					
			   		elemento3.add(opcion3);
			   		elemento3.add(opcion4);
			   		elemento3.add(opcion7);
			   		elemento3.add(opcion5);
			   		elemento3.add(opcion6);
			   		
			   		
			        celda3.appendChild(elemento3);
			
			        ///CELDA 4
		
			        var celda4 = fila.insertCell(3);
			        celda4.setAttribute("style","border:none");
		
			        var elemento4 = document.createElement("SELECT");
			        
			        elemento4.setAttribute("id","ddlFiltro2["+cant+"]");

			        var opcion10=document.createElement("option");
			   		var opcion8=document.createElement("option");
			        var opcion9=document.createElement("option");
			        
			        opcion10.value="1";
	    			 opcion10.text="Contiene";
	    			 opcion8.value="2";
	    			 opcion8.text="No contiene";
	    			 opcion9.value="-";
	    			 opcion9.text="-";
	    			 
	    			 opcion9.setAttribute("selected","selected");
	    			 elemento4.add(opcion9);
	    			 elemento4.add(opcion10);
	    			 elemento4.add(opcion8);
	    			 
			        celda4.appendChild(elemento4);
			        
			        ///CELDA 5
		
			        var celda5 = fila.insertCell(4);
			        celda5.setAttribute("style","text-align:center;border:none");
			        
			        var elemento5 = document.createElement("input");
			        elemento5.setAttribute("type","text");
			        elemento5.setAttribute("id","dinamico["+cant+"]");
					
					celda5.appendChild(elemento5);
		        
	        }
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
    		 case "5":
    			 opcion1.value="1";
    			 opcion1.text="Es";
    			 opcion2.value="2";
    			 opcion2.text="No es";
    			 break;
    		 } 
	    	 opcion3.value="-";
			 opcion3.text="-";
			 
		 opcion3.setAttribute("selected","selected");
			 filtro2.add(opcion3);
    		 filtro2.add(opcion1);
    		 filtro2.add(opcion2);
    	 }
    	 

    	 //Reinicio ultimo ddl
    	 
    	 var x=document.getElementById('tbFiltroUser').rows
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
    	var tipo= document.getElementById("ddlTipo["+indice+"]");
    	var filtro2= document.getElementById("ddlFiltro2["+indice+"]");
    	var x=document.getElementById('tbFiltroUser').rows
        var y=x[indice].cells
        
        if(tipo.value!="-"&&filtro2.value!="-"){
	        if(tipo.value=="1"||tipo.value=="2"||tipo.value=="3")
	    	{
	
	    		var elemento = document.getElementById("dinamico["+indice+"]");
	    		y[4].removeChild(elemento);
	    		
	    		elemento = document.createElement("input");
	            elemento.type = "text";
	            elemento.setAttribute("id","dinamico["+indice+"]");
	            elemento.classList.add("bonito");
	            y[4].appendChild(elemento);
	    	}
	    	else if(tipo.value=="4"||tipo.value=="5"){
	    		var elemento = document.getElementById("dinamico["+indice+"]");
	    		y[4].removeChild(elemento);
	    		
	    		elemento = document.createElement("SELECT");
	    		elemento.setAttribute("id","dinamico["+indice+"]");
	    		
	    		var opcion1=document.createElement("option");
	       		var opcion2=document.createElement("option");
	       		
	       		if(tipo.value=="4"){
	       		
	       		var opcion3=document.createElement("option");
	       		opcion1.text="Medico";
	       		opcion2.text="Paciente";
	       		opcion3.text="Administrador";
	       		opcion1.value="Medico";
	       		opcion2.value="Paciente";
	       		opcion3.value="Administrador";
	       		
	       		}
	       		else{
	       			opcion1.text="Habilitado";
		       		opcion2.text="Inhabilitado";
		       		opcion1.value="true";
		       		opcion2.value="false";
	       		}
			
			opcion1.setAttribute("selected","selected");
			
	       		elemento.add(opcion1);
	       		elemento.add(opcion2);
	       		
	       		if(tipo.value=="4") elemento.add(opcion3);
	            elemento.classList.add("bonito");
	            y[4].appendChild(elemento);
	    	}
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
    
    
    
