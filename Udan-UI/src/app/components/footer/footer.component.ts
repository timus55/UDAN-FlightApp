import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {

  todaysDate = new Date();

    // In Typescript, constructors cannot be overloaded
    // Only one constuctor per class
    constructor(){
      // setInterval() asynchronous function 
      // Arrow functions ( => )
      setInterval(()=>{
        this.todaysDate = new Date();
      },100);
    }

}
