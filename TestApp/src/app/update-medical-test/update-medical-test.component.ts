import { Component, OnInit } from '@angular/core';
import { TestService } from '../medical-test-service/medicaltestservice';
import { Test } from '../model/medicaltest';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-update-medical-test',
  templateUrl: './update-medical-test.component.html',
  styleUrls: ['./update-medical-test.component.css']
})
export class UpdateMedicalTestComponent implements OnInit {

  service:TestService;
  constructor(service:TestService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  modifiedTest:Test=null;
  errorFeild=null;
  modifyTest(data:any)
  {
    let details=data.value;
    let testId=details.testId;
    let testName=details.testName;

    this.modifiedTest=new Test();
  
    
  this.modifiedTest.testId=testId;
  this.modifiedTest.testName=testName;


  let result=this.service.modifyTest(this.modifiedTest,testId) // adding to the store
      result.subscribe((test:Test)=>{
        this.modifiedTest=test
      },
      err=>{
        this.errorFeild=err; 
        console.log("err="+Object.values(this.errorFeild));
      } );
      data.reset();
      this.errorFeild=null;
  }
}
