﻿var MyApp = angular.module('MyApp', ['ngRoute']);

//configure our routes
MyApp.config(function ($routeProvider) 
{
    $routeProvider
    .when('/Home',
    {
    
        templateUrl: 'new/Home.html',
        controller: 'HomeController'

    }).when('/Employee',
   {

       templateUrl: 'new/Employee.html',
       controller: 'EmployeeController'
   })

   .when('/Customer',
   {
   
       templateUrl: 'new/Customer.html',
       controller: 'CustomerController'
   })

}
);

MyApp.controller('HomeController', function ($scope) {
    $scope.message = "Home Page details";
}
);

MyApp.controller('CustomerController', function ($scope) {
    $scope.message = "Customer Page details";
}
);

MyApp.controller('EmployeeController', function ($scope) {
    $scope.message = "Employee Page details";
}
);