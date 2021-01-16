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
        alert('Data Saved Successfully');
      });
  }

  // tslint:disable-next-line:typedef
  update(name: string, param: FormData) {
    // tslint:disable-next-line:no-shadowed-variable
    const url = `http://localhost:8080/${name}/update`;
    this.http.put(url, param).toPromise()
      .then( (data: any) => {
        console.log(data);
        alert('updated Successfully');
      })
      .catch(() => {
        alert('Unable to Update');
      });
  }
}
