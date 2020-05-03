import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(flightList: any, searchText:any,): any {
    let newList: any;

      newList = flightList.filter(flight=> flight.source==(searchText) || 
      flight.destination==(searchText) || flight.flightId == (searchText));
        
    return newList;
  }

}
