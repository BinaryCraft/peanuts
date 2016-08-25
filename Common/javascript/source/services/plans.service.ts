import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class PlansService {
    private plansUri = "/bamboo/rest/api/latest/plan.json";

    constructor(private http: Http) { }

    getPlans() {
        return this.http.get(this.plansUri)
            .toPromise()
            .then(response => console.log(response.json()))
            .catch(this.handleError)
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}
