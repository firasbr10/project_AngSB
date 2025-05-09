import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TechnicienService } from 'src/app/services/technicien.service';
import { Technicien } from 'src/app/models/technicien';

@Component({
  selector: 'app-add-technicien',
  templateUrl: './add-technicien.component.html',
  styleUrls: ['./add-technicien.component.css']
})
export class AddTechnicienComponent {

  technicien: Technicien = new Technicien(0, '', '', '', '', true);

  constructor(private technicienService: TechnicienService, private router: Router) {}

  onSubmit(): void {
    this.technicienService.createTechnicien(this.technicien).subscribe({
      next: () => {
        alert('Technicien ajouté avec succès');
        this.router.navigate(['/technicien']);
      },
      error: (err) => {
        console.error('Erreur lors de l’ajout du technicien :', err);
        alert("Erreur d'ajout. Veuillez réessayer.");
      }
    });
  }
}
