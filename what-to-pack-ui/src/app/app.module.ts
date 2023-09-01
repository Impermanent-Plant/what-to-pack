import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DatePickerComponent } from './components/date-picker/date-picker.component';
import { DatePickerTouchUIComponent } from './components/date-picker-touch-ui/date-picker-touch-ui.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LandingPageComponent,
    DatePickerComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DatePickerTouchUIComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
