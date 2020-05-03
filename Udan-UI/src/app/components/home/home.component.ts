import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [NgbCarouselConfig]
})
export class HomeComponent implements OnInit { 
  
  
  
  constructor(config:NgbCarouselConfig) {

    config.interval = 5000;
    config.wrap = true;
    config.keyboard = true;
    config.pauseOnHover=false;
   }
  ngOnInit(){
}
}

