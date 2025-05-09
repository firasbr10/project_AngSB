import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrlRegister = 'http://localhost:9092/api/techniciens'; 
  private apiUrlLogin = 'http://localhost:9092/api/auth/login'; 

  constructor(private http: HttpClient, private router: Router) {}

  // Méthode pour l'enregistrement
  register(userData: any): Observable<any> {
    return this.http.post(this.apiUrlRegister, userData);
  }

  // Méthode pour la connexion
  login(credentials: any): Observable<any> {
    return this.http.post(this.apiUrlLogin, credentials);
  }
  // Méthode pour la déconnexion
  logout(): void {
    localStorage.removeItem('token'); 
    this.router.navigate(['/login']); 
  }
}
