$(document).ready(function() {
	$("#bProducto").click(function() {
		buscarProducto();
	});

});

$('#nproducto').keyup(function() {
	buscarProducto();

}).keyup();

function buscarProducto() {
	var textoProducto = document.getElementById('nproducto').value;
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	$
			.ajax({
				url : "http://localhost:8080/A&DStore/producto/lista/''"
						+ textoProducto,
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				cache : false,

				success : function(response) {
					var element = document.getElementById("listaProductos");
					while (element.firstChild) {
						element.removeChild(element.firstChild);
					}
					var lista = []
					lista = response;
					if (lista.length == -1) {
						var fila = "<center><h5>Sin Productos con esa referencia</h5></center>"
						$('#listaProductos').append(fila);
					} else {
						for (var i = 0; i < lista.length; i++) {

							var fila = "<div class='card' style='width: 12rem; display: inline-block; margin: 20px;'>"
									+ "<div><img src='/A&DStore/producto/imagen/"
									+ lista[i].idProducto
									+ "' style='WIDTH: 12rem; HEIGHT: 12rem;'>"
									+ "</div>"
									+ "<div class='card-body'>"
									+ "<h5 class='card-title'>"
									+ lista[i].nombreProducto
									+ "</h5>"
									+ "<p class='card-text'>"
									+ lista[i].descripcion
									+ "</p>"
									+ "<a class='btn btn-primary' href='/A&DStore/producto/detallesProducto/"
									+ lista[i].idProducto
									+ "'> Detalles </a>"
									+ "</div>"

							$('#listaProductos').append(fila);
						}
					}
				},

				error : function(xhr, status, error) {
					console.log("error al recibir el producto");
				}

			});

};
