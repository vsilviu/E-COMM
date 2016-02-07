/**
 * Created by Silviu on 1/29/16.
 */
angular.module("ecomm-ui.controllers")
    .controller("AppController", function ($scope, $rootScope, $http, $cookies, Item) {

        $rootScope.authenticate = function (credentials, callback) {

            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('login/user', {headers: headers}).success(function (data) {
                if (data.name) {
                    $rootScope.authenticated = true;
                    Item.countCartItems(function (data) {
                        console.log('bought cart number', data);
                        $rootScope.crtNumberOfCartItems = data.data;
                        console.log('crt number login', $rootScope.crtNumberOfCartItems);
                    })
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function () {
                $rootScope.authenticated = false;
                callback && callback();
            });

        };

        $rootScope.authenticate();

        console.log('loaded main controller');

        $scope.logout = function () {
            $http.post('logout', {}).success(function () {
                $rootScope.authenticated = false;
                $state.go('login');
            }).error(function (data) {
                $rootScope.authenticated = false;
            });
        };

        $rootScope.crtNumberOfCartItems = 0;

        Item.countCartItems(function (data) {
            console.log('bought cart number', data);
            $rootScope.crtNumberOfCartItems = data.data;
            console.log('crt number', $rootScope.crtNumberOfCartItems);
        })

    });