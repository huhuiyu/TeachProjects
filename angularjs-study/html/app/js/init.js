(function() {
  //window是全局对象
  window.myappname = 'myapp';
  //ng和jq不冲突，可以使用jq检测文档加载
  $(function() {
    //ng初始化控制器模块
    angular.module('controllers', []);

    //初始化app
    var app = angular.module(window.myappname, ['ngSanitize', 'controllers']);

    //配置日志是否开启debug================================================================
    app.config([
      '$logProvider',
      function($logProvider) {
        $logProvider.debugEnabled(true);
      }
    ]);

    //这个配置可以将任何json格式的数据转换成post提交格式发送到服务器，jq和ng的ajax请求都没处理
    //所以需要自己编写，目的是：{user:{name:'abc',password:'123'}}
    //转换成post格式的user.name=abc&user.password=123
    //jq虽然提供了转换，但是格式必须是{'user.name':'abc','user.password':'123'}
    //这就是为什么以前提交数据必须是这个格式
    //而现在ng可以使用{user:{name:'abc',password:'123'}}和{'user.name':'abc','user.password':'123'}
    //第一种格式可以完美的和ng-model数据适配
    //下面的格式转换使用了递归算法，请自己研究
    // 处理ajax请求========================================================================
    app.config([
      '$httpProvider',
      function($httpProvider) {
        /* post提交可以使用json数据 */
        $httpProvider.defaults.headers.post['Content-Type'] =
          'application/x-www-form-urlencoded;charset=utf-8';
        var parseParams = function(params) {
          // 参数处理
          var query = '',
            name,
            value,
            fullSubName,
            subName,
            subValue,
            innerObj,
            i;
          for (name in params) {
            value = params[name];
            if (value instanceof Array) {
              for (i = 0; i < value.length; i++) {
                subValue = value[i];
                fullSubName = name + '[' + i + ']';
                innerObj = {};
                innerObj[fullSubName] = subValue;
                query += parseParams(innerObj) + '&';
              }
            } else if (value instanceof Object) {
              for (subName in value) {
                subValue = value[subName];
                fullSubName = name + '.' + subName;
                innerObj = {};
                innerObj[fullSubName] = subValue;
                query += parseParams(innerObj) + '&';
              }
            } else if (value !== undefined && value !== null) {
              query +=
                encodeURIComponent(name) +
                '=' +
                encodeURIComponent(value) +
                '&';
            }
          }
          var querydata = query;
          if (query.length) {
            querydata = query.substr(0, query.length - 1);
          }
          return querydata;
        };

        $httpProvider.defaults.transformRequest = [
          function(data) {
            var formdata = data;
            if (angular.isObject(data) && String(data) !== '[object File]') {
              formdata = parseParams(data);
            }
            return formdata;
          }
        ];

        /* 请求错误统一跳转到错误页面 */
        $httpProvider.interceptors.push([
          '$q',
          '$log',
          '$location',
          function($q, $log, $location) {
            return {
              responseError: function(rejection) {
                $log.debug('应答发生错误：', rejection);
                if (rejection.config.url.substr(0, 9) == 'templates') {
                  $log.debug('模板页不存在==>', rejection.config.url);
                  $location.path('/'); // 找不到模板转到首页，也可以跳转到统一的404错误页
                }
                return $q.reject(rejection);
              }
            };
          }
        ]);
      }
    ]);
  });
})();
