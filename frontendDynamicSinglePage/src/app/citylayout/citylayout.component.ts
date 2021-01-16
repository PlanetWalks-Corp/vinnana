import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {CityinfoService} from '../cityinfo.service';
import { Router, ActivatedRoute} from '@angular/router';
import {City} from '../classes';

@Component({
  selector: 'app-citylayout',
  templateUrl: './citylayout.component.html',
  styleUrls: ['./citylayout.component.css']
})
export class CitylayoutComponent implements OnInit {
  @Input('recCityId') id: number=-1;
  @Output() MainMenu:EventEmitter<boolean>= new EventEmitter()
  citi: any=-1;
   constructor(private cityinfo: CityinfoService, private route: ActivatedRoute) {
     this.route.params.subscribe( params => {this.id = params["id"]});
    }
  history = this.citi.history;//"The city of Jaipur was founded by King of Amer, Maharaja Sawai Jai Singh II on November 18, 1727.";
  image_source = "enter image source here";
  FoodPoint=['image1','image2', 'image3','image4'];
  PlacesToVisit = ['image1','image2', 'image3','image4'];
  FamousPersonalities = ['image1','image2', 'image3','image4'];
  ngOnInit(): void {
  this.cityinfo.getInfo(this.id).subscribe((data: any) => {
        console.log(data);
        this.citi = data;
  })
  }
  SendData()
  {
    this.MainMenu.emit(true)
  }

}
