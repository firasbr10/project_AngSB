// src/app/services/technicien.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Technicien } from '../models/technicien';

@Injectable({
  providedIn: 'root'
})
export class TechnicienService {

  private apiUrl = 'http://localhost:9092/api/techniciens'; 

  constructor(private http: HttpClient) { }

  // Récupérer tous les techniciens
  getAllTechniciens(): Observable<Technicien[]> {
    return this.http.get<Technicien[]>(this.apiUrl);
  }

  // Récupérer un technicien par son ID
  getTechnicienById(id: number): Observable<Technicien> {
    return this.http.get<Technicien>(`${this.apiUrl}/${id}`);
  }

  // Ajouter un nouveau technicien
  createTechnicien(technicien: Technicien): Observable<Technicien> {
    return this.http.post<Technicien>(this.apiUrl, technicien);
  }

  // Mettre à jour un technicien
  updateTechnicien(id: number, technicien: Technicien): Observable<Technicien> {
    return this.http.put<Technicien>(`${this.apiUrl}/${id}`, technicien);
  }

  // Supprimer un technicien
  deleteTechnicien(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
