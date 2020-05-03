import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../../service/flight.service';
import { Flights } from 'src/app/model/model.flight';
import { Tickets } from 'src/app/model/model.ticket';
import { NgbModal,ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  bookForm: FormGroup;
  invalidLogin: boolean = false;
  isValidUser: boolean = false;
  submitted: boolean = false;
  flight: Flights;
  bookStatus:boolean = false;
  paymentStatus:boolean = true;

  bookId:any;


  constructor(private formBuilder: FormBuilder, private router: Router,
    private flightService: FlightService) { }

  
  ngOnInit() {
    this.bookForm = this.formBuilder.group({
      flightid: ['', Validators.required],
      // userid: ['', Validators.required]
    });

    this.flight = this.flightService.getBookFlight();
    this.bookStatus = false;
  }

  paynow() {
    
    alert(`Pay ${this.flight.totalFare} rupees ..!`);

    this.flightService.bookFlight(this.flight.flightId,sessionStorage.userid).subscribe(data => {
      console.log(data);
      this.bookId=data;
      this.bookStatus=true;
      this.paymentStatus=false;
      alert(`Payment Successful Booking ID = ${data} ..!`);
      // this.router.navigate(['/tickets']);

    }, err => {
      this.bookStatus=false;
      console.log(err.stack())
    })
  }

}
