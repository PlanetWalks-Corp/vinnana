import {Component, Input, OnInit} from '@angular/core';
import {formatDate} from '@angular/common';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit {
  constructor(private service: HttpServicesService) { }
  // tslint:disable-next-line:no-input-rename
  @Input('update') update: boolean;
  firstName: string;
  description: string;
  lastName: string;
  profession: string;
  imageName: string;
  dob: string;
  cityId: string;

  // tslint:disable-next-line:typedef
  personId: number;

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('firstName', this.firstName);
    param.append('lastName', this.lastName);
    param.append('description', this.description);
    param.append('profession', this.profession);
    param.append('imageName', this.imageName);
    param.append('dob', this.dob);
    param.append('cityId', this.cityId);
    // tslint:disable-next-line:max-line-length
    if (this.firstName === null || this.lastName === null || this.description === null || this.profession === null || this.imageName === null || this.dob === null || this.cityId === null){
      alert('All fields are necessary');
      return;
    }
    else{
      this.service.save('person', param);
      this.empty();
    }

  }

  // tslint:disable-next-line:typedef
  updateData() {
    const param = new FormData();
    // @ts-ignore
    param.append('personId', this.personId);
    param.append('firstName', this.firstName);
    param.append('lastName', this.lastName);
    param.append('description', this.description);
    param.append('profession', this.profession);
    param.append('imageName', this.imageName);
    param.append('dob', this.dob);
    param.append('cityId', this.cityId);
    // tslint:disable-next-line:max-line-length
    if (this.firstName === null || this.lastName === null || this.description === null || this.profession === null || this.imageName === null || this.dob === null) {
      alert('All fields are necessary');
      return;
    }
    else {
      this.service.update('person', param);
      this.empty();
    }
  }

  // tslint:disable-next-line:typedef
  empty() {
    this.personId = null;
    this.firstName = null;
    this.lastName = null;
    this.description = null;
    this.profession = null;
    this.imageName = null;
    this.dob = null;
    this.cityId = null;
  }
}
