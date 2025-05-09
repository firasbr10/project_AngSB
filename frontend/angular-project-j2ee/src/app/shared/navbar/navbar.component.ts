import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  isLoggedIn = false;

  constructor(private authService: AuthService, private router: Router) {
    // Vérifier si l'utilisateur est connecté
    this.checkLoginStatus();
  }

  // Méthode pour vérifier le statut de connexion
  checkLoginStatus() {
    this.isLoggedIn = !!localStorage.getItem('auth_token'); // Exemple de vérification du token
  }

  // Méthode pour gérer la connexion
  login() {
    this.router.navigate(['/login']);
  }

  // Méthode pour gérer l'inscription
  register() {
    this.router.navigate(['/register']);
  }

  // Méthode pour gérer la déconnexion
  logout() {
    localStorage.removeItem('auth_token');
    this.isLoggedIn = false;
    this.router.navigate(['/login']);
  }
}
