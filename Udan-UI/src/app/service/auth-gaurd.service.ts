import { Injectable } from '@angular/core';
import { CanActivate ,ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { FlightService } from './flight.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private router :Router,
    private flightService: FlightService) { }

canActivate(route :ActivatedRouteSnapshot,state: RouterStateSnapshot){
  if(this.flightService.isUserLoggedIn())
    return true;

    this.router.navigate(['login'])
    return false;
}

}
