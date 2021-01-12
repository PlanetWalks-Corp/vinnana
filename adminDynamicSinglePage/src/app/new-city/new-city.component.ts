import { Component, OnInit } from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.css']
})
export class NewCityComponent implements OnInit {
  cityName: string;
  geoLocation: string;
  history: string;
  weatherCondition: string;
  population: string;

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
    this.service.save('cities', param);

  }
}
