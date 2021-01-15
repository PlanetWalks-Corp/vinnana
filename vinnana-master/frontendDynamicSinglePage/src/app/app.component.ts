import { Component } from '@angular/core';
import {CityinfoService} from 'src/app/cityinfo.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 
 constructor() {
    
  }
  title = 'test';
  home_menu=false;
  MainMenu(data: boolean)
  {
    this.home_menu=data;
  }
}
