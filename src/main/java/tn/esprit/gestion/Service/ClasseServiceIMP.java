package tn.esprit.gestion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestion.Entite.Classe;
import tn.esprit.gestion.Repository.ClasseRepository;

@Service
public class ClasseServiceIMP implements ClasseService {
    @Autowired
   ClasseRepository classeRepository;

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepository.save(c);
    }
}



