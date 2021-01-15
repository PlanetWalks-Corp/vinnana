import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {CityinfoService} from '../cityinfo.service';
import {City} from '../classes';
@Component({
  selector: 'app-citylayout',
  templateUrl: './citylayout.component.html',
  styleUrls: ['./citylayout.component.css']
})
export class CitylayoutComponent implements OnInit {
  @Input('recCityId') public cityid;
  @Output() MainMenu:EventEmitter<boolean>= new EventEmitter()
  citi: City [] = [];
   constructor(private cityinfo: CityinfoService) { }
  history =this.citi[0].history; //"The city of Jaipur was founded by King of Amer, Maharaja Sawai Jai Singh II on November 18, 1727.";
  image_source =this.citi[0].album.image; //"enter image source here";
  FoodPoint=['image1','image2', 'image3','image4'];
  PlacesToVisit = ['image1','image2', 'image3','image4'];
  FamousPersonalities = ['image1','image2', 'image3','image4'];
  ngOnInit(): void {
  this.cityinfo.getInfo().subscribe((data) => {
        this.citi = data;
  })
  }
  SendData()
  {
    this.MainMenu.emit(true)
  }

}
