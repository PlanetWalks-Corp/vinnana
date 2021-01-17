import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {CityinfoService} from '../cityinfo.service';
import { ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
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
  place: any=-1;
  person: any=-1;
   constructor(private cityinfo: CityinfoService, private route: ActivatedRoute, private router: Router) {
     this.route.params.subscribe( params => {this.id = params["id"]});
    }
  history = this.citi.history;//"The city of Jaipur was founded by King of Amer, Maharaja Sawai Jai Singh II on November 18, 1727.";
  image_source = 'https://res.cloudinary.com/ksush/image/upload/v1610801552/deviTalab_dzxpmf.jpg';
  FoodPoint=this.place.description;
  PlacesToVisit = ['image1','image2', 'image3','image4'];
  FamousPersonalities = ['image1','image2', 'image3','image4'];
  ngOnInit(): void {
  this.cityinfo.getCityInfo(this.id).subscribe((data: any) => {
        this.citi = data;
  })

  this.cityinfo.getPlaceInfo(this.id).subscribe((data: any) => {
    console.log(data);
    this.place = data;
})

this.cityinfo.getPersonInfo(this.id).subscribe((data: any) => {
  this.person = data;
})
  }


}
