angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('MainCtrl', ['$scope', '$log', MainCtrl]);

  function MainCtrl($scope, $log) {
    $log.debug('in MainCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('MainCtrl destroy...');
    });
  }
});
