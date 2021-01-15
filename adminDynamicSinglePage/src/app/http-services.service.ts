import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as url from 'url';

@Injectable({
  providedIn: 'root'
})
export class HttpServicesService {

  constructor(public http: HttpClient) { }

  // tslint:disable-next-line:typedef
  save(name: string, param: FormData) {
    // tslint:disable-next-line:no-shadowed-variable
    const url = `http://localhost:8080/${name}/save`;
    this.http.post(url, param).toPromise()
      .then( (data: any) => {
        console.log(data);
        if (name === 'cities'){
          const newUrl = `http://localhost:8080/album/save`;
          const albumParam = new FormData();
          albumParam.append('albumName', data.cityName);
          albumParam.append('cityId', data.cityId);
          this.http.post(newUrl, albumParam).toPromise()
            // tslint:disable-next-line:no-shadowed-variable
            .then( ( response: any) => {
              console.log(response);
            });
        }
      });
  }
}
