/**
 * Created by Silviu on 1/31/16.
 */
angular.module("ecomm-ui.controllers")
    .controller('HomeController', function ($scope, ItemService, $rootScope, CategoryService, OrderService) {

        $scope.filter = {name: '', category: null};
        $scope.items = [];
        $scope.categories = [];

        CategoryService.findAll(function (serverData) {
            $scope.categories = serverData.data;
        });


        $scope.findItemsFiltered = function () {
            var service = new ItemService($scope.filter);
            service.$findAll(function (serverData) {
                console.log(serverData);
                $scope.items = serverData.data;
            })
        };

        $scope.clearFilter = function () {
            $scope.filter.name = '';
            $scope.filter.category = null;
            $scope.findItemsFiltered();
        };

        //find all items when entering home page for the first time
        $scope.findItemsFiltered();


        $scope.addToCart = function (item) {
            var service = new OrderService({});
            service.$save({itemId:item.id});
        };


    });