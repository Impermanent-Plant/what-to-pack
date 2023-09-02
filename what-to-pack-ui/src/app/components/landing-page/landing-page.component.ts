import {Component, OnInit, NgZone} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.sass']
})
export class LandingPageComponent implements OnInit {
  myControl = new FormControl('');
  options: string[] = [];
  filteredOptions: Observable<string[]> | undefined;

  constructor(private http: HttpClient, private zone: NgZone){}
  ngOnInit() {
    this.http.get('../../../assets/data.json').subscribe((data: any) => {
      this.zone.run(() => {
        for(let i = 0; i < data.locationList.length; i++) {
          let element = data.locationList[i];
          let string = element.city + ", " + element.state + ", " + element.country;
          
          this.options.push(string)
        };
      })
    });

    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }
  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
  
    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }
}