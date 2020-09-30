import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import {Test} from '../model/medicaltest';
import {HttpClient} from '@angular/common/http';
@Injectable()


export class TestService{

    client:HttpClient ;
    constructor(client:HttpClient ){
    this.client=client;
    }
    baseProductUrl="http://localhost:8085/test";

    addTest(test:Test): Observable<Test>{
        let url=this.baseProductUrl+"/add";
        let result:Observable<Test>= this.client.post<Test>(url,test);
        return result;
        }


        deleteTest(testId:String){
            let url=this.baseProductUrl+"/delete/"+testId;
            let result:Observable<boolean>=this.client.delete<boolean>(url);
            return result;
          }

          modifyTest(test:Test,testId:string):Observable<Test>{
            let url=this.baseProductUrl+"/modify/"+testId;
            console.log("Test Id"+test.testId+ "Test name"+test.testName);
            let result:Observable<Test>= this.client.put<Test>(url,test);
            return result;
            }


            fetchAllTest():Observable<Test[]>
            {
              let url=this.baseProductUrl;
              let result:Observable<Test[]> =this.client.get<Test[]>(url);
              return result;
            }


            findTestById(testId:string):Observable<Test>{
              let url=this.baseProductUrl+"/get/"+testId;
              let observable:Observable<Test> =this.client.get<Test>(url);
              return observable;  
            }
          
}