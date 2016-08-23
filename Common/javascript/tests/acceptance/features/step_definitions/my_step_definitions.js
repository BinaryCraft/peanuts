module.exports = function () {
    const adminSelector = `img[alt="Admin"]`;

    async function login() {
        await browser.setValue("#loginForm_os_username", "admin");
        await browser.setValue("#loginForm_os_password", "admin");
        await browser.submitForm("#loginForm");
    }

    async function logOut() {
        await browser.click(adminSelector);
        await browser.click(`#log-out`);
    }

    async function isPipelinesLinkVisible() {
        return await client.isVisible('#project-pipelines-by-peanuts-link');
    }

    this.Given(`I'm on the home page`, function () {
        return browser.url('http://marthinuss-macbook-pro.local:6990/bamboo/');
    });

    this.Given(`I'm NOT logged in`, async function () {
        const loggedIn = await client.isExisting(adminSelector);

        if(loggedIn) {
            await logOut();
        }
    });

    this.Given(`I'm logged in`, async function () {
        await browser.click("#login");
        await login();
    });

    this.Given(`I was redirected to login`, function () {

    });

    this.When(`I log in`, async function () {
        await login()
    });

    this.When(`I navigate to the plugin`, async function () {
        await browser.url('http://marthinuss-macbook-pro.local:6990/bamboo/plugins/servlet/project-pipelines-by-peanuts');
    });

    this.When(`I click on the Pipelines tab`, async function () {
        await browser.click("#project-pipelines-by-peanuts-link");
    });

    this.Then(`I should be redirected to login`, async function () {
        const currentUrl = await browser.getUrl();
        expect(currentUrl).toContain("bamboo/userlogin");
    });

    this.Then(`I should be navigated to the Pipelines plugin page`, async function () {
        const currentUrl = await browser.getUrl();
        expect(currentUrl).toContain('/bamboo/plugins/servlet/project-pipelines-by-peanuts');
    });

    this.Then(`I should NOT see the Pipelines tab`, async function () {
        expect(await isPipelinesLinkVisible()).toEqual(false);
    });

    this.Then(`I should see the Pipelines tab`, async function () {
        expect(await isPipelinesLinkVisible()).toEqual(true);
    })
};