import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatePickerTouchUIComponent } from './date-picker-touch-ui.component';

describe('DatePickerTouchUIComponent', () => {
  let component: DatePickerTouchUIComponent;
  let fixture: ComponentFixture<DatePickerTouchUIComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DatePickerTouchUIComponent]
    });
    fixture = TestBed.createComponent(DatePickerTouchUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
