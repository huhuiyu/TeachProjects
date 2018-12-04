(function() {
  angular.element(document).ready(function() {
    var ctrls = angular.module('controllers');
    ctrls.controller('MyCtrl', ['$scope', '$log', '$timeout', '$interval', MyCtrl]);

    function MyCtrl($scope, $log, $timeout, $interval) {
      $log.debug('in MyCtrl init...');

      // 处理scope销毁
      $scope.$on('$destroy', function() {
        $log.debug('MyCtrl destroy...');
      });

      
    }
  });
})();
