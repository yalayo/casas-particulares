// execute your scripts when DOM is ready. this is a good habit
function inicializar() {			
	noticiaController.obtenerNoticias(noticiasHandler);	
	noticiaController.obtenerUltimasNoticias(ultimasNoticiasHandler);
	noticiaController.obtenerAnuncio(anuncioHandler);
	elementoController.obtenerUltimosDocumentos(ultimosDocumentosHandler);
}

function inicializarOtro() {
	noticiaController.obtenerUltimasNoticias(ultimasNoticiasHandler);
	noticiaController.obtenerAnuncio(anuncioHandler);
	elementoController.obtenerUltimosDocumentos(ultimosDocumentosHandler);
}

function inicializarSoloNoticias() {
	noticiaController.obtenerNoticias(noticiasHandler);	
	noticiaController.obtenerAnuncio(anuncioHandler);
	noticiaController.obtenerUltimasNoticias(ultimasNoticiasHandler);
}

function inicializarAnuncio() {	
	noticiaController.obtenerAnuncio(anuncioHandler);
	noticiaController.obtenerUltimasNoticias(ultimasNoticiasHandler);
}

function noticiasHandler(data) {
	if(data != null) {
		var items = document.getElementById("content");
		
		
		for(var i = 0; i < data.length; i ++) {
			var noticia = data[i];
			var item = document.createElement("div");
			item.setAttribute("id", "item" + i);
			item.setAttribute("class", "post");
			
			var h2 = document.createElement("h2");
			//h2.setAttribute("class", "title");
			h2.className = "title";
			h2.innerHTML = noticia.titulo;
			item.appendChild(h2);
			
			var entry = document.createElement("div");			
			var p1 = document.createElement("p");
			p1.innerHTML = noticia.texto;
			entry.appendChild(p1);
			item.appendChild(entry);
			
			/*var p2 = document.createElement("p");
			p2.setAttribute("class", "action");

			var a1 = document.createElement("a");
			a1.setAttribute("href", "#");
			a1.innerHTML = "Read more";
			p2.appendChild(a1);
			
			//p2.innerHTML = "&nbsp";
			
			var a2 = document.createElement("a");
			a2.setAttribute("href", "#");
			a2.innerHTML = "Show in map";
			p2.appendChild(a2);
			
			item.appendChild(p2);
			
			var table = document.createElement("table");
			
			var tr1 = document.createElement("tr");
			
			var td11 = document.createElement("td");
			td11.setAttribute("class", "label");
			td11.innerHTML = "Estado";
			
			var td12 = document.createElement("td");
			td12.innerHTML = militante.estado;
			
			tr1.appendChild(td11);
			tr1.appendChild(td12);
			
			var tr2 = document.createElement("tr");
			
			var td21 = document.createElement("td");
			td21.setAttribute("class", "label");
			td21.innerHTML = "Fondo";
			
			var td22 = document.createElement("td");
			td22.innerHTML = militante.fondo;
			
			tr2.appendChild(td21);
			tr2.appendChild(td22);
			
			var tr3 = document.createElement("tr");
			
			var td31 = document.createElement("td");
			td31.setAttribute("class", "label");
			td31.innerHTML = "Cumplimiento";
			
			var td32 = document.createElement("td");
			td32.innerHTML = militante.cumplimiento;
			
			tr3.appendChild(td31);
			tr3.appendChild(td32);
			
			//var tbody = document.createElement("tr");
			
			table.appendChild(tr1);
			table.appendChild(tr2);
			table.appendChild(tr3);
			
			item.appendChild(table);
			
			
			
			data[i]*/
			
			items.appendChild(item);
		}
	}
	
	else {
		
	}
}

function ultimasNoticiasHandler(data) {
	if(data != null) {
		var items = document.getElementById("colA");
		
		var dl = document.createElement("dl");
		dl.setAttribute("class", "list1");
		
		for(var i = 0; i < data.length; i ++) {
			var noticia = data[i];
			
			var dt = document.createElement("dt");
			dt.innerHTML = noticia.fechaPublicacion;			
			dl.appendChild(dt);
			
			// Se podria poner tambien un vinculo a la noticia
			var dd = document.createElement("dd");
			//dd.innerHTML = noticia.titulo;
			
			var a2 = document.createElement("a");
			a2.setAttribute("href", "#");
			a2.innerHTML = noticia.titulo;
			dd.appendChild(a2);
			
			dl.appendChild(dd);
		}
		
		items.appendChild(dl);
	}
	
	else {
		
	}
}

function ultimosDocumentosHandler(data) {
	if(data != null) {
		var items = document.getElementById("docs");
		
		var ul = document.createElement("ul");
		
		for(var i = 0; i < data.length; i ++) {
			var documento = data[i];
						
			// Se podria poner tambien un vinculo al documento
			var li = document.createElement("li");
			
			var a2 = document.createElement("a");
			a2.setAttribute("href", "#");
			a2.innerHTML = documento.nombre;
			li.appendChild(a2);
			
			ul.appendChild(li);
		}
		
		items.appendChild(ul);
	}
	
	else {
		
	}
}

function anuncioHandler(data) {
	if(data != null) {
		var p = document.getElementById("anuncio");
		p.innerHTML = data;
		
		var p1 = document.getElementById("anuncio1");
		p1.innerHTML = data;
	}
	
	else {
		
	}
}

function makeBold(data) {
	data.addClassName("exaltar");
}

function unMakeBold(data) {
	data.removeClassName("exaltar");
}