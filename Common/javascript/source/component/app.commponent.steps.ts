import {AppComponent}  from './app.component';

__adapter__.addStepDefinitions(function (scenario) {

    scenario.Given(`stuff happens`, function () {
        let component = new AppComponent();
        console.log(component);
        // Express the regexp above with the code you wish you had.
        // `this` is set to a World instance.
        // i.e. you may use this.browser to execute the step:

        // ;

        // The callback is passed to visit() so that when the job's finished, the next step can
        // be executed by Cucumber.

    });

    scenario.When(`more stuff happend`, function () {
        // Express the regexp above with the code you wish you had. Call callback() at the end
        // of the step, or callback(null, 'pending') if the step is not yet implemented:

        console.log("When more stuff happend")

    });

    scenario.Then(`it should do something of value`, function () {
        return expect(1).to.equal(3);
    });
});