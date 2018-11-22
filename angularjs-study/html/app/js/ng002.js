(function() {
  //下面的代码等于jquery的$(function(){});
  angular.element(document).ready(function() {
    //定义控制器模块
    angular.module('controllers', []);
    var controllers = angular.module('controllers');

    //添加控制器,第一个是名称，
    //第二个是依赖列表，$scope是控制器绑定的上下文对象（核心）,$log是日志对象，
    //最后一个必须是控制器对象，对象创建参数是前面依赖列表的值
    controllers.controller('CtrlOne', [
      '$scope',
      '$log',
      '$sce',
      function($scope, $log, $sce) {
        $log.debug('in CtrlOne init...');
        //定义作用域变量
        $scope.welcome = '欢迎使用angularjs';
        //定义作用域方法
        $scope.showWelcome = function() {
          alert($scope.welcome);
        };

        $scope.info = '';

        //计算属性值
        $scope.computeInfo = function() {
          //$sce.trustAsHtml()表示将内容渲染成html，且不用安全检测;
          return $sce.trustAsHtml('计算过的info：<br>' + $scope.info);
        };

        //支持json对象作为属性
        $scope.mycompute = {
          numa: 19,
          numb: 23
        };

        //自定义方法也接受参数传递
        $scope.showMyCompute = function(info) {
          $log.debug('参数：', info);
          $log.debug('mycompute：', $scope.mycompute);
        };

        //数组数据的渲染
        $scope.list = [
          { id: 100, name: '山一重工' },
          { id: 101, name: '山二轻工' }
        ];

        $scope.addData = {};

        //添加到集合的方法
        $scope.addDataToList = function() {
          $scope.list.push($scope.addData);
          $scope.addData = {};
        };
      }
    ]);

    //创建ng-app，名称为myapp，[]里面是模块依赖,ngSanitize是官方的安全插件，
    // controllers是上面的自定义模块
    var app = angular.module('myapp', ['ngSanitize', 'controllers']);

    //配置日志是否开启debug
    app.config([
      '$logProvider',
      function($logProvider) {
        $logProvider.debugEnabled(true);
      }
    ]);

    //将myapp绑定到document，这一句等同于在body标签上面写 ng-app="myapp"
    angular.bootstrap(document, ['myapp']);
  });
})();
