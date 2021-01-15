import { Component, OnInit } from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-place',
  templateUrl: './new-place.component.html',
  styleUrls: ['./new-place.component.css']
})
export class NewPlaceComponent implements OnInit {
  placeName: string;
  address: string;
  description: string;
  imageName: string;
  cityId: string;
  placeType: string;

  constructor(private service: HttpServicesService) { }

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
    this.service.save('place', param);
  }
}
