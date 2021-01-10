import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CitiesConfig} from './cities-config';
import {Form} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class SavingDataService {

  constructor( private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  save(params: FormData, url: string){
    this.http.post(url, params).toPromise()
      .then( (data: any) => {
        console.log(data);
      });
  }
}
