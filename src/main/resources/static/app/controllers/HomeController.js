/**
 * Created by Silviu on 1/31/16.
 */
angular.module("ecomm-ui.controllers")
    .controller('HomeController', function ($scope, Item, $rootScope) {

        console.log('loaded home ctrl!');
        $scope.filter = {itemName: ''};

        Item.query(function (response) {
            $scope.items = response ? response : [];
            console.log('bought items', $scope.items);
        });

        $scope.addToCart = function (item) {
            item.inCart = true;
            var service = new Item(item);
            service.$update({id:item.id});
            $rootScope.crtNumberOfCartItems++;
        };

        $scope.findItems = function () {
            var postdata = {itemName: $scope.filter.itemName};
            var service = new Item(postdata);
            service.$findItem(function (serverData) {
                $scope.items = serverData.data;
            })
        };

        $scope.clearFilter = function () {
            $scope.filter.itemName = '';
            $scope.findItems();
        }

    });