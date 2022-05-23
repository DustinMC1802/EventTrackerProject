import { Jobapplication } from './../../models/jobapplication';
import { Component, OnInit } from '@angular/core';
import { JobappService } from 'src/app/services/jobapp.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  jobApps: Jobapplication[] = [];

  newJobApp: Jobapplication = new Jobapplication;

  selected: Jobapplication | null = null;

  editJobApp: Jobapplication | null = null;

  constructor(private jobAppServe: JobappService) { }

  ngOnInit(): void {this.reload()
  }

  setApp(jobApp: Jobapplication){
    this.selected = jobApp;
  }

  reload() {
    this.jobAppServe.index().subscribe(
      data => this.jobApps = data,
      err => console.error(err)
    );
  }

  loadJobApp(){
    this.jobAppServe.index().subscribe(
      success => this.jobApps = success,
      err => console.log('Observable got an error' + err)
    );
  }

  createJobApp(jobApp: Jobapplication){
    this.jobAppServe.create(jobApp).subscribe(
      data =>{
        this.loadJobApp();
        this.newJobApp = new Jobapplication();
      },
      err => console.log('Observable got an error' + err)
    );
  }

  setEditJobApp(){
    this.editJobApp = Object.assign({}, this.selected);
  }

  updateJobApp(jobApp: Jobapplication){
    this.jobAppServe.update(jobApp).subscribe(
      data => {
        this.reload();
        this.editJobApp = null;
        if(this.selected){
          this.selected = Object.assign({},jobApp)
        }
      },
      err => console.error(err)
    );
  }

  deleteJobApp(id: number){
    // this.jobAppServe.destroy(id);
    // this.jobApps = this.jobAppServe.index();
    this.jobAppServe.destroy(id).subscribe(
      data => this.reload(),
      err => console.error(err)
    );
  }


}
