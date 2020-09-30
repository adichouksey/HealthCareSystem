import { Component, OnInit } from '@angular/core';
import {DiagnosticCenter} from '../model/diagnosticcenter';
import { CenterService } from '../service/centerservice';
import {Observable} from 'rxjs';
import{ Router} from '@angular/router';
@Component({
  selector: 'app-list-center',
  templateUrl: './list-center.component.html',
  styleUrls: ['./list-center.component.css']
})
export class ListCenterComponent implements OnInit {

  
centers:DiagnosticCenter[]=[];
  ngOnInit(): void {
  }
 

service:CenterService
constructor(service:CenterService,private router:Router) {
  this.service=service;
 let observable:Observable<DiagnosticCenter[]>=this.service.fetchAllCenters();
 observable.subscribe(
   center=>{
     this.centers=center;
     console.log("inside success callback ="+this.centers.length)
   },
   err=>
   { 
     console.log(err)
   }
 );
}




centerId=null;
centerName=null;
  remove(centerId:String)
{this.centerId=centerId;
  this.router.navigate(['../remove-center'],{queryParams:{centerId:this.centerId}});
}



update(centerId:String,centerName:String)
{   this.centerId=centerId;
  this.centerName=centerName;
  this.router.navigate(['../update-center'],{queryParams:{centerId:this.centerId,centerName:this.centerName}})
}
}
