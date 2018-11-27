//业务逻辑
angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  //多个控制器
  ctrls.controller('MyCtrl02', ['$scope', '$log', MyCtrl02]);

  function MyCtrl02($scope, $log) {
    $log.debug('in MyCtrl02 init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('MyCtrl02 destroy...');
    });

    //业务逻辑
    $scope.welcome = '单选按钮演示';
  }
});
