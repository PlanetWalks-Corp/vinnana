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
      });
  }
}
