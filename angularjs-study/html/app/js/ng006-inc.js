angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('MySubCtrl', ['$scope', '$log', 'TestService', MySubCtrl]);

  function MySubCtrl($scope, $log, TestService) {
    $log.debug('in MySubCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('MySubCtrl destroy...');
    });

    TestService.echo('测试服务。。。' + TestService.myconfig);
  }
});
