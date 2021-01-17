import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CityinfoService {
  constructor(private http: HttpClient) { }
  id =-1;
  sendData(data: number){
    this.id = data;
  }
  getCityInfo(cityid: number){
    const url=`http://localhost:8080/cities/${cityid}`;
    return this.http.get(url);
  }

}
