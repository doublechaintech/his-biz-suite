const puppeteer = require('puppeteer');
const browserFetcher = puppeteer.createBrowserFetcher({ platform: 'linux' });
const revision = require('puppeteer/package').puppeteer.chromium_revision;

browserFetcher.download(revision)
    .then(() => console.log('Done, with revision number: ', revision))
    .catch(error => console.log('Error', error));

