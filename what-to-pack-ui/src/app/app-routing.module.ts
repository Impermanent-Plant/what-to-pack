import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { HomeComponent } from './components/home/home.component';
import {DatePickerComponent} from './components/date-picker/date-picker.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'landingPage', component: LandingPageComponent},
  { path: 'datePickerPage', component: DatePickerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
