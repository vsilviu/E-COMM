/**
 * Created by Silviu on 2/7/16.
 */
angular.module("ecomm-ui")
    .controller("CartController", function ($scope, OrderService) {

        $scope.orders = [];

        $scope.loadOrders = function() {
            $scope.orders = [];
            OrderService.findAll(function (serverData) {
                console.log(serverData);
                $scope.orders = serverData.data;
            });
        };

        $scope.loadOrders();

        $scope.deleteOrder = function (order) {
            OrderService.delete({orderId: order.id}, function() {
                $scope.loadOrders();
            });

        };

        $scope.purchase = function (order) {
            if (confirm('Are you sure you want to buy these items? ' + item.name)) {
                $scope.deleteOrder(order);
            }
        }
    });
