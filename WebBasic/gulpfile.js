//gulp依赖导入
const gulp = require('gulp');
//del(文件删除)依赖导入
const del = require('del');
//gulp-concat(文件合并)依赖
const concat = require('gulp-concat');
//gulp-file-sync(文件同步)依赖
const sync = require('gulp-file-sync');
//gulp-watch(文件变化检测插件)依赖
const watch = require('gulp-watch');

//定义gulp任务，default为默认任务，gulp不带参数执行
gulp.task('default', function() {
  console.log('gulp启动...');
});

//清理dist目录,gulp clean
gulp.task('clean', function() {
  console.log('清理发布目录开始');
  //del.sync表示同步删除内容，第一个参数是要删除的文件列表数字，
  //第二个参数可选，del的配置json，force表示是否强制删除
  del.sync(['dist/**/*'], {
    force: true
  });
  console.log('清理发布目录完成');
});

//复制css第三方库，gulp css-libs
gulp.task('css-libs', function() {
  //gulp管道操作(流式api)，将src中定义的文件列表通过管道流向dest定义的位置
  var csslibs = [];
  csslibs.push('node_modules/bootstrap3/dist/css/bootstrap.min.css');
  gulp
    .src(csslibs)
    .pipe(concat('lib.min.css'))
    .pipe(gulp.dest('src/css/'));
});

//复制js第三方库，gulp js-libs
gulp.task('js-libs', function() {
  //js有依赖次序！！！且需要合并多个js文件
  var jslibs = [];
  jslibs.push('node_modules/jquery/dist/jquery.min.js');
  jslibs.push('node_modules/bootstrap3/dist/js/bootstrap.min.js');
  // 管道操作的优点，多次流式操作，不用生成中间文件
  // 将js文件通过concat合并成一个再复制到目标目录
  gulp
    .src(jslibs)
    .pipe(concat('lib.min.js'))
    .pipe(gulp.dest('src/js/'));
});

//第三方字体依赖，gulp fonts
gulp.task('fonts', function() {
  //gulp-file-sync同步，将参数一目录同步到参数二目录
  sync('node_modules/bootstrap3/dist/fonts/', 'src/fonts/');
});

//第三方依赖组合任务，gulp libs
gulp.task('libs', ['css-libs', 'js-libs', 'fonts'], function() {
  console.log('复制第三方依赖');
});

//源码发布，gulp app
gulp.task('app', function() {
  sync('src/', 'dist/');
});

//开发者模式，gulp dev
gulp.task('dev', ['build'], function() {
  //检测src目录，变化了就执行app任务
  watch(['src/**/*'], function() {
    gulp.start('app');
  });
});

//项目打包，gulp build
gulp.task('build', ['libs', 'app'], function() {
  console.log('项目构建');
});
