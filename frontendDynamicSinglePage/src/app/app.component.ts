import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  recCityId =-1;
  ReceivedId(data: number){
  this.recCityId = data;
  }
  title = 'test';
  home_menu=true;
  MainMenu(data: boolean)
  {
    this.home_menu=data;
  }
}
