scotchApp.controller('aboutController', function($scope,$http) {
    $scope.message = 'Cars Details From Angular Controller';
    
    var backEndUrl = "http://localhost:8081/homejs";
    $scope.data = [];
    function loadData() {
        $http.get(backEndUrl)
            .then(function (response) {
                $scope.data = response.data;
            })
            .catch(function(error) {
                $scope.error = error;
            });
    }
    loadData();
   
});