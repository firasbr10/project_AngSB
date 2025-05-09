import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainLayoutComponent } from './shared/main-layout/main-layout.component';

//import { ListTechnicienComponent } from './technicien/list-technicien/list-technicien.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  {
    path: '',
    component: MainLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      
      { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
      { path: 'panne', loadChildren: () => import('./panne/panne.module').then(m => m.PanneModule), canActivate: [AuthGuard] },
      { path: 'intervention', loadChildren: () => import('./intervention/intervention.module').then(m => m.InterventionModule), canActivate: [AuthGuard] },
      { path: 'technicien', loadChildren: () => import('./technicien/technicien.module').then(m => m.TechnicienModule), canActivate: [AuthGuard] },
      //{ path: 'technicien/list', component: ListTechnicienComponent, canActivate: [AuthGuard] }, 
      { path: 'equipement', loadChildren: () => import('./equipement/equipement.module').then(m => m.EquipementModule), canActivate: [AuthGuard] },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    ]
  },

  { path: '**', redirectTo: 'login' }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
