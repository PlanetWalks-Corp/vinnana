import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url ='http://localhost:8080/cities';
  constructor(private http: HttpClient) { }
  getList()
  {
    return this.http.get(this.url);
  }
}
