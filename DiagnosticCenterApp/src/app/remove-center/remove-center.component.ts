import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CenterService } from '../service/centerservice';
import { Observable} from 'rxjs';
import {DiagnosticCenter} from '../model/diagnosticcenter'
import { nullSafeIsEquivalent } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-remove-center',
  templateUrl: './remove-center.component.html',
  styleUrls: ['./remove-center.component.css']
})
export class RemoveCenterComponent implements OnInit {
data=null;
centerId=null;
service:CenterService;
centers:DiagnosticCenter[]=[];
ngOnInit(): void {
}

  constructor(
    private activatedroute:ActivatedRoute,service:CenterService)
    {   
      this.service=service;
      this.activatedroute.queryParams.subscribe
      (data=>{
        this.data=data;
        this.centerId=Object.values(data);
        console.log(this.centerId);
        }) 

      let observable:Observable<DiagnosticCenter[]>=this.service.fetchAllCenters();
    observable.subscribe(
      center=>{
        this.centers=center
        console.log(this.centers);
      },
      err=>console.log(err)
      );

        
      }
      
      checkDeletion=null;
        remove(form:any)
        {
          let details=form.value;
          let cId=details.id;
          console.log(cId);

          let result:Observable<boolean>=this.service.deleteCenter(cId);
          result.subscribe(center=>{
           this.checkDeletion=center;
            this.removeLocal(this.centerId);
          },err=>{
           console.log("err in deleting ="+err);
          })   
          form.reset();
        }
      
       
        removeLocal(centerId:String)
        {
          let foundIndex=-1;
          for(let i=0;i<this.centers.length;i++){
            let center=this.centers[i];
            if(center.centerId===centerId){
              foundIndex=i;
              break;
            }
          }
          if(foundIndex<0){
            return;
          }
          this.centers.splice(foundIndex,1);
        }
          }


        
      
   

  