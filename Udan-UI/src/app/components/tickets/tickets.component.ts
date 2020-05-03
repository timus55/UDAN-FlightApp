import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../../service/flight.service';
import { Flights } from '../../model/model.flight';
import { Tickets } from 'src/app/model/model.ticket';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {
  tickets: Tickets[]=[];
  searchText:any;
  
  constructor(private formBuilder: FormBuilder, private router: Router,
    private flightService :FlightService) { }

  ngOnInit(): void {
    this.flightService.viewTickets(sessionStorage.userid).subscribe(data=>{
      this.tickets = data;
      console.log(this.tickets);
    })
  }

  cancel(bookId:number){
    console.log(bookId)
    confirm(`Do you Want to cancel Your Booking ? Cancellation charges can be deeductted accordingly`);
    this.flightService.cancelTicket(bookId).subscribe(data=>{
      console.log(data);
      alert(`Booking Cancelled ..!`);
      this.flightService.viewTickets(sessionStorage.userid).subscribe(data=>{
        this.tickets = data;
        console.log(this.tickets);
      })
    })
  }
}
