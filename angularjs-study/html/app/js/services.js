angular.element(document).ready(function() {
  var services = angular.module('services');
  //创建服务对象
  services.factory('TestService', ['$log', TestService]);

  function TestService($log) {
    $log.debug('in TestService init...');
    //其实service就是公用对象
    var service = {};

    //服务方法
    service.echo = function(info) {
      $log.debug('echo:', info);
    };

    //服务变量
    service.myconfig = { url: 'http://huhuiyu.top' };

    return service;
  }
});
