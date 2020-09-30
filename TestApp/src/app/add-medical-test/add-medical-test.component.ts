import { Component, OnInit } from '@angular/core';
import { TestService } from '../medical-test-service/medicaltestservice';
import { Test } from '../model/medicaltest';


@Component({
  selector: 'app-add-medical-test',
  templateUrl: './add-medical-test.component.html',
  styleUrls: ['./add-medical-test.component.css']
})
export class AddMedicalTestComponent implements OnInit {

  service:TestService;
  constructor(service:TestService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  addedTest:Test=null;
    errorFeild=null;
    
   addTest(data:any){
    let details=data.value;

    let testName=details.testName;

    this.addedTest= new Test();
    
    
    this.addedTest.testName=testName;


    let result=this.service.addTest(this.addedTest); // adding to the store
result.subscribe((test:Test)=>{
  this.addedTest=test;
  
  
  
},
err=>{
this.errorFeild=err; 
  console.log("err="+Object.values(this.errorFeild));
 
} );

data.reset();
this.errorFeild=null;

   }

}
