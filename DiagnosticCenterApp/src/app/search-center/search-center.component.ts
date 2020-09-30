import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DiagnosticCenter } from '../model/diagnosticcenter';
import { CenterService } from '../service/centerservice';
@Component({
  selector: 'app-search-center',
  templateUrl: './search-center.component.html',
  styleUrls: ['./search-center.component.css']
})
export class SearchCenterComponent implements OnInit {
service:CenterService;
  constructor(service:CenterService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  foundCenter=null;
  foundStatus=null;
  errorField=null;
findCenter(form:any)
{
  let details=form.value;
  let centerId=details.centerId;
  let fetched:Observable<DiagnosticCenter>=this.service.findUserByCenterId(centerId);

  fetched.subscribe(
    center=>{
      this.foundCenter=center;
      this.foundStatus="found";
    },
    err=>
    {
      this.foundStatus="notfound";
      this.errorField=err
      console.log(Object.values(err));
    }

  )
  

  }


}


