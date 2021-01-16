import {Component, Input, OnInit} from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-place',
  templateUrl: './new-place.component.html',
  styleUrls: ['./new-place.component.css']
})
export class NewPlaceComponent implements OnInit {

  constructor(private service: HttpServicesService) { }
  // tslint:disable-next-line:no-input-rename
  @Input('update') update: boolean;
  placeName: string;
  address: string;
  description: string;
  imageName: string;
  cityId: string;
  placeType: string;

  // tslint:disable-next-line:typedef
  placeId: number;

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('placeName', this.placeName);
    param.append('address', this.address);
    param.append('imageName', this.imageName);
    param.append('description', this.description);
    param.append('cityId', this.cityId);
    param.append('placeType', this.placeType);
    // tslint:disable-next-line:max-line-length
    if (this.placeType === null || this.placeName == null || this.imageName === null || this.description === null || this. cityId === null || this.address === null){
      alert('All fields are necessary');
      return;
    }
    else{
      this.service.save('place', param);
      this.empty();
    }
  }

  // tslint:disable-next-line:typedef
  updateData() {
    const param = new FormData();
    // @ts-ignore
    param.append('placeId', this.placeId);
    param.append('placeName', this.placeName);
    param.append('address', this.address);
    param.append('imageName', this.imageName);
    param.append('description', this.description);
    param.append('cityId', this.cityId);
    param.append('placeType', this.placeType);
    // tslint:disable-next-line:max-line-length
    if (this.placeType === null || this.placeId === null || this.placeName === null || this.imageName === null || this.description === null || this. cityId === null || this.address === null){
      alert('All fields are necessary');
      return;
    }
    else{
      this.service.update('place', param);
      this.empty();
    }
  }

  // tslint:disable-next-line:typedef
  empty() {
    this.placeType = null;
    this.placeId = null;
    this.placeName = null;
    this.imageName = null;
    this.description = null;
    this.cityId = null;
    this.address = null;
  }
}
