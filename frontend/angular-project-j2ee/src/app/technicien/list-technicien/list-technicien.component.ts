import { Component, OnInit } from '@angular/core';
import { TechnicienService } from 'src/app/services/technicien.service';
import { Technicien } from 'src/app/models/technicien';

@Component({
  selector: 'app-list-technicien',
  templateUrl: './list-technicien.component.html',
  styleUrls: ['./list-technicien.component.css']
})
export class ListTechnicienComponent implements OnInit {
  techniciens: Technicien[] = [];
  errorMessage: string = ''; // Pour afficher les erreurs dans le template

  constructor(private technicienService: TechnicienService) { }

  ngOnInit(): void {
    this.getTechniciens();
  }

  // Récupérer tous les techniciens
  getTechniciens(): void {
    this.technicienService.getAllTechniciens().subscribe(
      (data: Technicien[]) => {
        this.techniciens = data;
        this.errorMessage = ''; // Reset des erreurs si tout va bien
      },
      (error) => {
        this.errorMessage = 'Erreur de récupération des techniciens';
        console.error('Erreur de récupération des techniciens', error);
      }
    );
  }

  // Supprimer un technicien
  deleteTechnicien(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce technicien ?')) {
      this.technicienService.deleteTechnicien(id).subscribe(
        () => {
          this.getTechniciens(); // Rafraîchir la liste après suppression
        },
        (error) => {
          this.errorMessage = 'Erreur lors de la suppression du technicien';
          console.error('Erreur lors de la suppression du technicien', error);
        }
      );
    }
  }
}
