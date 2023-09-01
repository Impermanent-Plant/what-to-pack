import { Component } from '@angular/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatNativeDateModule} from '@angular/material/core';

@Component({
  selector: 'app-date-picker-touch-ui',
  templateUrl: './date-picker-touch-ui.component.html',
  styleUrls: ['./date-picker-touch-ui.component.sass'],
  standalone: true,
    imports: [MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule],
})
export class DatePickerTouchUIComponent {

}
