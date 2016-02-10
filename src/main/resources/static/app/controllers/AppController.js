/**
 * Created by Silviu on 1/29/16.
 */
angular.module("ecomm-ui.controllers")
    .controller("AppController", function ($scope, $rootScope, $http, $state) {

        /**
         * @author Silviu
         * @param credentials
         * @param callback
         *
         * Function to get user credentials from server session
         * It is called upon refreshing the browser page
         */
        $rootScope.authenticate = function (credentials, callback) {

            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('login/user', {headers: headers}).success(function (data) {
                if (data.name) {
                    $rootScope.principal = data;
                    $rootScope.authenticated = true;
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

        /**
         * Function for logging out
         * Logout url is managed by Spring Security
         */
        $scope.logout = function () {
            $state.go('login');
            $http.post('logout', {}).success(function () {
                $rootScope.authenticated = false;
                //$state.go('login');
            }).error(function () {
                $rootScope.authenticated = false;
            });
        };

    });