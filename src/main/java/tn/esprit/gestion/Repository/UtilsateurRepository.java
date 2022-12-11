package tn.esprit.gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Utilisateur;

public interface UtilsateurRepository extends JpaRepository<Utilisateur,Integer> {
     Integer countUtilisateurByClasse_Niveau(Niveau nv);
}
