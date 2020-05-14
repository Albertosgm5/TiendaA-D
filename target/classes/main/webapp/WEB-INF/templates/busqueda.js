var profesores = new Bloodhound({

datumTokenizer :Bloodhound.tokenizers.obj.whitespace('name'),
queryTokenizer :Bloodhound.tokenizers.whitespace,
remote : {

url : "http://localhost:8080/PruebaSpring-
AuthenticationAuthoritation/profesor/search/%QUERY",

wildcard : '%QUERY'
}

});
$('.typeahead').typeahead({
minLength : 1,
highlight : true
}, {
name : 'profesores',
display : 'username',
source : profesores
}).on("typeahead:select", function(e, profesor) {
matricularProfesor(profesor);
});