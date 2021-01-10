import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'database';
  flag = 1;

  // tslint:disable-next-line:typedef
  changeFlag(flag: number) {
    this.flag = flag;
  }
}
