(function() {
  //业务逻辑
  angular.element(document).ready(function() {
    var ctrls = angular.module('controllers');
    ctrls.controller('MyCtrl', ['$scope', '$log', MyCtrl]);

    function MyCtrl($scope, $log) {
      $log.debug('in MyCtrl init...');

      $scope.welcome = 'ng项目初始化演示';

      //用户学历下拉选择的数据
      $scope.list = [
        { id: 10000, name: '初中' },
        { id: 10001, name: '高中' },
        { id: 10002, name: '大专' },
        { id: 10003, name: '本科' }
      ];
      //选中的学历id
      $scope.selectId = $scope.list[0].id;
    }
  });
})();
