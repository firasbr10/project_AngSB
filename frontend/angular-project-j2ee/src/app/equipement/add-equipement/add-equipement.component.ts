import { Component } from '@angular/core';
import { EquipementService, Equipement } from '../../services/equipement.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-equipement',
  templateUrl: './add-equipement.component.html',
  styleUrls: ['./add-equipement.component.css']
})
export class AddEquipementComponent {
  equipement: Equipement = {
    nom: '',
    etat: '',
    dateAcquisition: new Date()
  };

  constructor(private equipementService: EquipementService, private router: Router) {}

  onSubmit() {
    this.equipementService.createEquipement(this.equipement).subscribe(() => {
      this.router.navigate(['/equipements']);
    });
  }
}
