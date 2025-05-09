import { Component, OnInit } from '@angular/core';
import { EquipementService, Equipement } from '../../services/equipement.service';

@Component({
  selector: 'app-list-equipement',
  templateUrl: './list-equipement.component.html',
  styleUrls: ['./list-equipement.component.css']
})
export class ListEquipementComponent implements OnInit {
  equipements: Equipement[] = [];

  constructor(private equipementService: EquipementService) {}

  ngOnInit(): void {
    this.equipementService.getEquipements().subscribe(data => {
      this.equipements = data;
    });
  }

  deleteEquipement(id: number) {
    this.equipementService.deleteEquipement(id).subscribe(() => {
      this.equipements = this.equipements.filter(eq => eq.id !== id);
    });
  }
}
