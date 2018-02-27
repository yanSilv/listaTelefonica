angular.module("listaTelefonica").directive("uiAccordions", function () {
    return {
        controller: function ($scope, $element, $attrs) {
            var accordions = [];
            this.registerAccordion = function (accordion) {
                accordions.push(accordion);
            };
            
            this.closeAll = function () {
                accordions.forEach(function (accordion) {
                   accordion.isOpened = false; 
                });
            };
        }
    };
});
angular.module("listaTelefonica").directive("uiAccordion", function () {
    return {
        templateUrl: "views/accordion.html",
        transclude: true,
        require: "^uiAccordions",
        link: function (scope, element, attrs, ctrl) {
            ctrl.registerAccordion(scope);
            scope.open = function () {
                ctrl.closeAll();
                scope.isOpened = !scope.isOpened;
            };
        },
        scope: {
            title: "@"
        }
    };
});