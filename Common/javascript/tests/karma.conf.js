module.exports = function(config) {
    config.set({

        basePath: '../',

        files: [ ],

        frameworks: [ 'jspm', 'cucumber-js', 'chai-sinon'],

        jspm: {
            cachePackages: true,
            stripExtension: false,
            config: 'jspm.config.js',
            loadFiles: [ 'source/**/*.steps.ts' ],
            serveFiles: [
                'source/**/*!(*.steps)',
                'source/**/*feature',
                'tsconfig.json'
            ]
        },

        proxies: {
            '/jspm_packages': '/base/jspm_packages',
            '/source/' : '/base/source',
            '/' : '/base'
        },

        reporters: ['spec', 'bdd-json'],

        specReporter: {
            suppressPassed: true,
            suppressSkipped: true
        },

        bddJSONReporter: {
            outputFile: '.tests/acceptance/bddJsonReport.json'
        },

        client: {
            chai: {
                includeStack: true
            }
        },

        port: 9876,

        colors: true,

        logLevel: config.LOG_INFO,

        autoWatch: true,

        browsers: [ 'Chrome' ],

        captureTimeout: 30000,

        browserNoActivityTimeout: 60000,

        singleRun: true
    });
};
