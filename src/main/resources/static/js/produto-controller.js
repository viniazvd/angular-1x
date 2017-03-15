var app = angular.module('app', []);

var urlBase = "http://localhost:8080/"

app.controller('produtoController', function($scope, $http, $location) {	

	$scope.listar = function() {		
		$http.get(urlBase + "/listar").then(
			function(response){
				$scope.produtos = response.data;
			}, function(response){
				window.alert("erro listar");
			}
		);
	}
		
	$scope.listar();
	
	$scope.novo = function(){
		$scope.produto = "";
	}
	
	$scope.salvar =  function(){		
		if(!$scope.produto.id){
			$http.post(urlBase + "cadastrar", $scope.produto).then(
				function(response){
					$scope.listar();
					$scope.novo();
				}, function(response){
					window.alert("erro salvar");
				}
			);
		}else{
			$http.put(urlBase + "alterar/" + $scope.produto.id, $scope.produto).then(
				function(response){
					$scope.listar();
				}, function(response){
					window.alert("erro ao editar");
				}
			);
		}
	}
	
	$scope.alterar = function(produto) {
		$scope.produto = angular.copy(produto);
		$scope.produto.nome = $scope.produto.nome;
	}
	
	$scope.deletar = function(produto) {	
		$http.delete(urlBase + "deletar/" + produto.id).then(
			function(response){
				$scope.listar();
			}, function(response){
				window.alert("erro ao deletar");
			}
		);
	}
	
	$scope.orderByMe = function(produtoOrdenado){
		$scope.myOrderBy = produtoOrdenado;
	}
	
});
