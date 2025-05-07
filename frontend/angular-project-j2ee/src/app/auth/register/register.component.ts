import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  username = '';
  password = '';
  nom = '';
  competences = '';
  disponibilite = true;

  constructor(private authService: AuthService, private router: Router) {}

  onRegister() {
    const technicien = {
      username: this.username,
      password: this.password,
      nom: this.nom,
      competences: this.competences,
      disponibilite: this.disponibilite,
    };

    this.authService.register(technicien).subscribe({
      next: (res) => {
        console.log('Inscription réussie 🎉', res);
        this.router.navigate(['/login']); // Redirige vers la page de connexion
      },
      error: (err) => {
        console.error('Erreur lors de l’inscription ❌', err);
        alert('Erreur lors de l’inscription. Veuillez réessayer.');
      },
    });
  }
}
