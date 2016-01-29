/**
 * Created by Silviu on 1/29/16.
 */
angular.module('ecomm-ui')
    .config(function($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/items");
    //
    // Now set up the states
    $stateProvider
        .state('state1', {
            url: "/state1",
            templateUrl: "app/views/state1.html"
        })
        //.state('state1.list', {
        //    url: "/list",
        //    templateUrl: "partials/state1.list.html",
        //    controller: function($scope) {
        //        $scope.items = ["A", "List", "Of", "Items"];
        //    }
        //})
        .state('state2', {
            url: "/state2",
            templateUrl: "app/views/state2.html"
        });
        //.state('state2.list', {
        //    url: "/list",
        //    templateUrl: "partials/state2.list.html",
        //    controller: function($scope) {
        //        $scope.things = ["A", "Set", "Of", "Things"];
        //    }
        //});
});