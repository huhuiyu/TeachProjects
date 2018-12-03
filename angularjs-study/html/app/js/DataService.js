angular.element(document).ready(function() {
  var services = angular.module('services');
  //创建服务对象
  services.factory('DataService', ['$log', '$http', DataService]);
  //token相关==========================================================
  const LOCAL_TOKEN_KEY = 'huhuiyu.top.savetoken';

  function saveToken(serverData) {
    //如果服务器有应答token就保存到本地session存储中
    if (serverData && serverData.token) {
      sessionStorage.setItem(LOCAL_TOKEN_KEY, serverData.token);
    }
  }

  function loadToken() {
    return sessionStorage.getItem(LOCAL_TOKEN_KEY);
  }

  function removeToken() {
    sessionStorage.removeItem(LOCAL_TOKEN_KEY);
  }
  //=================================================================

  function DataService($log, $http) {
    $log.debug('in DataService init...');
    //后台服务器地址
    var serverBaseUrl = 'http://127.0.0.1:20000';
    var service = {};

    //切换后台服务器地址
    service.setBaseUrl = function(url) {
      serverBaseUrl = url;
    };

    //发送请求，url：请求地址，data：传递数据，cb：回调函数
    service.send = function(url, data, cb) {
      //处理数据，添加时间戳和token信息
      var senddata = data ? data : {};
      senddata.sendtimestamp = new Date().getTime();
      //处理token
      senddata.token = loadToken();
      //发起ajax请求，method是请求类型，url是请求地址，data是发送的数据
      //then是应答回来的处理两个函数，第一个是成功，第二个是失败。
      $http({
        method: 'POST',
        url: serverBaseUrl + url,
        data: senddata
      }).then(
        function(data, status) {
          //成功应答
          $log.debug(data, status);
          //保存服务器token信息
          saveToken(data.data);
          //如果cb存在就回调，并传递应答数据
          (cb || angular.noop)(data.data);
        },
        function(data, status) {
          //失败应答
          $log.error(data, status);
          //提示错误信息
          var error = { code: 500, message: '请检查网络连接' };
          (cb || angular.noop)(error);
        }
      );
    };

    //获取图片校验码地址
    service.getValidateImage = function() {
      //添加token
      var imaurl = serverBaseUrl + '/util/validate.jpg?token=' + loadToken();
      //添加时间戳
      imaurl = imaurl + '&ts=' + new Date().getTime();
      $log.debug(imaurl);
      return imaurl;
    };

    //获取token值
    service.getToken=function(){
      return loadToken();
    };

    return service;
  }
});
