import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TechnicienComponent } from './technicien.component';
import { AddTechnicienComponent } from './add-technicien/add-technicien.component'; 
import { ListTechnicienComponent } from './list-technicien/list-technicien.component';
import { AuthGuard } from '../auth/auth.guard'; 

const routes: Routes = [
  { path: '', component: TechnicienComponent, canActivate: [AuthGuard] },
  { path: 'list', component: ListTechnicienComponent},
  { path: 'add', component: AddTechnicienComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TechnicienRoutingModule { }
