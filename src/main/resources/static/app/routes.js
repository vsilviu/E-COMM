/**
 * Created by Silviu on 1/29/16.
 */
angular.module('ecomm-ui')
    .config(function ($stateProvider, $urlRouterProvider, $httpProvider) {
        // For any unmatched url, redirect to /state1
        $urlRouterProvider.otherwise("/home");
        //
        // Now set up the states
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: "app/views/login.html",
                controller: "LoginController"
            })
            .state('home', {
                url: '/home',
                templateUrl: "app/views/home.html",
                controller: "HomeController"
            })
            .state('cart', {
                url: '/cart',
                templateUrl: "app/views/cart.html",
                controller: "CartController"
            });
    });