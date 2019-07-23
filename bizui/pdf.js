const puppeteer = require('puppeteer');
  
(async() => {
  const browser = await puppeteer.launch({executablePath:'/usr/bin/chromium-browser'});
  const page = await browser.newPage();
  await page.goto('https://news.163.com', {waitUntil: 'networkidle2'});
  await page.pdf({path: 'page.pdf', format: 'A4'});

  await browser.close();
})();

