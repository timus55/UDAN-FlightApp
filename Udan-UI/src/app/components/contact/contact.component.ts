import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {


  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  submitDetails(){
    alert('Details Collected We will contact You soon ..!')
    this.router.navigate(['\home']);
  }
}
