import { Component } from '@angular/core';
import { PlansService } from '../services/plans.service';
import { OnInit } from '@angular/core';

@Component({
    selector: 'app',
    template: `
  <p>Hello World</p>
  `,
    providers: [PlansService]
})
export class AppComponent implements OnInit {
    private plans;

    constructor(private plansService: PlansService) {

    }

    getPlans() {
        this.plansService.getPlans().then(plans => this.plans = plans);
    }

    ngOnInit() {
        this.getPlans();
    }
}
