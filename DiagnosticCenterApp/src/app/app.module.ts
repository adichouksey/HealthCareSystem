import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from  '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { RemoveCenterComponent } from './remove-center/remove-center.component';
import { UpdateCenterComponent } from './update-center/update-center.component';
import { ListCenterComponent } from './list-center/list-center.component';
import { SearchCenterComponent } from './search-center/search-center.component';
import { CenterService } from './service/centerservice';
import { HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    AddCenterComponent,
    RemoveCenterComponent,
    UpdateCenterComponent,
    ListCenterComponent,
    SearchCenterComponent,
    HomeComponent
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [CenterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
