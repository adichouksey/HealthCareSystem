import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TestService } from './medical-test-service/medicaltestservice';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddMedicalTestComponent } from './add-medical-test/add-medical-test.component';
import { DeleteMedicalTestComponent } from './delete-medical-test/delete-medical-test.component';
import { ListMedicalTestComponent } from './list-medical-test/list-medical-test.component';
import { UpdateMedicalTestComponent } from './update-medical-test/update-medical-test.component';
import { TestmgtComponent } from './testmgt/testmgt.component';
import { SearchMedicalTestComponent } from './search-medical-test/search-medical-test.component';

@NgModule({
  declarations: [
    AppComponent,
    AddMedicalTestComponent,
    DeleteMedicalTestComponent,
    ListMedicalTestComponent,
    UpdateMedicalTestComponent,
    TestmgtComponent,
    SearchMedicalTestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [TestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
