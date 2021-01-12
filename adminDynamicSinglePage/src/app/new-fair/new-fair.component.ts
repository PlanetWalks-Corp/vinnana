import { Component, OnInit } from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-fair',
  templateUrl: './new-fair.component.html',
  styleUrls: ['./new-fair.component.css']
})
export class NewFairComponent implements OnInit {
  fairName: string;
  description: string;
  imageName: string;
  cityId: string;
  fairType: string;

  constructor(private service: HttpServicesService) { }

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('fairName', this.fairName);
    param.append('description', this.description);
    param.append('fairType', this.fairType);
    param.append('imageName', this.imageName);
    param.append('cityId', this.cityId);
    this.service.save('fair', param);
  }
}
