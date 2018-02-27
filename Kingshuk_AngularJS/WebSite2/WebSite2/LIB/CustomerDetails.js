var Applications = angular.module('customerModule', []);
Applications.controller('customerController', function ($scope) {
$scope.customerObj = [
{ 'customerName': 'Infitech', 'custId': 1010,'custLoc': 'Bangalore', 'Payment': 5000},
{ 'customerName': 'SPI', 'custId': 1011,'custLoc': 'Mysore', 'Payment': 7000},
{ 'customerName': 'Infosis', 'custId': 1012, 'custLoc': 'kolkata', 'Payment': 8000 } 
]
}


);