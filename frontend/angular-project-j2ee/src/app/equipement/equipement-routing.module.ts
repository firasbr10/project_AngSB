import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipementComponent } from './equipement.component';
import { AddEquipementComponent } from './add-equipement/add-equipement.component'; 
import { ListEquipementComponent } from './list-equipement/list-equipement.component';
import { AuthGuard } from '../auth/auth.guard';

const routes: Routes = [
  { path: '', component: EquipementComponent, canActivate: [AuthGuard] },
  { path: 'list', component: ListEquipementComponent},
  { path: 'add', component: AddEquipementComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EquipementRoutingModule { }
