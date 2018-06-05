var app = angular.module('todoapp',['ui.router','ui.bootstrap']);

var BASEURL = 'http://localhost:8081/Todoapp';
app.constant('urls', {	
    GET_ALL: BASEURL +'/all',
    GET_BY_ID : BASEURL +'/task/',
    SAVE: BASEURL +'/save',
    UPDATE:BASEURL +'/update',
    REMOVE: BASEURL + '/remove/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'list.html',
                controller:'userCtrl',
                controllerAs:'ctrl'
            });
        $urlRouterProvider.otherwise('home');
    }]);

