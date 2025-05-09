import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EquipementRoutingModule } from './equipement-routing.module';
import { EquipementComponent } from './equipement.component';
import { ListEquipementComponent } from './list-equipement/list-equipement.component';
import { AddEquipementComponent } from './add-equipement/add-equipement.component';


@NgModule({
  declarations: [
    EquipementComponent,
    ListEquipementComponent,
    AddEquipementComponent
  ],
  imports: [
    CommonModule,
    EquipementRoutingModule,
    FormsModule
  ]
})
export class EquipementModule { }
