import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TechnicienRoutingModule } from './technicien-routing.module';
import { TechnicienComponent } from './technicien.component';


@NgModule({
  declarations: [
    TechnicienComponent
  ],
  imports: [
    CommonModule,
    TechnicienRoutingModule
  ]
})
export class TechnicienModule { }
