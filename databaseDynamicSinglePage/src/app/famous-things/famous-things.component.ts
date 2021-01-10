import { Component, OnInit } from '@angular/core';
import { FamousThingsConfig } from '../famous-things-config';
import {SavingDataService} from '../saving-data.service';

@Component({
  selector: 'app-famous-things',
  templateUrl: './famous-things.component.html',
  styleUrls: ['./famous-things.component.css']
})
export class FamousThingsComponent implements OnInit {

  famousThings: FamousThingsConfig = new FamousThingsConfig( '', '', null, null, '', '');
  url = 'http://localhost:8080/famous/things/save';
  constructor(private service: SavingDataService ) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  save(){
    const params = new FormData();
    params.append('name', this.famousThings.name);
    params.append('address', this.famousThings.address);
    // @ts-ignore
    params.append('type', this.famousThings.type);
    // @ts-ignore
    params.append('cityId', this.famousThings.cityId);
    params.append('description', this.famousThings.description);
    params.append('image', this.famousThings.image);
    this.service.save(params, this.url);
    this.famousThings.name = '';
    this.famousThings.address = '';
    this.famousThings.type = null;
    this.famousThings.cityId = null;
    this.famousThings.description = '';
    this.famousThings.image = '';
  }

}
