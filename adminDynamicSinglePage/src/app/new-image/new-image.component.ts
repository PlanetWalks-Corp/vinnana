import {Component, Input, OnInit} from '@angular/core';
import {HttpServicesService} from '../http-services.service';

@Component({
  selector: 'app-new-image',
  templateUrl: './new-image.component.html',
  styleUrls: ['./new-image.component.css']
})
export class NewImageComponent implements OnInit {

  constructor(private service: HttpServicesService) { }
  // tslint:disable-next-line:no-input-rename
  @Input('update') update: boolean;
  imageName: string;
  albumId: string;

  // tslint:disable-next-line:typedef
  imageId: string;

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  saveData() {
    const param = new FormData();
    param.append('imageName', this.imageName);
    param.append('albumId', this.albumId);
    if (this.imageName === null || this.albumId === null){
      alert('All fields are necessary');
      return;
    }
    else{
      this.service.save('image', param);
      this.empty();
    }
  }

  // tslint:disable-next-line:typedef
  updateData() {
    const param = new FormData();
    param.append('imageName', this.imageName);
    param.append('albumId', this.albumId);
    param.append('imageId' , this.imageId);
    if (this.imageName === null || this.albumId === null || this.imageId === null){
      alert('All fields are necessary');
      return;
    }
    else{
      this.service.update('image', param);
      this.empty();
    }
  }
  // tslint:disable-next-line:typedef
  empty(){
    this.imageId = null;
    this.imageName = null;
    this.albumId = null;

  }
}
