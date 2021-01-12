import { Component, OnInit } from '@angular/core';
import {formatDate} from '@angular/common';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit {
  firstName: string;
  description: string;
  lastName: string;
  profession: string;
  imageName: string;
  dob: string;
  cityId: string;
  constructor(private service: HttpServicesService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('firstName', this.firstName);
    param.append('lastName', this.firstName);
    param.append('description', this.description);
    param.append('profession', this.profession);
    param.append('imageName', this.imageName);
    param.append('dob', this.dob);
    param.append('cityId', this.cityId);
    this.service.save('person', param);

  }
}
