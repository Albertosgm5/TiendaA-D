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
				processData: false,
				dataType : 'Producto',
				success : function(response) {
					
						console.log(response.idProducto);
				},
 
				error : function(xhr, status, error) {
					console.log("error al recibir el producto");
				}

			});

};
