var app = angular.module('vedroapp', [
    'ngRoute', 'ngProgress'
]).config(function($routeProvider){
      // works with arrive js
      $.material.init();
  });

//app.config(function ($routeProvider) {
//    $routeProvider.when('/', {
//        templateUrl: '../index.html',
//        controller: 'MainCtrl'
//    }).otherwise({
//        redirectTo: '/'
//    })
//});

app.controller('MainCtrl', function ($scope, $http, ngProgressFactory) {

    $scope.progressbar = ngProgressFactory.createInstance();
    $scope.progressbar.setColor('#F19D00');
    $scope.progressbar.setHeight('10px');
    $scope.progressbar.start();

    $http.get("/form")
    .then(function(response) {
        $scope.deviceParameters = response.data[0];
        $scope.progressbar.complete();
    }, function(response) {
        console.log()
    });

    angular.element('#timer1start, #timer1stop, #timer2start, #timer2stop').bootstrapMaterialDatePicker({
        date: false,
        format: 'HH:mm',
        lang: 'ru',
        cancelText: 'Отмена',
        nowButton: true,
        nowText: 'Сейчас',
        switchOnClick: true
    });

    $scope.submitDriveForm = function(device) {
        $scope.progressbar.start();
        $http({
          method  : 'POST',
          url     : '/form',
          data    : $scope.form,
          headers : { 'Content-Type': 'application/json; charset=UTF-8' }
         }).success(function(data) {
            console.log(data);
            $scope.progressbar.complete();
         })
          .error(function(err) {
           "ERR", console.log(err)
          });
    };
});

//app.controller('ShowCtrl', function ($scope, $http) {
//     $scope.deviceParameters = [
//        {name: 'Насколько хватит газу: ', value: 82 },
//        {name:'Газ в баллоне есть/нет: ', value: true },
//        {name:'Объём газового баллона: ', value: 28 },
//        {name:'Подсветка: ', value: false },
//        {name:'Время работы системы (uptime): ', value: 228 },
//        {name:'Версия прошивки: ', value: 2.8 },
//        {name:'Температура нагревателя: ', value: 22.8 },
//        {name:'Температура двигателя: ', value: 88.2 },
//        {name:'Температура окружающей среды: ', value: 28 }
//      ];
//});