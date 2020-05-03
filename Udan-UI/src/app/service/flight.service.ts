import { Injectable } from '@angular/core';
import { Flights } from '../model/model.flight';
import { HttpClient } from '@angular/common/http';
import { Users } from '../model/model.user';
import { Tickets } from '../model/model.ticket';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  baseUrl: string = "http://localhost:9000/flights";
  baseUrl2: string = "http://localhost:9000/users";

  static bookflight :Flights;
  data:any;

  constructor(private http: HttpClient) { }

  setBookFlight(flight :Flights){
   FlightService.bookflight = flight;
  }
  getBookFlight(){
    return FlightService.bookflight;
  }


  getTicket(data:any){
    return this.http.get<Tickets>(`${this.baseUrl}/getBooking/${data}`);
  }
  bookFlight(flightid:number,userId:number){
    return this.http.get<Flights[]>(`${this.baseUrl}/bookFlight/${flightid}/${userId}`);
  }

  getFlight(source:string,destination:string){
    return this.http.get<Flights[]>(`${this.baseUrl}/searchFlight/${source}/${destination}`);
  }

  addUser(user:Users){
    return this.http.post<Users>(`${this.baseUrl2}/addUser`,user);
  }

  userValid(name:string,password:string){
    this.data = this.http.get(`${this.baseUrl2}/login/${name}/${password}`);
    if(this.data != null){
      sessionStorage.setItem('uname',name);
    } 
    return this.data;
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('uname');
    console.log(!(user == null))
    return !(user == null)
  }
  viewTickets(userId:number){
    // return this.http.get<Tickets[]>(`${this.baseUrl}/all/${FlightService.userId}`);
    return this.http.get<Tickets[]>(`${this.baseUrl}/all/${userId}`);
  }

  cancelTicket(bookingId:number){
    return this.http.get(`${this.baseUrl}/cancelFlight/${bookingId}`);
  }
}
