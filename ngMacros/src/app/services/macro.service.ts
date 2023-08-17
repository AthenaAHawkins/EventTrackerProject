import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Macros } from '../models/macros';

@Injectable({
  providedIn: 'root',
})
export class MacroService {
  private baseUrl = 'http://localhost:8085/'; // adjust port to match server
  private url = this.baseUrl + 'api/macros'; // change 'todos' to your API path

  constructor(private http: HttpClient) {}

  index(): Observable<Macros[]> {
    return this.http.get<Macros[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TodoService.index(): error retrieving todo: ' + err)
        );
      })
    );
  }
}
