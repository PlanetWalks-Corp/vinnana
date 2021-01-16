import {Component, Input, OnInit} from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.css']
})
export class NewCityComponent implements OnInit {

  // tslint:disable-next-line:no-input-rename
  @Input('update') update: boolean;
  cityName: string;
  geoLocation: string;
  history: string;
  weatherCondition: string;
  population: string;
  cityId: number;

  constructor(private service: HttpServicesService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('cityName', this.cityName);
    param.append('geoLocation', this.geoLocation);
    param.append('history', this.history);
    param.append('weatherConditions', this.weatherCondition);
    param.append('population', this.population);
    // tslint:disable-next-line:max-line-length
    if (this.cityName === '' || this.geoLocation === '' || this.history === '' || this.weatherCondition === '' || this.population === ''){
      alert('All fields are necessary');
      return;
    }
    else {
      this.service.save('cities', param);
      this.empty();
    }

  }

  // tslint:disable-next-line:typedef
  updateData() {
    const param = new FormData();
    // @ts-ignore
    param.append('cityId', this.cityId);
    param.append('cityName', this.cityName);
    param.append('geoLocation', this.geoLocation);
    param.append('history', this.history);
    param.append('weatherConditions', this.weatherCondition);
    param.append('population', this.population);

    // tslint:disable-next-line:max-line-length
    if (this.cityId === null || this.cityName === '' || this.geoLocation === '' || this.history === '' || this.weatherCondition === '' || this.population === ''){
      alert('All fields are necessary');
      return;
    }
    else {
      this.service.update('cities', param);
      this.empty();
    }
  }

  // tslint:disable-next-line:typedef
  empty(){
    this.cityId = null;
    this.cityName = '';
    this.geoLocation = '';
    this.history = '';
    this.weatherCondition = '';
    this.population = '';
  }
}
