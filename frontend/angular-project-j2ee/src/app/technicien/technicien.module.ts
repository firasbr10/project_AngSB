import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { TechnicienRoutingModule } from './technicien-routing.module';
import { TechnicienComponent } from './technicien.component';
import { ListTechnicienComponent } from './list-technicien/list-technicien.component';
import { AddTechnicienComponent } from './add-technicien/add-technicien.component';
import { EditTechnicienComponent } from './edit-technicien/edit-technicien.component';


@NgModule({
  declarations: [
    TechnicienComponent,
    ListTechnicienComponent,
    AddTechnicienComponent,
    EditTechnicienComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    TechnicienRoutingModule
  ]
})
export class TechnicienModule { }
