import {HttpClient} from '@angular/common/http';
import {DiagnosticCenter} from '../model/diagnosticcenter';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs'
@Injectable()
export class CenterService{
  client:  HttpClient
  constructor(client:HttpClient)
  {
      this.client=client;
  }

  baseUserUrl="http://localhost:8090/centers";



  addCenter(center:DiagnosticCenter):Observable<DiagnosticCenter>{
    let url=this.baseUserUrl+"/add";
    let result:Observable<DiagnosticCenter>= this.client.post<DiagnosticCenter>(url,center);
    return result;
    }
    
    fetchAllCenters():Observable<DiagnosticCenter[]>
    {
      let url=this.baseUserUrl;
      let observable:Observable<DiagnosticCenter[]> =this.client.get<DiagnosticCenter[]>(url);
      return observable;
    }

    findUserByCenterId(centerId:String):Observable<DiagnosticCenter>{
      let url=this.baseUserUrl+'/get/'+centerId
      let observable:Observable<DiagnosticCenter> =this.client.get<DiagnosticCenter>(url);
      return observable;  
    }
  
  
    deleteCenter(centerId:String){
      let url=this.baseUserUrl+"/delete/"+centerId;
      let result:Observable<boolean>=this.client.delete<boolean>(url);
      return result;
    }

    modifyCenter(center:DiagnosticCenter,centerId:String):Observable<DiagnosticCenter>{
      let url=this.baseUserUrl+"/modify/"+centerId;
     // console.log("userId"+user.userId+"username"+user.userName+"usertype"+user.userType+"userphone"+user.userPhone+"useremail:"+user.email);
      let result:Observable<DiagnosticCenter>= this.client.put<DiagnosticCenter>(url,center);
      return result;
      }
    

}