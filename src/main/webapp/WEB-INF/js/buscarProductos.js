$(document).ready(function() {
	$("#bProducto").click(function() {
		buscarProducto();
	});

});

function buscarProducto() {
	var textoProducto = document.getElementById('nproducto').value;


	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	$
			.ajax({
				url : "http://localhost:8080/A&DStore/producto/lista/" + textoProducto,
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				cache : false,

				success : function(response) {
					var lista = []
					lista = response;
			        for (var i = 0; i < lista.length; i++) {           
			            	console.log(lista[i].idProducto + "-" + lista[i].nombreProducto);
			            	document.getElementsByName("prueba").value = lista[i].nombreProducto;
			            	document.getElementsByName("prueba2").value = lista[i].nombreProducto;
			            	$('#prueba').html(lista[i].idProducto + "-" + lista[i].nombreProducto);
			        }
				},
 
				error : function(xhr, status, error) {
					console.log("error al recibir el producto");
				}

			});

};
