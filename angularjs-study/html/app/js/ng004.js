//业务逻辑
angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  //多个控制器
  ctrls.controller('MyCtrl', ['$scope', '$log', MyCtrl]);
  ctrls.controller('OtherCtrl', ['$scope', '$log', OtherCtrl]);

  function MyCtrl($scope, $log) {
    $log.debug('in MyCtrl init...');
    $scope.welcome = '';

    $scope.showWelcome = function() {
      alert($scope.welcome);
    };
  }

  function OtherCtrl($scope, $log) {
    $log.debug('in OtherCtrl init...');
    $scope.welcome = '';
  }
});
