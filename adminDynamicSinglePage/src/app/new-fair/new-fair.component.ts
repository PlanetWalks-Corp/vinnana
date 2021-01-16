import {Component, Input, OnInit} from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-fair',
  templateUrl: './new-fair.component.html',
  styleUrls: ['./new-fair.component.css']
})
export class NewFairComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('update') update: boolean;
  fairName: string;
  description: string;
  imageName: string;
  cityId: string;
  fairType: string;
  fairId: number;

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
    if (this.fairName === null || this.description === null || this.fairType == null || this.imageName === null || this.cityId === null){
      alert('All fields are necessary');
    }
    else {
      this.service.save('fair', param);
      this.empty();
    }
  }

  // tslint:disable-next-line:typedef
  updateData() {
    const param = new FormData();
    // @ts-ignore
    param.append('fairId', this.fairId);
    param.append('fairName', this.fairName);
    param.append('description', this.description);
    param.append('fairType', this.fairType);
    param.append('imageName', this.imageName);
    param.append('cityId', this.cityId);
    // tslint:disable-next-line:max-line-length
    if (this.fairId === null || this.fairName === null || this.description === null || this.fairType == null || this.imageName === null || this.cityId === null){
      alert('All fields are necessary');
      return;
    }
    else {
      this.service.update('fair', param);
      this.empty();
    }
  }
  // tslint:disable-next-line:typedef
  empty(){
    this.cityId = null;
    this.fairId = null;
    this.fairName = null;
    this.fairType = null;
    this.imageName = null;
    this.description = null;
  }
}
