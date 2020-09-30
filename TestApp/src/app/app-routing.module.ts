import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddMedicalTestComponent } from './add-medical-test/add-medical-test.component';
import { DeleteMedicalTestComponent } from './delete-medical-test/delete-medical-test.component';
import { ListMedicalTestComponent } from './list-medical-test/list-medical-test.component';
import { UpdateMedicalTestComponent } from './update-medical-test/update-medical-test.component';
import { TestmgtComponent } from './testmgt/testmgt.component';
import { SearchMedicalTestComponent } from './search-medical-test/search-medical-test.component';


const routes: Routes = [

  {
    path:'testmgt',
    component:TestmgtComponent
  },

  {
    path:'add-medical-test',
    component: AddMedicalTestComponent
  },

  {
    path:'delete-medical-test',
    component:DeleteMedicalTestComponent
  },

  {
    path:'list-medical-test',
    component:ListMedicalTestComponent
  },

  {
    path:'update-medical-test',
    component:UpdateMedicalTestComponent
  },

  {
    path:'search-medical-test',
    component:SearchMedicalTestComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
