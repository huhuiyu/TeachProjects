$(function() {
  console.log('in login.js...');

  resetForm();

  $('#btnCancel').click(function() {
    resetForm();
  });

  /**
   * 重置表单
   */
  function resetForm() {
    $('#txtUsername').val('');
    $('#txtPassword').val('');
    $('#divError').html('');
    $('#txtUsername').focus();
  }

  /**
   * 登录
   */
  $('#btnLogin').click(function() {
    dataService.send(
      '/user/login',
      {
        'user.username': $('#txtUsername').val(),
        'user.password': $('#txtPassword').val()
      },
      function(data) {
        $('#divError').html('');
        //服务器应答错误
        if (data.code == 500) {
          $('#divError').html(data.message);
        }
        //用户名错误的情况
        if (
          data.message == '用户名必须填写' ||
          data.message == '用户名不存在'
        ) {
          $('#txtUsername').focus();
          return;
        }
        if (data.message == '密码必须填写' || data.message == '密码错误') {
          $('#txtPassword').focus();
          return;
        }
        //alert(data.message);
        location.href = '/';
      }
    );
  });
});
