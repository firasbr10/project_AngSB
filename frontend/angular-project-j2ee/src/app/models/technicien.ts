export class Technicien {
    id: number;
  username: string;
  password: string;
  nom: string;
  competences: string;
  disponibilite: boolean;

  constructor(id: number, username: string, password: string, nom: string, competences: string, disponibilite: boolean) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.nom = nom;
    this.competences = competences;
    this.disponibilite = disponibilite;
  }
}
