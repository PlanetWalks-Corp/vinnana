import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-citylayout',
  templateUrl: './citylayout.component.html',
  styleUrls: ['./citylayout.component.css']
})
export class CitylayoutComponent implements OnInit {
  @Output() MainMenu:EventEmitter<boolean>= new EventEmitter()
  constructor() { }
  history = "The city of Jaipur was founded by King of Amer, Maharaja Sawai Jai Singh II on November 18, 1727.";
  image_source = "enter image source here";
  FoodPoint=['image1','image2', 'image3','image4'];
  PlacesToVisit = ['image1','image2', 'image3','image4'];
  FamousPersonalities = ['image1','image2', 'image3','image4'];
  ngOnInit(): void {
    
  }
  SendData()
  {
    this.MainMenu.emit(true)
  }

}
