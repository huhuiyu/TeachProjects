angular.element(document).ready(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('MyCtrl', ['$scope', '$log', 'TestService', 'DataService', MyCtrl]);

  function MyCtrl($scope, $log, TestService, DataService) {
    $log.debug('in MyCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('MyCtrl destroy...');
    });

    TestService.echo('测试服务。。。');
    $log.debug(TestService.myconfig);

    //业务逻辑
    $scope.showsub = false;

    //数据处理
    $scope.sendOne = function() {
      DataService.send('/', { echo: new Date().getTime() }, function(data) {
        $scope.result = data;
      });
    };

    //请求结果
    $scope.result = '';

    //登录
    $scope.formdata = {};

    $scope.login = function() {
      DataService.send('/user/login', { user: $scope.formdata }, function(data) {
        $scope.result = data;
      });
    };

    $scope.getUserInfo = function() {
      DataService.send('/user/getUserInfo', {}, function(data) {
        $scope.result = data;
      });
    };

    $scope.logout = function() {
      DataService.send('/user/logout', {}, function(data) {
        $scope.result = data;
      });
    };

    //图片校验码
    $scope.changeImage = function() {
      var token = DataService.getToken();
      //token不存在就发起请求获取
      if (!token) {
        DataService.send('/', {}, function(data) {
          $scope.imgcode = DataService.getValidateImage();
        });
        return;
      }
      $scope.imgcode = DataService.getValidateImage();
    };

    $scope.changeImage();

    $scope.doImgCheck = function() {
      DataService.send('/test/imageCode', { imageCode: $scope.checkimgcode }, function(data) {
        $scope.result = data;
      });
    };
  }
});
