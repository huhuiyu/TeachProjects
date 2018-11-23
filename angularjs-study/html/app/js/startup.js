(function() {
  //虽然可以使用jq，但是尽量不要使用，因为ng不需要依赖jq
  angular.element(document).ready(function() {
    //将myapp绑定到document，这一句等同于在body标签上面写 ng-app="myapp"
    angular.bootstrap(document, [window.myappname]);
  });
})();
