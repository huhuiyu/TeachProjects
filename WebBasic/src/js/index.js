$(function() {
  console.log('in index.js');

  //用户信息面板=================================

  /**
   * 获取用户信息
   */
  function getUserInfo() {
    dataService.send('/user/getUserInfo', {}, function(data) {
      if (data.datas && data.datas.user) {
        //用户已经登录的情况
        var user = data.datas.user;
        $('#spUserinfo').html('欢迎：' + user.nickname + '-' + user.username);
        $('#spUserinfo').show();
        $('#btnLogout').show();
      } else {
        $('#toLogin').show();
      }
    });
  }
  /**
   * 重置用户信息面板
   */
  function resetUserInfo() {
    $('#spUserinfo').hide();
    $('#btnLogout').hide();
    $('#toLogin').hide();
    getUserInfo();
  }
  resetUserInfo();

  $('#toLogin').click(function() {
    location.href = 'login.html';
  });

  $('#btnLogout').click(function() {
    dataService.send('/user/logout', {}, function(data) {
      resetUserInfo();
    });
  });

  $('#btnAjax').click(function() {
    //加载本地存储中的serverToken
    var serverToken = localStorage.getItem('serverToken');

    //nginx反向代理http://127.0.0.1:20000/为/dataService/
    //所以这两个请求完全等效，但是/dataService/没有跨域，可以避免跨域攻击
    $.ajax({
      url: '/dataService/',
      //将本地存储的token回发到服务器
      data: { echo: $('#txtEcho').val(), token: serverToken },
      dataType: 'json'
    }).done(function(data) {
      console.log(data);
      //把服务器的token保存到本地存储
      localStorage.setItem('serverToken', data.token);
      $('#divInfo').html(JSON.stringify(data));
    });
  });

  //使用dataService发起ajax
  //设置基础路径
  dataService.setBaseUrl('http://127.0.0.1:20000');
  dataService.setBaseUrl('/dataService');

  $('#btnSAjax').click(function() {
    //不再需要处理token，不用每次都指定api服务器基本地址
    dataService.send('/', { echo: $('#txtSEcho').val() }, function(data) {
      $('#divInfo').html(JSON.stringify(data));
    });
  });

  //跳转网站功能==============================================
  $('#btnGo').click(function() {
    var url = $('#txtUrl').val();
    //不带.就启动百度搜索
    if (url.indexOf('.') == -1) {
      $('#txtWord').val(url);
      $('#formBaidu').submit();
      return;
    }
    //不带http://就自动加上
    if (url.indexOf('http://') != 0) {
      url = 'http://' + url;
    }
    console.log(url);

    window.open(url);
  });
});
