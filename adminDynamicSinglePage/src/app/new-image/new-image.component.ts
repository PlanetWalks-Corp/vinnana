import { Component, OnInit } from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-image',
  templateUrl: './new-image.component.html',
  styleUrls: ['./new-image.component.css']
})
export class NewImageComponent implements OnInit {
  imageName: string;
  albumId: string;

  constructor(private service: HttpServicesService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('imageName', this.imageName);
    param.append('albumId', this.albumId);
    this.service.save('image', param);
  }
}
