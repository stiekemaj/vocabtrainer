'use strict';

/* Filters */

var AppFilters = angular.module('VocabTrainer.filters', []);

AppFilters.filter('interpolate', ['version', function (version) {
    return function (text) {
        return String(text).replace(/\%VERSION\%/mg, version);
    }
}]);