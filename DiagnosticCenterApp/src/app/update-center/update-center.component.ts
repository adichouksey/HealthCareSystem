import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DiagnosticCenter } from '../model/diagnosticcenter';
import { CenterService} from '../service/centerservice';
@Component({
  selector: 'app-update-center',
  templateUrl: './update-center.component.html',
  styleUrls: ['./update-center.component.css']
})
export class UpdateCenterComponent implements OnInit {
  data=null;
  center=null;
  centerId=null;
  centerName=null;
service:CenterService;

  constructor(private activatedroute:ActivatedRoute,service:CenterService) {
 this.service=service;
  this.activatedroute.queryParams.subscribe(data=>{
  this.data=data;
  this.center=Object.values(data);
  this.centerId=this.center[0];
  this.centerName=this.center[1];
  console.log(this.center[0]);
  }) 
  }
modifiedCenter=null;
modified="not modified";
  ngOnInit(): void {

  }
errorField=null;
update(form:any)
{ 
  let details=form.value;
  let id=details.id;
  let centerName=details.name;
  console.log(id);
  this.modifiedCenter=new DiagnosticCenter();
  this.modifiedCenter.centerId=id;
  this.modifiedCenter.centerName=centerName;
  let result=this.service.modifyCenter(this.modifiedCenter,id) // adding to the store

    result.subscribe((center:DiagnosticCenter)=>{
    this.modified="modified";

    },
    err=>{
      this.errorField=err;
      
    console.log("err="+err);
    } );
    
    this.errorField=null;

}

}
