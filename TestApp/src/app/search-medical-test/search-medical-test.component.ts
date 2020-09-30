import { Component, OnInit } from '@angular/core';
import { TestService } from '../medical-test-service/medicaltestservice';
import { Test } from '../model/medicaltest';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-search-medical-test',
  templateUrl: './search-medical-test.component.html',
  styleUrls: ['./search-medical-test.component.css']
})
export class SearchMedicalTestComponent implements OnInit {

  service:TestService
  constructor(service:TestService) {
    this.service=service
   }
   
   ngOnInit(): void {
  }

  foundTest=null;
  foundStatus=null;
  
    findTest(data:any):void
    {
      let details=data.value;
      let testId=details.testId;
      let fetched:Observable<Test> =this.service.findTestById(testId)
     fetched.subscribe(
      test=>{
      this.foundTest=test;
      this.foundStatus="found";
       },
      err=>{
        this.foundStatus="notfound";
       console.log("err while fetching ="+err);  
       }
     );    
  
      }

}
