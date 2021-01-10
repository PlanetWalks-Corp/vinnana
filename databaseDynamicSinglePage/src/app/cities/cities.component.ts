import { Component, OnInit } from '@angular/core';
import { CitiesConfig } from '../cities-config';
import {SavingDataService} from '../saving-data.service';

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesComponent implements OnInit {

  name: string;
  imageName: string;
  citiesConfig: CitiesConfig = new CitiesConfig('', '');
  url = 'http://localhost:8080/cities/save';
  constructor(private service: SavingDataService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  save(){
    const params = new FormData();
    params.append('name', this.citiesConfig.name);
    params.append('image', this.citiesConfig.image);
    this.service.save(params, this.url);
    this.citiesConfig.name = '';
    this.citiesConfig.image = '';
  }
}
