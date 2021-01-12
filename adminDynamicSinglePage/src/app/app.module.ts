import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { NewCityComponent } from './new-city/new-city.component';
import { NewPersonComponent } from './new-person/new-person.component';
import { NewFairComponent } from './new-fair/new-fair.component';
import { NewImageComponent } from './new-image/new-image.component';
import { NewPlaceComponent } from './new-place/new-place.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NewCityComponent,
    NewPersonComponent,
    NewFairComponent,
    NewImageComponent,
    NewPlaceComponent
  ],
  imports: [
    HttpClientModule,
    BsDropdownModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
