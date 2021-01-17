import { Component } from '@angular/core';
import {CityinfoService} from 'src/app/cityinfo.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public constructor(private cityinfo: CityinfoService, private router: Router,) {
    this.cityinfo.sendData(this.recCityId);
  }
  recCityId = -1;
  home_menu = true;
  title = 'test';
  ReceivedId(data: number){
  this.recCityId = data;
  this.home_menu = false;
  }

  MainMenu(data: boolean)
  {
    this.home_menu = data;
  }
  SendData()
  {
    this.router.navigate(['cities']);
  }
}

