/* 
    Скрипт, управляющий зависимостями фронтенда, полный запуск командой gulp в консоли
    Доступные таски:
    bower: запускает bower install, который выкачивает зависимости, 
           указанные в bower.json в каталог bower_components
    js: фильтрует js скрипты и помещает в webroot/js
    css: фильтрует css стили и помещает в webroot/css
    fonts: фильтрует фасеты шрифтов и помещает в webroot/fonts
    default task: запускает все таски вместе
*/
var gulp = require('gulp');
var gulpFilter = require('gulp-filter');
var mainBowerFiles = require('main-bower-files');
var bower = require('gulp-bower');

var publicdir = 'webroot';
var bowerDir = './bower_components';

var dest = {
  css: publicdir + '/css/',
  js: publicdir + '/js/',
  fonts: publicdir + '/fonts/'
}

gulp.task('css', function () {
	return gulp.src(mainBowerFiles({
            overrides: {
                "bootstrap": {
                    main: [
                        './dist/css/bootstrap.css'
                    ]
                },
                "font-awesome": { 
                    main: [
                        './css/font-awesome.css'
                    ]
                }
            }
        }))
        .pipe(gulpFilter('**/*.css'))
		.pipe(gulp.dest(dest.css));
});

gulp.task('js', function () {
	return gulp.src(mainBowerFiles({
            overrides: {
                moment: {
                    main: [
                        './min/moment-with-locales.js ',
                    ]
                }
            }
        }))
		.pipe(gulpFilter('*.js'))
		.pipe(gulp.dest(dest.js));
});

gulp.task('bower', function () {
    return bower()
        .pipe(gulp.dest(bowerDir))
});

gulp.task('fonts', function () {
    return gulp.src(mainBowerFiles({
            overrides: {
                "bootstrap": { main: [ './dist/fonts/*.*'] },
                "bootstrap-material-datetimepicker": { main: [ './font/*.*'] }
            }
        }))
        .pipe(gulpFilter(['**/*.eot', '**/*.svg', '**/*.woff', '**/*.woff2', '**/*.ttf']))
        .pipe(gulp.dest(dest.fonts));
});

gulp.task('default', ['bower', 'js', 'css', 'fonts']);