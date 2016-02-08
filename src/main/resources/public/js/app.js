var app = angular.module('vedroapp', [
    'ngResource',
    'ngRoute'
]);

//app.config(function ($routeProvider) {
//    $routeProvider.when('/', {
//        templateUrl: '../index.html',
//        controller: 'MainCtrl'
//    }).otherwise({
//        redirectTo: '/'
//    })
//});

app.controller('DriveCtrl', function ($scope, $http) {

    angular.element.material.init()

    angular.element('#timer1start, #timer1stop, #timer2start, #timer2stop').bootstrapMaterialDatePicker({
        date: false,
        format: 'HH:mm',
        lang: 'ru',
        cancelText: 'Отмена',
        nowButton: true,
        nowText: 'Сейчас',
        switchOnClick: true
    });

    $scope.save = function(device) {
        $http({
          method  : 'POST',
          url     : '/',
          data    : $.param($scope.formData),  // pass in data as strings
          headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
         })
          .success(function(data) {
            console.log(data);
          });
    };

});