var app = angular.module("employeeApp", []); 
app.controller("employeeController", function($scope, $http) {

    var employeeRoute = "http://localhost:8080/api/employee/";

    $scope.showInfo = false;
    $scope.showDanger = false;

    $scope.init = init;

    function init(){
        getAllEmployees();
    }

    function getAllEmployees(){
        allEmployees().then(function(data){
            $scope.employees = data;
            $scope.showInfo = true;
            $scope.showDanger = false;
        });
    }

    function getEmployeeById(){
        employeeByID($scope.idEmployee)
        .then(function(response){
            $scope.employees = response.data;
            $scope.showInfo = true;
            $scope.showDanger = false;
        },function(response) {
            $scope.employees = response.data;
            $scope.showDanger = true;
            $scope.showInfo = false;
        });
    }


    function allEmployees() {
        return $http.get(employeeRoute)
            .then(function (response) { return response.data; });
    }

    function employeeByID(param) {
        return $http.get(employeeRoute + param);
    }


    $scope.getEmployee = function () {
        if ($scope.idEmployee == "" || $scope.idEmployee == null) {
            getAllEmployees();
        } else {
            getEmployeeById();
        }
    }
});