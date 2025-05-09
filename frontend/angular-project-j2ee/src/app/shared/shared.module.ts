// shared.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { RouterModule } from '@angular/router';
@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent,
    MainLayoutComponent
  ],
  imports: [
    CommonModule ,
    RouterModule
  ],
  exports: [  
    NavbarComponent,
    SidebarComponent,
    MainLayoutComponent
  ]
})
export class SharedModule { }
