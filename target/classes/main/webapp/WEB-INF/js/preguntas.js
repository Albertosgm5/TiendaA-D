$(document).ready(function() {
	$("#bPreguntar").click(function() {
		agregarPregunta();
	});

});

function agregarPregunta() {
	var idProducto = document.getElementById('idProducto').value;
	
	var textoPregunta = document.getElementById('textoPregunta').value;
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var preguntaData = JSON.stringify(textoPregunta);
	
	$
			.ajax({
				url : "http://localhost:8080/A&DStore/producto/preguntar/"
						+ idProducto,
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				cache : false,
				data : preguntaData,
				success : function(response) {
							var fila = "<td>"+response+"</td>"
							console.log(response);
							$('#preguntas').append(fila);
						
					},
			

				error : function(xhr, status, error) {
					console.log("error al recibir el producto");
				}

			});

};