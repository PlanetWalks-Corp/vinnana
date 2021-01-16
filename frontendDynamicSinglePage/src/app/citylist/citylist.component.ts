import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {AdminService} from '../admin.service';
import {City} from '../classes';
import {Router} from '@angular/router';
@Component({
  selector: 'app-citylist',
  templateUrl: './citylist.component.html',
  styleUrls: ['./citylist.component.css']
})
export class CitylistComponent implements OnInit {
  constructor(private adminService: AdminService, private router: Router) { }
@Output() public sendChildId = new EventEmitter<number>();
  cities: City [] = [];
  image_source = 'https://images.unsplash.com/photo-1610221666445-5a6b429e0374?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80';
  sendId(id: number){
  console.log(id);
  this.sendChildId.emit(id);
  this.router.navigate(['cities', id]);
  }
  ngOnInit(): void {
    this.adminService.getList().subscribe((result: any) => {
      console.warn(result);
      this.cities = result;
    });
  }
}
