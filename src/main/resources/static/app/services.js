/**
 * Created by Silviu on 1/29/16.
 */
angular.module("ecomm-ui.services")
    .factory("ItemService", function ($resource) {
        return $resource(null, {}, {
            findAll: {
                method: "POST",
                url: "/items/find-all"
            },
            update: {
                method: "POST",
                url: "/items/save"
            },
            countCartItems: {
                method: "GET",
                url: "/items/in-cart"
            }
        });
    })
    .factory("CategoryService", function($resource) {
        return $resource(null, {}, {
            findAll: {
                method: "GET",
                url: "/category/find-all"
            }
        })
    })
    .factory("OrderService", function($resource) {
        return $resource(null, {}, {
            findAll: {
                method: "GET",
                url: "/order/find-all"
            },
            save: {
                method: "POST",
                url: "/order/save/:itemId"
            }
        })
    });