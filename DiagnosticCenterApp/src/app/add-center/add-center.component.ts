import { Component, OnInit } from '@angular/core';
import {CenterService} from '../service/centerservice';
import {DiagnosticCenter} from'../model/diagnosticcenter';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {
service:CenterService

  constructor(service:CenterService) {
    this.service=service;
   }

  ngOnInit(): void {
  }
addedCenter:DiagnosticCenter=null;

errorField=null;
addCenter(form:any)
{
  let details=form.value;
  let name=details.name;
  this.addedCenter =new DiagnosticCenter();
  this.addedCenter.centerName=name;
  
  let result=this.service.addCenter(this.addedCenter)
  result.subscribe((center:DiagnosticCenter)=>
  {
this.addedCenter=center;
  },
  err=>{
    this.errorField=err;
    console.log("err="+Object.values(this.errorField));
    
    } );
    form.reset();
    this.errorField=null;

}


}
