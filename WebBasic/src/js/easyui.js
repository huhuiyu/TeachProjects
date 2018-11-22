$(function() {
  console.log('in easyui.js===>');

  $('#cc').combo({
    required: true,
    editable: false,
    label: 'Language:',
    labelPosition: 'top'
  });

  $('#sp').appendTo($('#cc').combo('panel'));
  $('#sp input').click(function() {
    var v = $(this).val();
    var s = $(this)
      .next('span')
      .text();
    $('#cc')
      .combo('setValue', v)
      .combo('setText', s)
      .combo('hidePanel');
  });
});
