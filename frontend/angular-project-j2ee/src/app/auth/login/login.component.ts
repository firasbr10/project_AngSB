import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  onLogin() {
    const credentials = {
      username: this.username,
      password: this.password,
    };

    this.authService.login(credentials).subscribe({
      next: (res) => {
        console.log('Connexion réussie 🎉', res);
        this.router.navigate(['/dashboard']); // Redirige vers le tableau de bord
      },
      error: (err) => {
        console.error('Erreur lors de la connexion ❌', err);
        alert('Nom d’utilisateur ou mot de passe incorrect.');
      },
    });
  }
}
