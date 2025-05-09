import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../services/dashboard.service';
import { ChartConfiguration } from 'chart.js'; // Import de Chart.js

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  stats: any = {};

  // Déclaration des options pour le graphique
  public barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: true,
    maintainAspectRatio: false,  // Permet de contrôler la taille du graphique
    plugins: {
      legend: {
        display: true,
      },
    },
    scales: {
      y: {
        beginAtZero: true, // Commence à zéro sur l'axe Y
      }
    }
  };

  // Labels pour le graphique
  public barChartLabels: string[] = ['Techniciens', 'Équipements', 'Pannes', 'Interventions'];

  // Déclaration des données du graphique avec des couleurs personnalisées
  public barChartData: { data: number[], label: string, backgroundColor: string[] }[] = [];

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.dashboardService.getDashboardData().subscribe(data => {
      this.stats = data;

      // Mise à jour des données du graphique en fonction des statistiques récupérées
      this.barChartData = [
        { 
          data: [this.stats.totalTechniciens, this.stats.totalEquipements, this.stats.totalPannes, this.stats.totalInterventions], 
          label: 'Total',
          backgroundColor: ['#FF5733', '#33FF57', '#3357FF', '#F5A623'] // Couleurs personnalisées pour chaque barre
        }
      ];
    });
  }
}
