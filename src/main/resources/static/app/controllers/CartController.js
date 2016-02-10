/**
 * Created by Silviu on 2/7/16.
 */
angular.module("ecomm-ui")
    .controller("CartController", function ($scope, OrderService) {

        $scope.orders = [];

        OrderService.findAll(function(serverData) {
            console.log(serverData);
            $scope.orders = serverData.data;
        });

        $scope.deleteOrder = function (item) {
            //do delete stuff
        };

        $scope.purchase = function (item) {
            if (confirm('Are you sure you want to buy this item? ' + item.name)) {
                //do delete stuff
            }

        }
    });
