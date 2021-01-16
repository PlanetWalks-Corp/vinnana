import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'adminDynamicSinglePage';
  loggedIn: boolean;
  viewing = 1;
  update = false;

  // tslint:disable-next-line:typedef
  logIn() {
    this.loggedIn = true;
  }

  // tslint:disable-next-line:typedef
  change(viewing: number) {
    this.viewing = viewing;
  }

  // tslint:disable-next-line:typedef
  updatePlace(){
    this.update = true;
  }

  // tslint:disable-next-line:typedef
  createPlace() {
    this.update = false;
  }
}
