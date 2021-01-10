import { Component, OnInit } from '@angular/core';
import {SavingDataService} from '../saving-data.service';

@Component({
  selector: 'app-things-type',
  templateUrl: './things-type.component.html',
  styleUrls: ['./things-type.component.css']
})
export class ThingsTypeComponent implements OnInit {

  name: string;
  url = 'http://localhost:8080/things/types/save';
  constructor(private service: SavingDataService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  save(){
    const params = new FormData();
    params.append('name', this.name);
    this.service.save(params, this.url);
    this.name = '';
  }

}
