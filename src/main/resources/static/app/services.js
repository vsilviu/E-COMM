/**
 * Created by Silviu on 1/29/16.
 */
angular.module("myApp.services")
    .factory("Item", function($resource) {
    return $resource('/items/:id', {
        id: '@id'
    }, {
        update: {
            method: "PUT"
        },
        remove: {
            method: "DELETE"
        }
    });
});