/**
 * Created by Silviu on 2/7/16.
 */
angular.module("ecomm-ui")
    .controller("CartController", function ($scope, Item, $rootScope) {

        Item.query(function (response) {
            $scope.items = response ? response : [];
            console.log('bought items', $scope.items);
            $scope.emptyCart = true;
            angular.forEach($scope.items, function (item) {
                if (item.inCart == true) {
                    $scope.emptyCart = false;
                }
            })
        });

        $scope.removeFromCart = function (item) {
            item.inCart = false;
            $rootScope.crtNumberOfCartItems--;
            if ($rootScope.crtNumberOfCartItems == 0) {
                $scope.emptyCart = true;
            }
            item.$update();
        };

        $scope.purchase = function (item) {
            if (confirm('Are you sure you want to buy this item? ' + item.name)) {
                $scope.removeFromCart(item);
            }

        }
    });
