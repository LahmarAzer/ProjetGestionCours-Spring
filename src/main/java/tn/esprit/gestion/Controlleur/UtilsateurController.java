package tn.esprit.gestion.Controlleur;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Utilisateur;
import tn.esprit.gestion.Service.UtilisateurService;
@AllArgsConstructor
@RestController
@RequestMapping("/utilisateur")
public class UtilsateurController {

    UtilisateurService utilisateurService;

    @PostMapping("/addutilisateur")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajouterUtilisateur(utilisateur);
    }
    @PostMapping("/affectusertoclasse/{idUtilisateur}/{codeClasse}")
    public void affecterUtilisateurToClasse(@PathVariable Integer idUtilisateur,@PathVariable Integer codeClasse){
        utilisateurService.affecterUtilisateurClasse(idUtilisateur, codeClasse);
    }
    @GetMapping("/nbrNiveaux/{nv}")
    public Integer NbrNiveaux (@PathVariable Niveau nv){
        return utilisateurService.nbUtilisateursParNiveau(nv);
    }
}
