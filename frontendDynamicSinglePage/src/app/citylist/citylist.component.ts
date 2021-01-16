import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {AdminService} from '../admin.service';
import {City} from '../classes';
@Component({
  selector: 'app-citylist',
  templateUrl: './citylist.component.html',
  styleUrls: ['./citylist.component.css']
})
export class CitylistComponent implements OnInit {
@Output() public sendChildId = new EventEmitter<number>();
  SendId(event){
  const id = event.target.attributes.id;
  console.log(id);
  this.sendChildId.emit(id);
  }
  constructor(private adminService: AdminService ) { }
  cities: City [] = [];
  image_source = "https://images.unsplash.com/photo-1610221666445-5a6b429e0374?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
  ngOnInit(): void {
    this.adminService.getList().subscribe((result: any)=>{
      console.warn(result);
      this.cities=result;
    })
  }
}
