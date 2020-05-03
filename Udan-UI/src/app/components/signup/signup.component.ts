import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../../service/flight.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  submitted: boolean = false;
  invalidSignUp: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router,
   private flightService : FlightService) { }

  ngOnInit(){
    this.signUpForm = this.formBuilder.group({

      name:['', [Validators.required, Validators.pattern("[A-Z][a-z]{2,14}")]],
      username:['',[Validators.required, Validators.pattern("[A-Za-z][A-Za-z0-9]{2,10}")]],
      phoneNum:['', [Validators.required, Validators.pattern("[6-9][0-9]{9}")]],
      age:['',[Validators.required,Validators.min(10), Validators.max(110)]],
      password: ['',[Validators.required, Validators.pattern("[A-Za-z][A-Za-z0-9]{5,10}")]],
    });
  }

  refresh(){
    this.submitted = false;
    this.invalidSignUp = false;
  }

  verifyLogin(){
    this.submitted = true;
    if(this.signUpForm.invalid){
      return;
    }
      console.log(this.signUpForm.value);

      this.flightService.addUser(this.signUpForm.value).subscribe(data =>{
        console.log(data);
        alert(`${this.signUpForm.controls.name.value} SignUped successfully ..!`);
        this.router.navigate(['/login']);
      },
      err =>{
        this.invalidSignUp = true;
        console.log(err)
      })
    }
  }
