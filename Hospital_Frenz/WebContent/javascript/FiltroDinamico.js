 	function addRow(tableID) {

        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name="chkbox[]";
        cell1.appendChild(element1);

        var cell2 = row.insertCell(1);
        cell2.innerHTML = rowCount + 1;

        var cell3 = row.insertCell(2);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.name = "txtbox[]";
        cell3.appendChild(element2);


    }

    function deleteRow(tableID) {
        try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if(null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
            }


        }
        }catch(e) {
            alert(e);
        }
    }
    
    function diferenciar()
    {
    	 var filtro2= document.getElementById("ddlFiltro2");
    	 filtro2.length=0;
    	 var tipo= document.getElementById("ddlTipo");
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
    }
    
    function columna4()
    {
    	var filtro2= document.getElementById("ddlFiltro2");
    	var texto=filtro2.options[filtro2.selectedIndex].text;
    	var table = document.getElementById("tbFiltro");
    	 var rowCount = table.rows.length;
         var row = table.insertRow(rowCount);
    	var cell5 = row.insertCell(4);
    	
    	if(texto.equals("Contiene")||texto.equals("No contiene"))
    	{
    		var element2 = document.createElement("input");
            element2.type = "text";
            element2.name = "txtbox[]";
            cell5.appendChild(element2);
    	}
    	else if(texto.equals("Es")||texto.equals("No es")){
    		
    	}
    }