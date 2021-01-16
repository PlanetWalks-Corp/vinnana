import { Component } from '@angular/core';
import {CityinfoService} from 'src/app/cityinfo.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  recCityId: number;
  ReceivedId(data: number){
  this.recCityId = data;
  }
  public constructor(private cityinfo: CityinfoService) {
    this.cityinfo.sendData(this.recCityId);
  }
  title = 'test';
  home_menu=true;
  MainMenu(data: boolean)
  {
    this.home_menu=data;
  }
}

