//业务逻辑
angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  //多个控制器
  ctrls.controller('MyCtrl', ['$rootScope', '$scope', '$log', MyCtrl]);

  function MyCtrl($rootScope, $scope, $log) {
    $log.debug('in MyCtrl init...');
    //$rootScope表示全局作用域，在所有的地方都可以使用，强烈不推荐使用！！！！
    $rootScope.appTitle = '我的angularjs学习';
    $scope.appTitle = '控制器里面定义的title';

    //checkbox的数据
    $scope.mycheck = true;
    $scope.cvalue = 'cv';
    // 页面映射
    var includes = {
      inc01: 'ng005-01.html',
      inc02: 'ng005-02.html'
    };
    $scope.inc = '';
    // 切换包含页面
    $scope.changePage = function(page) {
      $scope.inc = includes[page];
    };
  }
});
