/**
 * Created by Silviu on 1/29/16.
 */
angular.module("ecomm-ui.controllers").controller("AppController", function ($scope, Item, $rootScope, $http) {

    $rootScope.authenticate = function (credentials, callback) {

        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('login/user', {headers: headers}).success(function (data) {
            if (data.name) {
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

    Item.query(function (response) {
        $scope.items = response ? response : [];
    });

    $scope.addItem = function (description) {
        new Item({
            description: description,
            checked: false
        }).$save(function (item) {
            $scope.items.push(item);
        });
        $scope.newItem = "";
    };

    $scope.updateItem = function (item) {
        item.$update();
    };

    $scope.deleteItem = function (item) {
        item.$remove(function () {
            $scope.items.splice($scope.items.indexOf(item), 1);
        });
    };

    console.log('loaded item controller');
});