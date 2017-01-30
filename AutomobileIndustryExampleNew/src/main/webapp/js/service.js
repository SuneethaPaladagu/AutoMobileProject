angular.module('myApp', ["ngRoute"]).factory('service' , ['$http','$q',function($http,$q){
	
	var backEndUrl = "/http://localhost:8081/cars";
	var factory = {
			getAll:getAll,
			addCar:addCar,
		
	}
	
	return factory;
	
	function getAll(){
		$http.get(backEndUrl).then(function(responce){
			responce.data
		})
		return data;
	}
	
	
}])