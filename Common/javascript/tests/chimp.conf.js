const path = require('path');
// import {isCI} from '../lib/ci';

module.exports = {
  // - - - - CHIMP - - - -
  watch: false,
  // @focus is recommended to use. @dev and @watch are deprecated.
  watchTags: '@focus,@dev,@watch',
  watchWithPolling: false,
  criticalSteps: null,
  criticalTag: '@critical',
  server: false,
  serverPort: 8060,
  serverHost: 'localhost',
  sync: true,
  offline: false,

  // - - - - CUCUMBER - - - -
  path: './tests/acceptance/features',
  format: 'pretty',
  tags: '~@ignore',
  singleSnippetPerFile: true,
  recommendedFilenameSeparator: '_',
  chai: false,
  screenshotsOnError: false,
  screenshotsPath: '.screenshots',
  captureAllStepScreenshots: false,
  saveScreenshotsToDisk: true,
  // Note: With a large viewport size and captureAllStepScreenshots enabled,
  // you may run out of memory. Use browser.setViewportSize to make the
  // viewport size smaller.
  saveScreenshotsToReport: false,
  jsonOutput: null,
  // compiler: 'js:' + path.resolve(__dirname__, '../lib/babel-register.js'),
  conditionOutput: true,

  // - - - - SELENIUM  - - - -
  browser: 'chrome',
  platform: 'ANY',
  name: '',
  user: '',
  key: '',
  port: null,
  host: null,
  // deviceName: null,

  // - - - - WEBDRIVER-IO  - - - -
  webdriverio: {
    desiredCapabilities: {},
    logLevel: 'silent',
    // logOutput: null,
    host: '127.0.0.1',
    port: 4444,
    path: '/wd/hub',
    baseUrl: null,
    coloredLogs: true,
    screenshotPath: null,
    waitforTimeout: 500,
    waitforInterval: 250,
  },

  // - - - - SELENIUM-STANDALONE
  seleniumStandaloneOptions: {
    // check for more recent versions of selenium here:
    // http://selenium-release.storage.googleapis.com/index.html
    version: '2.53.1',
    baseURL: 'https://selenium-release.storage.googleapis.com',
    drivers: {
      chrome: {
        // check for more recent versions of chrome driver here:
        // http://chromedriver.storage.googleapis.com/index.html
        version: '2.22',
        arch: process.arch,
        baseURL: 'https://chromedriver.storage.googleapis.com'
      },
      ie: {
        // check for more recent versions of internet explorer driver here:
        // http://selenium-release.storage.googleapis.com/index.html
        version: '2.50.0',
        arch: 'ia32',
        baseURL: 'https://selenium-release.storage.googleapis.com'
      }
    }
  },

  // - - - - SESSION-MANAGER  - - - -
  noSessionReuse: false,

  // - - - - PHANTOM  - - - -
  phantom_w: 1280,
  phantom_h: 1024,

  // - - - - DEBUGGING  - - - -
  log: 'info',
  debug: false,
  seleniumDebug: null,
  debugCucumber: null,
  debugBrkCucumber: null,
  debugMocha: null,
  debugBrkMocha: null,
};
