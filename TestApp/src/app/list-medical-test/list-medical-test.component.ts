import { Component, OnInit } from '@angular/core';
import { TestService } from '../medical-test-service/medicaltestservice';
import { Test } from '../model/medicaltest';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-medical-test',
  templateUrl: './list-medical-test.component.html',
  styleUrls: ['./list-medical-test.component.css']
})
export class ListMedicalTestComponent implements OnInit {

    ngOnInit(): void {
  }



  tests:Test[]=[];

  service:TestService;

  orderByField:string=null;

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
}
