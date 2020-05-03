import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../../service/flight.service';
import { timer } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // creatinf FormGroup object
  loginForm: FormGroup;

  submitted: boolean = false;
  // Constructor Dependency Injection
  // Dependency Injection makes your application loosey typed
  // So that application can be easily maintained

  // FormBuilder to build form elements with defaut values and validations
  // Router service to navigate programmatically from component to other
  constructor(private formBuilder: FormBuilder, private router: Router,
   private flightService: FlightService) { }

  // Life Cycle Hook
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username:['',[Validators.required, Validators.pattern("[A-Za-z][A-Za-z0-9]{2,10}")]],
      password: ['',[Validators.required]],
    });
  }

  refresh(){
    this.submitted=false;
    this.invalidLogin=false;
  }
  verifyLogin() {
    this.submitted=true;
    if (this.loginForm.invalid) {
      return;
    }

    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;

    console.log(username + password);
    this.flightService.userValid(username, password).subscribe(data => {
      console.log(data);
      if (data > 0) {
        alert(`${this.loginForm.controls.username.value} Logged In successfully ..!`);
        localStorage.userid = data;
        sessionStorage.userid = data;
        this.router.navigate(['/home']);
      }
      // else {
        
      //   return;

      // }
    },err=>{
      this.invalidLogin=true;
        console.log(err);
        timer

        
    })
  } // end of verifyLogin() function

  invalidLogin: boolean = false;
}


