import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../Item';

const baseUrl = 'http://localhost:8080/items';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }

  // get all
  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }

  // get by id
  get(id: number): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  // add new
  create(data: Item): Observable<any> {
    return this.http.post(baseUrl, data,{responseType:'text' as 'json'});
  }

  // deposit or withdraw
  update(id: number, data: number): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  // delete by id
  delete(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
}
