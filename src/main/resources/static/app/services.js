/**
 * Created by Silviu on 1/29/16.
 */
angular.module("ecomm-ui.services")
    .factory("Item", function ($resource) {
        return $resource('/items/:id', {
            id: '@id'
        }, {
            update: {
                method: "PUT"
            },
            remove: {
                method: "DELETE"
            },
            countCartItems: {
                method: "GET",
                url: "/items/in-cart"
            },
            findItem: {
                method: "POST",
                url: "/items/find"
            }
        });
    });