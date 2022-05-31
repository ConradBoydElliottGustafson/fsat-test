import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

/**
 * Backend api call service.
 */

@Injectable({
  providedIn: 'root'
})
export class FsaApiServiceService {

  constructor(private http: HttpClient) { }

  getCities(): Observable<any>{
    return this.http.get(`http://${environment.api.host}/${environment.api.endpoint.cities}`);
  }

}