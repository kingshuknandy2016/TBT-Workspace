var Applications = angular.module('DepartmentModule', []);
Applications.controller('DepartmentController', function ($scope) {
    $scope.EmployeeObj = [
{ 'Name': 'Developer', 'Tech': '.Net', 'DeptId': 'D101', 'DeptSalary': 5000 },
{ 'Name': 'HR', 'Tech': 'Requrement', 'DeptId': 'D102', 'DeptSalary': 7000 },
{ 'Name': 'Sales', 'Tech': 'Marketing', 'DeptId': 'D103', 'DeptSalary': 9000  }
]
}


);

Applications.filter('UpperCaseFilters', function () {
    return function (data) {
        return data.toUpperCase();
    }
}
);


Applications.filter('LowerCaseFilters',function()
{
return function(data)
{
return data.toLowerCase();
}
}
);