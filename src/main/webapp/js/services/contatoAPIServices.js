angular.module("listaTelefonica").factory("contatoAPI", function($http) {
    
    var _getContatos = function () {
        return $http.get("http://localhost:8080/listaTelefonica/rest/rotacesso/user");
    };
    
    var _salvaContato = function (contato) {
        return $http.post("http://localhost:8080/listaTelefonica/rest/rotacesso/user", contato);
    };
    
    var _deleteContato = function (contato) {
        return $http.delete("http://localhost:8080/listaTelefonica/rest/rotacesso/user/" + contato.id);
    };
    
    var _getOperadora = function () {
        return $http.get("http://localhost:8080/listaTelefonica/rest/rotacesso/operadora");
    };
    
    return {
      getContato:  _getContatos,
      setContato: _salvaContato,
      delContato: _deleteContato,
      getOperadora: _getOperadora
    };
});