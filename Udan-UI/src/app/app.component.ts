import { Component, OnInit } from '@angular/core';
import { FlightService } from 'src/app/service/flight.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'Flight Management App';
    // creating date object
    todaysDate = new Date();


    // In Typescript, constructors cannot be overloaded
    // Only one constuctor per class
    constructor(private flightService:FlightService){
      // setInterval() asynchronous function 
      // Arrow functions ( => )
      setInterval(()=>{
        this.todaysDate = new Date();
      },1000);
    }
}
