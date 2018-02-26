angular.module("listaTelefonica").factory("contatoAPI", function($http, config) {
    
    var _getContatos = function () {
        return $http.get(config.baseUrl + "/rotacesso/user");
    };
    
    var _salvaContato = function (contato) {
        return $http.post(config.baseUrl + "/rotacesso/user", contato);
    };
    
    var _deleteContato = function (contato) {
        return $http.delete(config.baseUrl + "/rotacesso/user/" + contato.id);
    };
    
    var _getOperadora = function () {
        return $http.get(config.baseUrl + "/rotacesso/operadora");
    };
    
    return {
      getContato:  _getContatos,
      setContato: _salvaContato,
      delContato: _deleteContato,
      getOperadora: _getOperadora
    };
});