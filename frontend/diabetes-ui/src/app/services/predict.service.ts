import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PredictService {
private apiUrl = 'https://diabetes-ai-project-sldx.onrender.com/api/predict';

  constructor(private http: HttpClient) {}

  predict(data: any): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }
}