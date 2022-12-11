package tn.esprit.gestion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestion.Entite.Classe;
import tn.esprit.gestion.Entite.CoursClassroom;
import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Specialite;
import tn.esprit.gestion.Repository.ClasseRepository;
import tn.esprit.gestion.Repository.CoursClassroomRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CoursClassroomServiceIMP implements CoursClassroomService{
    @Autowired
    CoursClassroomRepository coursClassroomRepository ;
    @Autowired
    ClasseRepository classeRepository;


    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe classe = classeRepository.findById(codeClasse).orElse(null);
        if (classe != null){
            CoursClassroom coursClassroom = coursClassroomRepository.save(cc);
            coursClassroom.setClasse(classe);
            return coursClassroomRepository.save(cc);
        }
        return null;
    }

    @Transactional
    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom coursClassroom = coursClassroomRepository.findById(idCours).orElse(null);
        if(coursClassroom != null){
            coursClassroom.setClasse(null);
        }
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    @Override
    public void archiverCoursClassrooms() {
        List<CoursClassroom> coursClassrooms = coursClassroomRepository.findAll();
        /*for (CoursClassroom cs : coursClassrooms){
            cs.setArchive(true);
        }*/
        coursClassrooms.stream().
                forEach(CoursClassroom -> CoursClassroom.setArchive(true));

    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        List<CoursClassroom> coursClassrooms = coursClassroomRepository.findAll();

        Integer nbHeures=0;
        nbHeures=coursClassrooms.stream().
                filter(CoursClassroom -> CoursClassroom.getSpecialite().equals(sp)&&
                CoursClassroom.getClasse().getNiveau().equals(nv))
                .mapToInt(CoursClassroom::getNbHeures).sum();

        /*
        for (CoursClassroom cs:coursClassrooms) {
            if ((cs.getSpecialite().equals(sp))&&(cs.getClasse().getNiveau().equals(nv))){
                nbHeures=nbHeures+cs.getNbHeures();
            }
        }*/
        return nbHeures;
    }


}
