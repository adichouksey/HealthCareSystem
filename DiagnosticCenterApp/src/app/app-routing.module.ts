import {NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCenterComponent } from './add-center/add-center.component';
import { HomeComponent } from './home/home.component';
import { ListCenterComponent } from './list-center/list-center.component';
import { RemoveCenterComponent } from './remove-center/remove-center.component';
import { SearchCenterComponent } from './search-center/search-center.component';
import { UpdateCenterComponent } from './update-center/update-center.component';


const routes: Routes = [
  {
    path:'add-center',
  component:AddCenterComponent
  },
  {
    path:'list-center',
  component:ListCenterComponent
  },
  {
    path:'remove-center',
  component:RemoveCenterComponent
  },
  {
    path:'update-center',
  component:UpdateCenterComponent
  },
  {
    path:'search-center',
  component:SearchCenterComponent
  },
  {
    path:'home',
  component:HomeComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
