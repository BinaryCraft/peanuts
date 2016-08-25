import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent}  from './component/app.component';
import {HttpModule}     from '@angular/http';
import {PlansService}   from './services/plans.service';

@NgModule({
    imports: [BrowserModule, HttpModule],
    declarations: [AppComponent],
    bootstrap: [AppComponent],
    providers: [
        PlansService
    ]
})

export class AppModule {
}

