import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {CityinfoService} from '../cityinfo.service';
import {City} from '../classes';

@Component({
  selector: 'app-citylayout',
  templateUrl: './citylayout.component.html',
  styleUrls: ['./citylayout.component.css']
})
export class CitylayoutComponent implements OnInit {
  @Input('recCityId') cityid=-1;
  @Output() MainMenu:EventEmitter<boolean>= new EventEmitter()
  citi: Array<any> = [];
   constructor(private cityinfo: CityinfoService) {
     
    }
  history = "The city of Jaipur was founded by King of Amer, Maharaja Sawai Jai Singh II on November 18, 1727.";
  image_source = "enter image source here";
  FoodPoint=['image1','image2', 'image3','image4'];
  PlacesToVisit = ['image1','image2', 'image3','image4'];
  FamousPersonalities = ['image1','image2', 'image3','image4'];
  ngOnInit(): void {
  this.cityinfo.getInfo(this.cityid).subscribe((data: any) => {
        this.citi = data[0];
  })
  }
  SendData()
  {
    this.MainMenu.emit(true)
  }

}
