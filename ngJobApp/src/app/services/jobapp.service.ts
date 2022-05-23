import { catchError, throwError } from 'rxjs';
import { Jobapplication } from './../models/jobapplication';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';




@Injectable({
  providedIn: 'root'
})
export class JobappService {
  private jobapps: Jobapplication[] = [];

  private  url = environment.baseUrl + 'api/apps/';

  constructor(
    private http: HttpClient,
  ) { }

  getHttpOptions() {
    let options = {
      headers: {
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  index(){
    return this.http.get<Jobapplication[]>(this.url, this.getHttpOptions())
    .pipe(
      catchError((err: any) =>{
        console.log(err);
        return throwError('JobappService: error retrieving Job application list');
      })
    );
  }

  //  generateId() {
  //   return this.jobapps[this.jobapps.length - 1].id + 1;
  // }

  create(newJobApp: Jobapplication){
    const httpOptions = {
      headers: {
        'Content-type': 'application/json'
      }
    };
    return this.http.post<Jobapplication>(this.url, newJobApp, httpOptions)
    .pipe(
      catchError((err: any) =>{
        console.log(err);
        return throwError('httpClient threw error creating job application in Job Application Service');
      })
    );
  }

  retrieve(id: number){
    return this.http.get<Jobapplication>(this.url + '/' + id, this.getHttpOptions())
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService: error retrieving todo list')
      })
    );
  }

  update(updateJobApp : Jobapplication){
    const httpOptions = {
      headers: {
        'Content-type': 'application/json'
      }
    };
    return this.http.put<Jobapplication>(this.url + '/' + updateJobApp.id, updateJobApp, this.getHttpOptions())
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService: error creating Job Application');
      })
    );
  }

  destroy(id: number){
    return this.http.delete<void>(this.url + id, this.getHttpOptions())
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService: error retrieving todo list');

      })
    );
  }



}
