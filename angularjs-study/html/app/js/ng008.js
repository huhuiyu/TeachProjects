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

      //延时控制div消失
      $scope.showDiv = true;
      //$timeout就是js里面setTimeout，但是$timeout更改变量会体现在页面上
      //第一个参数是延时执行的function，第二个参数是延时时间
      //返回值是用于取消延时任务的timer的id
      var timer = $timeout(function() {
        $scope.showDiv = false;
      }, 5000);

      $scope.cancelHideDiv = function() {
        //通过timer的id取消延时任务,$timeout.cancel(timer的id)
        $timeout.cancel(timer);
      };

      //获取当前时间
      function getNowTime() {
        var date = new Date();
        //年份
        var year = date.getFullYear();
        //月份
        var month = date.getMonth() + 1;
        //日期
        var day = date.getDate();
        //时
        var hour = date.getHours();
        //分
        var minute = date.getMinutes();
        //秒
        var second = date.getSeconds();
        var result = year + '年' + month + '月' + day + '日 ';
        result = result + hour + ':' + minute + ':' + second;
        return result;
      }

      $scope.nowtime = getNowTime();

      
    }
  });
})();
