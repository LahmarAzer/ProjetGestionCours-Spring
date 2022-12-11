package tn.esprit.gestion.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestion.Entite.Classe;
import tn.esprit.gestion.Entite.CoursClassroom;
import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Utilisateur;
import tn.esprit.gestion.Repository.ClasseRepository;
import tn.esprit.gestion.Repository.CoursClassroomRepository;
import tn.esprit.gestion.Repository.UtilsateurRepository;
@Service
@AllArgsConstructor
public class UtilisateurServiceIMP implements UtilisateurService {

    UtilsateurRepository utilsateurRepository;

    ClasseRepository classeRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilsateurRepository.save(utilisateur);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur utilisateur = utilsateurRepository.findById(idUtilisateur).orElse(null);
        Classe classe = classeRepository.findById(codeClasse).orElse(null);
        if (utilisateur != null && classe != null) {
            utilisateur.setClasse(classe);
            utilsateurRepository.save(utilisateur);
        }
    }

    //keyword
    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        Integer nb = utilsateurRepository.countUtilisateurByClasse_Niveau(nv);
        return nb;
    }

    //Java
    /*
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        int count=0;
        List<Utilisateur> u= utilisateurRepository.findAll();
        for (Utilisateur i: u) {
            if(i.getClasse().getNiveau().equals(nv)) {
                count++;
            }
        }

        return nbr;
        public Integer nbUtilisateursParNiveau(Niveau nv) {
            int count=0;
            List<Utilisateur> u= utilisateurRepository.findAll();
            for (Utilisateur i: u) {
                if(i.getClasse().getNiveau().equals(nv)) {
                    count++;
                }
            }

            return count;
}
*/


}