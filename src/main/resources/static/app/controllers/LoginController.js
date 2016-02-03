/**
 * Created by Silviu on 1/30/16.
 */
angular.module("ecomm-ui.controllers")
    .controller('LoginController', function ($scope, $rootScope, $http, $location, $state) {

        console.log('loaded login ctrl!');

        $rootScope.credentials = {};

        $scope.login = function () {
            $rootScope.authenticate($rootScope.credentials, function () {
                if ($rootScope.authenticated) {
                    $state.go('home');
                    $scope.error = false;
                } else {
                    $state.go('login');
                    $scope.error = true;
                }
            });
        };


    });