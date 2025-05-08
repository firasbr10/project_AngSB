import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PanneRoutingModule } from './panne-routing.module';
import { PanneComponent } from './panne.component';


@NgModule({
  declarations: [
    PanneComponent
  ],
  imports: [
    CommonModule,
    PanneRoutingModule
  ]
})
export class PanneModule { }
