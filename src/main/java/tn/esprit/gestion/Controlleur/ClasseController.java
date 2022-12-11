package tn.esprit.gestion.Controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestion.Entite.Classe;
import tn.esprit.gestion.Service.ClasseService;

@RestController
@RequestMapping("/classe")
public class ClasseController {
    @Autowired
    ClasseService classeService;

    @PostMapping("/addclasse")
    public Classe ajouterClasse(@RequestBody Classe c){
        return classeService.ajouterClasse(c);
    }
}
