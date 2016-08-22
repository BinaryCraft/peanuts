import { Component } from '@angular/core';
import { OnInit } from '@angular/core';

@Component({
    selector: 'app',
    template: `
  <p>Hello World</p>
  `,
})
export class AppComponent implements OnInit {
    // constructor(private plansService: PlansService) {
    //
    // }

    ngOnInit() {
        console.log("Whooop");
            // .then(plans => {
            // this.plans = plans;
            // console.log(plans);
        // });
    }
}
