import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';



@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent,
    MainLayoutComponent
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
