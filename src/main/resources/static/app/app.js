(function(angular) {
    angular.module("ecomm-ui.controllers", []);
    angular.module("ecomm-ui.services", []);
    angular.module("ecomm-ui", ["ngResource", "ecomm-ui.controllers", "ecomm-ui.services", "ui.router"]);
}(angular));