/**
 * Created by Silviu on 1/30/16.
 */
angular.module("ecomm-ui.controllers")
.controller('LoginController', function($scope, $rootScope, $http, $location, $state) {

    console.log('loaded login ctrl!');

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('login/user', {headers : headers}).success(function(data) {
            if (data.name) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }).error(function() {
            $rootScope.authenticated = false;
            callback && callback();
        });

    };

    //authenticate();
    $scope.credentials = {};

    $scope.login = function() {
        authenticate($scope.credentials, function() {
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