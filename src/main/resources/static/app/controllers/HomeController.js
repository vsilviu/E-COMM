/**
 * Created by Silviu on 1/31/16.
 */
angular.module("ecomm-ui.controllers")
    .controller('HomeController', function($scope, Item) {

        console.log('loaded home ctrl!');

        Item.query(function (response) {
            $scope.items = response ? response : [];
            console.log('bought items',$scope.items);
        });

        //$scope.addItem = function (description) {
        //    new Item({
        //        description: description,
        //        checked: false
        //    }).$save(function (item) {
        //        $scope.items.push(item);
        //    });
        //    $scope.newItem = "";
        //};

        $scope.addToCart = function (item) {
            item.inCart = true;
            item.$update();
        };

        $scope.deleteItem = function (item) {
            item.$remove(function () {
                $scope.items.splice($scope.items.indexOf(item), 1);
            });
        };

    });