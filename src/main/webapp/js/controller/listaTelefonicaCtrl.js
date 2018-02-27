angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatoAPI) {
    $scope.app = "Lista Telefonica";
    $scope.nome = "";
    $scope.telefone = "";
    $scope.contatos = [];
    $scope.operadoras = [];
    var carregaOperadoras = function () {
        contatoAPI.getOperadora().then(function sucessCallback(response) {
            $scope.operadoras = response.data;
        });
    };
    var carregaContatos = function () {
        contatoAPI.getContato().then(function successCallback(response) {
            $scope.contatos = response.data;
        }, function errorCallback(response) {
            $scope.error = "Não foi possivel carregar os dados";
        });
    };
    $scope.adicionarContato = function (contato) {
        //contato.data = new Date();
        console.log(contato);
        contatoAPI.setContato(contato).then(function sucessCallback(response) {
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
            carregaContatos();
        }, function errorCallback(response) {
            $scope.error = "Não foi possivel carregar os dados";
        });
        //console.log(contato);
        //$scope.contatos.push(angular.copy(contato));
    };
    $scope.apagarContato = function (contatos) {

        contatos.filter(function (contato) {
            if (contato.selecionado) {
                contatoAPI.delContato(contato).then(function sucessCallback(response) {
                    carregaContatos();
                });
                console.log(contato);
            }
        }, function errorCallback(response) {
            $scope.error = "Não foi possivel carregar os dados";
        });
        //$scope.contatos = contatos.filter(function (contato) {
        //    if (!contato.selecionado) {
        //        return contato;
        //    }
        //});
    };
    $scope.isContatoSelecionado = function (contatos) {
        return contatos.some(function (contato) {
            return contato.selecionado;
        });
    };
    $scope.ordenaPor = function (nome) {
        $scope.ordenar = nome;
        $scope.decrescente = !$scope.decrescente;
    };
    carregaContatos();
    carregaOperadoras();
});