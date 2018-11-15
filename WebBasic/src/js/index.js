$(function() {
  console.log('in index.js');

  $.ajax({
    url: 'http://127.0.0.1:20000/',
    dataType: 'json'
  }).done(function(data) {
    console.log(data);
  });
});
