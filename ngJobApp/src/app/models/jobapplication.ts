export class Jobapplication {
  id: number;
  title: string;
  city: string;
  state: string;
  company: string;
  postingDate: string;
  dateApplied: string;
  offer: boolean;
  url: string;
  jobNumber: string;

  constructor(
    id: number = 0,
  title: string = '',
  city: string = '',
  state: string = '',
  company: string = '',
  postingDate: string = '',
  dateApplied: string = '',
  offer: boolean = false,
  url: string = '',
  jobNumber: string = '',
  ){
    this.id = id;
    this.title = title;
    this.city = city;
    this.state = state;
    this.company = company;
    this.postingDate = postingDate;
    this.dateApplied = dateApplied;
    this.offer = offer;
    this.url = url;
    this.jobNumber = jobNumber;

  }

}
