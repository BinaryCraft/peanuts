import gulp from 'gulp';
import chimp from 'gulp-chimp';
import {exec} from 'child_process'
import { server as KarmaServer} from 'karma';

gulp.task('test:acceptance', function (done) {
    let child = exec(`chimp ./tests/chimp.conf.js`,
        function(err, stdout, stderr) {
            done();
        });

    child.stdout.on('data', function(data) {
        console.log(String(data));
    });
    child.stderr.on('data', function(data) {
        console.log(String(data));
    });
});

gulp.task('test:unit', function (done) {
    new KarmaServer({
        configFile: '.tests/karma.config.js',
        singleRun: false
    }, done).start();
});

gulp.task('compile:angular', function (done) {
    let child = exec(`./node_modules/.bin/ngc`,
        function(err, stdout, stderr) {
            done();
        });

    child.stdout.on('data', function(data) {
        console.log(String(data));
    });
    child.stderr.on('data', function(data) {
        console.log(String(data));
    });
});

gulp.task('build', function () {
    let child = exec(`jspm build compiled/bootstrap.ts ../../ServerPlugin/src/main/resources/js/app.js`,
        function(err, stdout, stderr) {
            done();
        });

    child.stdout.on('data', function(data) {
        console.log(String(data));
    });
    child.stderr.on('data', function(data) {
        console.log(String(data));
    });
});