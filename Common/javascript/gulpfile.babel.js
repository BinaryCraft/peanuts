import gulp from 'gulp';
import chimp from 'gulp-chimp';

gulp.task('chimp', function () {
    return chimp('./chimp.conf.js');
});