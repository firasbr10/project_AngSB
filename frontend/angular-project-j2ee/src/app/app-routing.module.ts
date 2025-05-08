import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainLayoutComponent } from './shared/main-layout/main-layout.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  {
    path: '',
    component: MainLayoutComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'panne', loadChildren: () => import('./panne/panne.module').then(m => m.PanneModule) },
      { path: 'intervention', loadChildren: () => import('./intervention/intervention.module').then(m => m.InterventionModule) },
      { path: 'technicien', loadChildren: () => import('./technicien/technicien.module').then(m => m.TechnicienModule) },
      { path: 'equipement', loadChildren: () => import('./equipement/equipement.module').then(m => m.EquipementModule) },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' } // redirection vers dashboard après login
    ]
  },

  { path: '**', redirectTo: 'login' } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
