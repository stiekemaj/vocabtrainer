'use strict';

var VocabTrainer = {};

var App = angular.module('VocabTrainer', ['ngRoute', 'VocabTrainer.filters', 'VocabTrainer.services', 'VocabTrainer.directives']);

// Declare app level module which depends on filters and services
App.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/subjects', {
        templateUrl: 'subjects',
        controller: SubjectsController
    });

//    $routeProvider.otherwise({redirectTo: '/subjects'});
}]);