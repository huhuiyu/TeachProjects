$(function() {
  //后台数据访问服务 dataservice.js
  var service = {};
  //服务器基础url
  var serverBaseUrl = '';

  //设置服务器基础url
  service.setBaseUrl = function(baseurl) {
    serverBaseUrl = baseurl;
  };

  //处理token信息
  var tokenSaveKey = 'server-token-info';

  //保存token信息
  service.saveToken = function(token) {
    localStorage.setItem(tokenSaveKey, token);
  };

  //获取token信息
  service.loadToken = function() {
    return localStorage.getItem(tokenSaveKey);
  };

  //保存服务器发送的token信息
  service.saveServerToken = function(data) {
    //如果data中包含token信息就保存
    if (data.token) {
      service.saveToken(data.token);
    }
  };

  //给发送请求的数据附加token信息
  service.addTokenInfo = function(param) {
    param.token = service.loadToken();
  };

  //发送数据到服务器，url是服务器地址，senddata为传递给服务器的数据，cb为回调函数
  service.send = function(url, senddata, cb) {
    //将传入的url和基础url链接为完整url
    var sendurl = serverBaseUrl + url;
    // 发送给服务器的数据要补充时间戳和token信息
    senddata.sendtimestamp = new Date().getTime();
    service.addTokenInfo(senddata);
    //发起ajax请求，url是服务器地址，type是请求类型，dataType是服务器应答的数据类型
    //data是发送给服务器的数据(json)，success是成功应答的回调函数，参数是应答结果
    //error是应答发生错误的回调函数，参数是，原始ajax请求对象，状态码，错误信息
    $.ajax({
      url: sendurl,
      type: 'POST',
      dataType: 'json',
      data: senddata,
      success: function(data) {
        console.log(data);
        service.saveServerToken(data);
        if (cb) {
          //回调处理
          cb(data);
        }
      },
      error: function(xhr, status, errorThrown) {
        console.log(xhr, status, errorThrown);
        if (cb) {
          //不显示原始错误，直接回调错误信息
          cb({ code: 500, message: '请检查服务器是否正常', success: false });
        }
      }
    });
  };

  //绑定为全局对象
  window.dataService = service;
});
