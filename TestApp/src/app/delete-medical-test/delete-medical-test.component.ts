import { Component, OnInit } from '@angular/core';
import { TestService } from '../medical-test-service/medicaltestservice';
import { Test } from '../model/medicaltest';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-medical-test',
  templateUrl: './delete-medical-test.component.html',
  styleUrls: ['./delete-medical-test.component.css']
})
export class DeleteMedicalTestComponent implements OnInit {

  

  tests:Test[]=[];
  ngOnInit(): void {
  }

  service:TestService;
  constructor(service:TestService,private router:Router) {
  
    this.service=service;

    let observable:Observable<Test[]>=this.service.fetchAllTest();
    observable.subscribe(
      test=>{
        this.tests=test;
        console.log("inside success callback ="+this.tests.length);
      },
      err=>console.log(err)
      );
    }

    removeTest(testId:string)
    {
   let result:Observable<boolean>=this.service.deleteTest(testId);
   result.subscribe(product=>{
       this.removeLocalTest(testId);
   },err=>{
    console.log("err in deleting ="+err);
   })   
  }
  
  
removeLocalTest(testId:string)
{
let foundIndex=-1;
for(let i=0;i<this.tests.length;i++){
 let product=this.tests[i];
 if(product.testId===testId){
   foundIndex=i;
   break;
 }
}
if(foundIndex<0){
 return;
}
this.tests.splice(foundIndex,1);
}




}
