package tn.esprit.gestion.Service;

import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Utilisateur;

public interface UtilisateurService {
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);

    public Integer nbUtilisateursParNiveau(Niveau nv);

}
