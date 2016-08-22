module.exports = function () {
    this.Given(`I'm on the home page`, function () {
        return browser.url('http://marthinuss-macbook-pro.local:6990/bamboo/');
    });

    this.When(`I navigate to the plugin`, function () {
        // Write code here that turns the phrase above into concrete actions
        return browser.url('http://marthinuss-macbook-pro.local:6990/bamboo/plugins/servlet/project-pipelines-by-peanuts');
    });


    this.Then(`I should be redirected to login`, async function () {
        const url = await browser.getUrl();
        expect(url).toContain("bamboo/userlogin");
    });
};

